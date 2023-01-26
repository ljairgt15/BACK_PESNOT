package ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.Modelo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.repository.ActoNotarialRepository;

@Service
public class ActoNotarialService {

    @Autowired
    public ActoNotarialRepository actoNotarialRepository;

    @Autowired
    private MotivoCobroCatalogoActoService motivoSvc;

    @Autowired
    private TablaTarifaCatalogoActoService tablaCatalogoSvc;

	@Autowired
	private TablaTarifaRangoService tablaRangoSvc;

	@Autowired
	private TablaTarifaService tablaSvc;

    @Autowired
    private BaseCobroActoService baseCobroService;

    @Autowired
    private LibroService libroSvc;

    @Autowired
    private MotivoCobroActoService motivoCobroActoSvc;

    public ActoNotarialService(ActoNotarialRepository actoNotarialRepository) {
        super();
        this.actoNotarialRepository = actoNotarialRepository;
    }

    public List<ActoNotarial> getActosNotariales() {
        List<ActoNotarial> ListActosNotariales = new ArrayList<>();

        ListActosNotariales = actoNotarialRepository.findAll();

        return ListActosNotariales;
    }

    public List<ActoNotarial> getActosNotarialesActivos() {
        List<ActoNotarial> ListActosNotariales = new ArrayList<>();

        ListActosNotariales = actoNotarialRepository.getActosActivos();

        return ListActosNotariales;
    }

    public ActoNotarial ingresarActoNotarialL(ActoNotarial actNot) {
        return actoNotarialRepository.save(actNot);
    }

    public Optional<ActoNotarial> getActoNotarialById(Long id) {

        Optional<ActoNotarial> actoNotarialTarifa = actoNotarialRepository.findById(id);

        return actoNotarialTarifa;
    }

    public List<ActoNotarial> getActosLike(String nombre) {

        List<ActoNotarial> ListaLike = new ArrayList<>();

        ListaLike = actoNotarialRepository.getActosLike(nombre);

        return ListaLike;
    }

    public List<ActoNotarial> getActosLibros(String libro) {

        List<ActoNotarial> ListaActosLibros = new ArrayList<>();

        ListaActosLibros = actoNotarialRepository.getActosByIdLibro(libro);

        return ListaActosLibros;
    }

    public ActoNotarial getActoByParametros(String nombreBase, String nombreLibro, String nombreActo) {
        BaseCobroActo base;
        base = baseCobroService.getBaseByNombre(nombreBase);
        String idBase;
        idBase = base.getIdBaseCobroActo().toString();
        // Long numero = 1l;
        // idBase=(numero.toString());

        // idClasificacion= numero.toString();

        Libro libro;
        libro = libroSvc.getLibroByNombre(nombreLibro);
        String idLibro;
        idLibro = libro.getIdTipoLibro().toString();
        // idLibro=numero.toString();

        // nombreActo="CATALOGO DE LA GACETA JUDICIAL";

        ActoNotarial actoBuscado = new ActoNotarial();
        actoBuscado = actoNotarialRepository.getActoUnico(nombreActo, idLibro, idBase);

        return actoBuscado;

    }

    // TRAE TODAS LOS ACTOS ASOCIADOS A UNA TABLA DE RANGOS, O A UN MOTIVO.
    public List<ActoNotarial> getActosConTarifas() {
        List<ActoNotarial> ListActosNotariales = new ArrayList<>();

        ListActosNotariales = actoNotarialRepository.getActosConTarifa();

        return ListActosNotariales;
    }

    // ----------------------------------------------------------------
    // TRAER TARIFA A PARTIR DE LOS ACTOS QUE SE MANEJAN POR DISTINTOS MOTIVOS
    // SOBRECARGA DE MÉTODOS

    public Double getTarifaActosMotivoconActo(ActoNotarial actoBuscado, String nombreMotivo) {
        System.out.println("Error" + nombreMotivo);
        MotivoCobroActo motivoBuscado = motivoCobroActoSvc.getMotivoUnico(nombreMotivo);
        MotivoCobroCatalogoActo actoMotivoBuscado = new MotivoCobroCatalogoActo();
        String idActo = actoBuscado.getIdCatalogoActoNotarial().toString();
        String idMotivo = motivoBuscado.getIdMotivoCobroActo().toString();
        actoMotivoBuscado = motivoSvc.getTarifa(idActo, idMotivo);
        return actoMotivoBuscado.getValorMotivoCobroCatalogoActo();

    }

