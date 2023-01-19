package ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.controller;

import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.model.ActoNotarial;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.model.Reporte;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.service.ActoNotarialService;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRCsvExporter;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimpleWriterExporterOutput;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/reportes")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ReporteController {
    final
    ActoNotarialService data;

    public ReporteController(ActoNotarialService data) {
        this.data = data;
    }

    @GetMapping(value = "/{fileName}/{fileType}")
    public void download(
            @PathVariable String fileName,
            @PathVariable String fileType,
            HttpServletResponse response
    ) throws FileNotFoundException {
        exportAllFileData(
                fileName,
                fileType,
                this.extraerInformacion(),
                response);
    }

    private void exportAllFileData(String filename, String filetype, List<Reporte> list, HttpServletResponse response)
            throws FileNotFoundException {
        InputStream sourceJrxmlFile = this.getClass().getResourceAsStream("/ActosNotariales.jrxml");
        JasperPrint jasperPrint;
        ServletOutputStream outputStream;
        try {
            List<Reporte> dataList = new ArrayList<>(list);
            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(dataList);
            JasperReport jasperReport = JasperCompileManager.compileReport(sourceJrxmlFile);
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("dataSource", dataSource);
            jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
            if (filetype.equalsIgnoreCase("PDF")) {
                response.addHeader("Content-Disposition", "inline; filename=" + filename + ".pdf;");
                response.setContentType("application/octet-stream");
                outputStream = response.getOutputStream();
                JRPdfExporter exporter = new JRPdfExporter();
                exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
                exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(outputStream));
                exporter.exportReport();
            }
            if (filetype.equalsIgnoreCase("EXCEL")) {
                response.addHeader("Content-Disposition", "inline; filename=" + filename + ".xlsx;");
                response.setContentType("application/octet-stream");
                outputStream = response.getOutputStream();
                JRXlsxExporter exporter = new JRXlsxExporter();
                exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
                exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(outputStream));
                exporter.exportReport();
            }
            if (filetype.equalsIgnoreCase("CSV")) {
                response.addHeader("Content-Disposition", "inline; filename=" + filename + ".csv;");
                response.setContentType("application/octet-stream");
                outputStream = response.getOutputStream();
                JRCsvExporter exporter = new JRCsvExporter();
                exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
                exporter.setExporterOutput(new SimpleWriterExporterOutput(outputStream));
                exporter.exportReport();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private List<Reporte> extraerInformacion() {
        List<Reporte> dataSource = new ArrayList<>();
        Reporte reporteTest = new Reporte("TEST", "TEST", "TEST");
        dataSource.add(reporteTest);
        for (ActoNotarial actoNotarial : this.data.getActosNotarialesActivos()) {
            Reporte reporte = new Reporte();
            reporte.setNombreCatalogoActoNotarial(actoNotarial.getNombreCatalogoActoNotarial());
            reporte.setArticuloCatalogoActoNotarial(actoNotarial.getArticuloCatalogoActoNotarial());
            reporte.setNombreTipoLibro(actoNotarial.getIdTipoLibro().getNombreTipoLibro());
            dataSource.add(reporte);
        }
        return dataSource;
    }
}