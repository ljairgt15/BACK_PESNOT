package ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.controlador;

import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.Modelo.ReporteActosNotariales;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.Modelo.ReporteTarifas;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.Modelo.ActoNotarial;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.Modelo.RangoMotivo;
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
public class ReporteControlador {
    final ActoNotarialService dataActoNotarial;

    public ReporteControlador(ActoNotarialService data) {
        this.dataActoNotarial = data;
    }

    @GetMapping(value = "{type}/{fileType}")
    public void download(@PathVariable String fileType, @PathVariable String type, HttpServletResponse response) 
    		throws FileNotFoundException {
    	List<?> dataSource = null;
    	if (type.equalsIgnoreCase("ActoNotarial")) {
        	dataSource = this.extraerInformacionActosNotariales();
        } else if(type.equalsIgnoreCase("Tarifa")) {
        	dataSource = this.extraerInformacionTarifas();
        }
        exportAllFileData(
        		type,
                fileType,
                dataSource,
                response);
    }

    private void exportAllFileData(String type, String filetype, List<?> list, HttpServletResponse response)
            throws FileNotFoundException {
    	String filename = "reporte";
    	InputStream sourceJrxmlFile = null;
    	if (type.equalsIgnoreCase("ActoNotarial")) {
    		sourceJrxmlFile = this.getClass().getResourceAsStream("/ActosNotariales.jrxml");
        } else if(type.equalsIgnoreCase("Tarifa")) {
        	sourceJrxmlFile = this.getClass().getResourceAsStream("/Tarifas.jrxml");
        }
        JasperPrint jasperPrint;
        ServletOutputStream outputStream;
        try {
        	JasperReport jasperReport = JasperCompileManager.compileReport(sourceJrxmlFile);
            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(list);
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

    private List<ReporteActosNotariales> extraerInformacionActosNotariales() {
        List<ReporteActosNotariales> dataSource = new ArrayList<>();
        // Se agrega un registro previo para que se muestre correctamente todos los datos
        // Nose porque no se visualiza nunca el primer registro en el reporte por ello estas 2 lineas
        ReporteActosNotariales reporteTest = new ReporteActosNotariales("TEST", "TEST", "TEST");
        dataSource.add(reporteTest);
        for (ActoNotarial actoNotarial : this.dataActoNotarial.getActosNotarialesActivos()) {
        	ReporteActosNotariales reporte = new ReporteActosNotariales();
            reporte.setNombreCatalogoActoNotarial(actoNotarial.getNombreCatalogoActoNotarial());
            reporte.setArticuloCatalogoActoNotarial(actoNotarial.getArticuloCatalogoActoNotarial());
            reporte.setNombreTipoLibro(actoNotarial.getIdTipoLibro().getNombreTipoLibro());
            dataSource.add(reporte);
        }
        return dataSource;
    }
    
    private List<ReporteTarifas> extraerInformacionTarifas() {
        List<ReporteTarifas> dataSource = new ArrayList<>();
        // Se agrega un registro previo para que se muestre correctamente todos los datos
        // Nose porque no se visualiza nunca el primer registro en el reporte por ello estas 2 lineas
        ReporteTarifas reporteTest = new ReporteTarifas("TEST", "TEST", "TEST", true, "10.00", true);
        dataSource.add(reporteTest);
        for (RangoMotivo rangoMotivo : this.dataActoNotarial.getListaMostrar()) {
        	ReporteTarifas reporte = new ReporteTarifas();
            reporte.setNombreCatalogo(rangoMotivo.getActo().getNombreCatalogoActoNotarial());
            reporte.setArticuloCatalogo(rangoMotivo.getActo().getArticuloCatalogoActoNotarial());
            reporte.setNombreTipoLibro(rangoMotivo.getActo().getIdTipoLibro().getNombreTipoLibro());
            reporte.setEsTabla(rangoMotivo.getActo().getUsaCalculoTablaCatalogoActoNotarial());
            reporte.setValorCalculado(rangoMotivo.getPrecio());
            reporte.setEstadoCatalogo(rangoMotivo.getActo().getEstadoCatalogoActoNotarial());
            dataSource.add(reporte);
        }
        return dataSource;
    }
}