    public Double getTarifaActosMotivoconId(String idActo, String idMotivo) {
        MotivoCobroCatalogoActo actoMotivoBuscado = new MotivoCobroCatalogoActo();
        actoMotivoBuscado = motivoSvc.getTarifa(idActo, idMotivo);
        return actoMotivoBuscado.getValorMotivoCobroCatalogoActo();

    }

    public Double getTarifaActosMotivo(String nombreBase, String nombreLibro, String nombreActo, String nombreMotivo) {
        ActoNotarial actoBuscado = this.getActoByParametros(nombreBase, nombreLibro, nombreActo);
        MotivoCobroActo motivoBuscado = motivoCobroActoSvc.getMotivoUnico(nombreMotivo);
        MotivoCobroCatalogoActo actoMotivoBuscado = new MotivoCobroCatalogoActo();
        String idActo = actoBuscado.getIdCatalogoActoNotarial().toString();
        String idMotivo = motivoBuscado.getIdMotivoCobroActo().toString();
        actoMotivoBuscado = motivoSvc.getTarifa(idActo, idMotivo);
        return actoMotivoBuscado.getValorMotivoCobroCatalogoActo();
    }

	public Double getTarifaActosTablaRango(String idActo, String idTabla, String idRango) {
        Double tarifa=null;
        try {
            TablaTarifaCatalogoActo actoTabla = new TablaTarifaCatalogoActo();
            actoTabla = tablaCatalogoSvc.getTablaActoUnico(idActo, idTabla);
            TablaTarifaRango tablaRango = new TablaTarifaRango();
            TablaTarifa tabla = new TablaTarifa();
            tabla = tablaSvc.getUnicoByNombre(actoTabla.getIdTablaTarifa().getNombreTablaTarifa());
            tablaRango = tablaRangoSvc.getTablaRangoUnico(tabla.getIdTablaTarifa().toString(), idRango);
            //TODO poner aqui el microservicio que llame a los parametros, swap 450
            tarifa=tablaRango.getPorcentajeTablaTarifaRango()*450;
            return tarifa;
        }
        catch (NullPointerException e) {
            System.out.println("No se pudo obtener las relaciones, asegurese que los parametros han sido enviados correctamente");
        }
        catch (Exception e) {
            System.out.println("ERROR GENERAL " + e);
            e.printStackTrace();
        }

        return tarifa;

	}

    // TRAER NOMBRE DE LA TABLA A PARTIR DE LOS ACTOS SE MANEJAN POR RANGOS
    public String getTablaActos(String idTabla, String idCatalogo) {
        TablaTarifaCatalogoActo tablaActoBuscado = new TablaTarifaCatalogoActo();
        try {
            tablaActoBuscado = tablaCatalogoSvc.getTablaActoUnico(idCatalogo, idTabla);
            if (tablaActoBuscado == null) {
                return null;
            } else {
                return tablaActoBuscado.getIdTablaTarifa().getNombreTablaTarifa();

            }

        } catch (NullPointerException err) {
            System.out.println(
                    "No se puede encontrar la tabla asociada a dicho catalogo, revise bien los parametros mandados "
                            + err);
        }
        return tablaActoBuscado.getIdTablaTarifa().getNombreTablaTarifa();
    }

    // TRAE UNA LISTA PERSONALIZADA PARA QUE SE PUEDA JUNTAR ATRIBUTOS COMUNES TANTO
    // DE TABLA MOTIVO, COMO DE TABLA DE RANGOS

