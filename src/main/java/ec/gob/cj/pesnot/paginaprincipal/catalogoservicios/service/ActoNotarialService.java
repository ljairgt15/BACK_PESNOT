package ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.Modelo.ActoNotarial;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.Modelo.ActoRangoTarifa;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.Modelo.BaseCobroActo;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.Modelo.ClasificacionNumeroIntervinienteActo;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.Modelo.Libro;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.Modelo.MotivoCobroActo;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.Modelo.MotivoCobroCatalogoActo;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.Modelo.RangoMotivo;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.Modelo.RangoTarifa;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.repository.ActoNotarialRepository;

@Service
public class ActoNotarialService {
	
	@Autowired
	public ActoNotarialRepository actoNotarialRepository;

	@Autowired
	private MotivoCobroCatalogoActoService motivoSvc;

	@Autowired
	private ActoRangoTarifaService rangoSvc;
	
	@Autowired
	private BaseCobroActoService baseCobroService;
	
	@Autowired
	private LibroService libroSvc;
	
	@Autowired
	private ClasificacionNumeroIntervenienteActoService clasificacionSvc;
	
	@Autowired
	private MotivoCobroActoService motivoCobroActoSvc;
	@Autowired
	private RangoTarifaService rangoTSvc;
	
	

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
	
	public List<ActoNotarial> getActosConTarifas() {
		List<ActoNotarial> ListActosNotariales = new ArrayList<>();

		ListActosNotariales = actoNotarialRepository.getActosConTarifa();

		return ListActosNotariales;
	}
	
	public ActoNotarial getActoByParametros(String nombreBase, String nombreClasificacion, String nombreLibro, String nombreActo) {
		BaseCobroActo base;
		base= baseCobroService.getBaseByNombre(nombreBase);
		String idBase;
		idBase= base.getIdBaseCobroActo().toString();
		Long numero=1l;
		//idBase=(numero.toString());
		

		ClasificacionNumeroIntervinienteActo clasificacion;
		clasificacion= clasificacionSvc.getClasificacionByNombre(nombreClasificacion);
		String idClasificacion;
		idClasificacion= clasificacion.getIdClasificacionNumeroIntervinienteActo().toString();
		//idClasificacion= numero.toString();
		
		Libro libro;
		libro= libroSvc.getLibroByNombre(nombreLibro);
		String idLibro;
		idLibro= libro.getIdTipoLibro().toString();
		//idLibro=numero.toString();
		
		//nombreActo="CATALOGO DE LA GACETA JUDICIAL";
		
		ActoNotarial actoBuscado= new ActoNotarial();
		actoBuscado= actoNotarialRepository.getActoUnico(nombreActo, idLibro,idBase, idClasificacion);
		
		return actoBuscado;
		
	}
	
	public Double getTarifaActosMotivo( String nombreBase, String nombreClasificacion, String nombreLibro, String nombreActo, String nombreMotivo) {
		ActoNotarial actoBuscado=this.getActoByParametros(nombreBase, nombreClasificacion, nombreLibro, nombreActo);
		MotivoCobroActo motivoBuscado= motivoCobroActoSvc.getMotivoUnico(nombreMotivo);
		MotivoCobroCatalogoActo actoMotivoBuscado= new MotivoCobroCatalogoActo();
		String idActo= actoBuscado.getIdCatalogoActoNotarial().toString();
		String idMotivo= motivoBuscado.getIdMotivoCobroActo().toString();
		actoMotivoBuscado= motivoSvc.getTarifa(idActo, idMotivo);
		return actoMotivoBuscado.getValorMotivoCobroCatalogoActo();

	}
	
	public Double getTarifaActosTabla( String nombreBase, String nombreClasificacion, String nombreLibro, String nombreActo, Double max, Double min) {
		ActoNotarial actoBuscado=this.getActoByParametros(nombreBase, nombreClasificacion, nombreLibro, nombreActo);
		RangoTarifa rangoBuscado= rangoTSvc.getRangoTarifaByMinMax(max, min);
		ActoRangoTarifa actoRangoBuscado= new ActoRangoTarifa();
		String idActo= actoBuscado.getIdCatalogoActoNotarial().toString();
		String idRango= rangoBuscado.getIdRangoTarifa().toString();
		actoRangoBuscado= rangoSvc.getTarifa(idActo,idRango);
		return actoRangoBuscado.getPorcentajeActoRangoTarifa()*425;

	}
	public List<ActoNotarial> getActosLibros(String libro) {

		List<ActoNotarial> ListaActosLibros = new ArrayList<>();

		ListaActosLibros = actoNotarialRepository.getActosByIdLibro(libro);

		return ListaActosLibros;
	}

	public List<RangoMotivo> getActosPrecio() {
		List<RangoMotivo> listadoPrecios = new ArrayList<RangoMotivo>();
		List<MotivoCobroCatalogoActo> listadoTarifasMotivo = new ArrayList<MotivoCobroCatalogoActo>();
		listadoTarifasMotivo = motivoSvc.getMotivoCobroCatalogo();

		List<ActoRangoTarifa> listadoTarifaRango = new ArrayList<ActoRangoTarifa>();
		listadoTarifaRango = rangoSvc.getActoRangoTarifa();

		for (ActoRangoTarifa tarifa : listadoTarifaRango) {
			if (tarifa.getEstadoActoRangoTarifa()) {
				RangoMotivo rangoNuevo = new RangoMotivo();
				rangoNuevo.setId(tarifa.getIdActoRangoTarifa());
				rangoNuevo.setActo(tarifa.getIdCatalogoActoNotarial());
				rangoNuevo.setPrecio(tarifa.getPorcentajeActoRangoTarifa() * 425);
				listadoPrecios.add(rangoNuevo);
			}
		}

		for (MotivoCobroCatalogoActo tarifa : listadoTarifasMotivo) {
			if (tarifa.getEstadoMotivoCobroCatalogoActo()) {
				RangoMotivo rangoNuevo = new RangoMotivo();
				rangoNuevo.setId(tarifa.getIdMotivoCobroCatalogoActo());
				rangoNuevo.setActo(tarifa.getIdCatalogoActoNotarial());
				rangoNuevo.setPrecio(tarifa.getValorMotivoCobroCatalogoActo());
				listadoPrecios.add(rangoNuevo);
			}
		}

		return listadoPrecios;
	}
	
}