    public List<RangoMotivo> getListaMostrar() {
        System.out.println("ENTRANDO A TARIFA");
        List<RangoMotivo> listadoPrecios = new ArrayList<RangoMotivo>();
        List<MotivoCobroCatalogoActo> listadoTarifasMotivo = new ArrayList<MotivoCobroCatalogoActo>();
        listadoTarifasMotivo = motivoSvc.getMotivoCobroCatalogo();
        System.out.println(listadoTarifasMotivo.size());

        List<TablaTarifaCatalogoActo> listadoTarifaRango = new ArrayList<TablaTarifaCatalogoActo>();
        listadoTarifaRango = tablaCatalogoSvc.getActoRangoTarifa();

        System.out.println("listadoTarifasMotivo");
        System.out.println(listadoTarifaRango.size());

        List<ActoNotarial> listadoActosActivos = this.getActosNotarialesActivos();
        List<ActoNotarial> listadoActosConTarifa = this.getActosConTarifas();
        List<ActoNotarial> listadoActosSinTarifa = new ArrayList<ActoNotarial>();

        System.out.println("activos"+listadoActosActivos.size());
        System.out.println("contarifa"+listadoActosConTarifa.size());

        List<Long> idsEnTarifas = new ArrayList<Long>();
        for (ActoNotarial id : listadoActosConTarifa) {
            idsEnTarifas.add(id.getIdCatalogoActoNotarial());
        }

        listadoActosSinTarifa = listadoActosActivos.stream()
                .filter(acto -> !idsEnTarifas.contains(acto.getIdCatalogoActoNotarial())).collect(Collectors.toList());

        System.out.println("listadoSinTarifa"+ listadoActosSinTarifa.size());
        try {
            for (MotivoCobroCatalogoActo tarifa : listadoTarifasMotivo) {
                if (tarifa.getEstadoMotivoCobroCatalogoActo()) {
                    RangoMotivo rangoNuevo = new RangoMotivo();
                    rangoNuevo.setId(tarifa.getIdMotivoCobroCatalogoActo());
                    rangoNuevo.setActo(tarifa.getIdCatalogoActoNotarial());
                    String precio = tarifa.getIdCatalogoActoNotarial().getTarifaCatalogoActoNotarial().toString();
                    System.out.println("precio" + precio);
                    rangoNuevo.setPrecio(precio);
                    listadoPrecios.add(rangoNuevo);
                }
            }

            for (TablaTarifaCatalogoActo tarifa : listadoTarifaRango) {
                if (tarifa.getEstadoActivo()) {
                    RangoMotivo rangoNuevo = new RangoMotivo();
                    rangoNuevo.setId(tarifa.getIdTablaTarifaCatalogoActo());
                    rangoNuevo.setActo(tarifa.getIdCatalogoActoNotarial());
                    rangoNuevo.setPrecio(tarifa.getIdTablaTarifa().getNombreTablaTarifa());
                    listadoPrecios.add(rangoNuevo);
                }
                //return listadoPrecios;
            }


            for (ActoNotarial actoSinTarifa : listadoActosSinTarifa) {
                RangoMotivo rangoNuevo = new RangoMotivo();
                rangoNuevo.setId(null);
                rangoNuevo.setActo(actoSinTarifa);
                rangoNuevo.setPrecio(null);
                listadoPrecios.add(rangoNuevo);
            }
            return listadoPrecios;
        }
        catch (NullPointerException e) {
            System.out.println("ERROR AL APUNTAR A UN ATRIBUTO NULL, REVISE LOS PARAMETROS MANDADOS");
            System.out.println("O BASE DE DATOS");
        }
        catch (Exception e) {
            System.out.println("ERROR GENERAL");
            e.printStackTrace();
        }
        return listadoPrecios;
    }

    // si es que la propieda usaCalculoTabla es falso debo llamar a la funcion
    // getTatarifasActosMotivo
    // si es que es true, getTarifaActoTabla
    // SIMILAR A LA FUNCION ANTERIOR SOLO QUE AQUÍ NO DEVUELVE UNA LISTA DEL
    // MAS BIEN DEVUELE EL CAMPO DONDE SE VERÁ LA TARIFA DE UN REGISTRO PARTICULAR
    public String getTarifaGeneral(String idCatalogo, Boolean usaCalculoTarifa, String idMotivo, String idTabla) {
        String tarifa = null;

        try {
            if (usaCalculoTarifa) {
                tarifa = this.getTablaActos(idTabla, idCatalogo);
            } else {

                tarifa = this.getTarifaActosMotivoconId(idCatalogo, idMotivo).toString();
            }

            return tarifa;
        } catch (NullPointerException err) {
            System.out.println(
                    "No se puede encontrar la tabla asociada a dicho catalogo, revise bien los parametros mandados "
                            + err);
        }
        return tarifa;
    }

}
