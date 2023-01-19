package ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.model.ActoNotarial;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.model.ActoRangoTarifa;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.model.BaseCobroActo;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.model.Libro;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.model.MotivoCobroActo;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.model.MotivoCobroCatalogoActo;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.model.RangoMotivo;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.model.RangoTarifa;
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
	
	public ActoNotarial getActoByParametros(String nombreBase, String nombreLibro, String nombreActo) {
		BaseCobroActo base;
		base= baseCobroService.getBaseByNombre(nombreBase);
		String idBase;
		idBase= base.getIdBaseCobroActo().toString();
		Long numero=1l;
		//idBase=(numero.toString());
		
		//idClasificacion= numero.toString();
		
		Libro libro;
		libro= libroSvc.getLibroByNombre(nombreLibro);
		String idLibro;
		idLibro= libro.getIdTipoLibro().toString();
		//idLibro=numero.toString();
		
		//nombreActo="CATALOGO DE LA GACETA JUDICIAL";
		
		ActoNotarial actoBuscado= new ActoNotarial();
		actoBuscado= actoNotarialRepository.getActoUnico(nombreActo, idLibro,idBase);
		
		return actoBuscado;
		
	}
	
	//con la funcion obtengo mi acto notarial
	//obtengo el acto notarial y utilizo sus atributos
	// si es que la propieda usaCalculoTabla es falso debo llamar a la funcion getTatarifasActosMotivo
	// si es que es true, getTarifaActoTabla
	

	public Double getTarifaActosTablaConActo( ActoNotarial actoBuscado ,BigDecimal max, BigDecimal min) {
		System.out.println("rango servicio"+max);
		System.out.println("rango servicio"+min);
		RangoTarifa rangoBuscado= rangoTSvc.getRangoTarifaByMinMax(max, min);
		
		System.out.println(rangoBuscado);
		ActoRangoTarifa actoRangoBuscado= new ActoRangoTarifa();
		String idActo= actoBuscado.getIdCatalogoActoNotarial().toString();
		Long idRangoBuscado= rangoBuscado.getIdRangoTarifa();
		System.out.println("id" + idRangoBuscado);
		
		String idRango= rangoBuscado.getIdRangoTarifa().toString();
		System.out.println(idRango);
		System.out.println(idActo);
		actoRangoBuscado= rangoSvc.getActoRangoUnico(idActo,idRango);
		System.out.println("actoBuscado"+actoRangoBuscado);
		return actoRangoBuscado.getPorcentajeActoRangoTarifa()*425;

	}
	public Double getTarifaActosMotivoconActo(ActoNotarial actoBuscado , String nombreMotivo) {
		System.out.println("Error"+ nombreMotivo);
		MotivoCobroActo motivoBuscado= motivoCobroActoSvc.getMotivoUnico(nombreMotivo);
		MotivoCobroCatalogoActo actoMotivoBuscado= new MotivoCobroCatalogoActo();
		String idActo= actoBuscado.getIdCatalogoActoNotarial().toString();
		String idMotivo= motivoBuscado.getIdMotivoCobroActo().toString();
		actoMotivoBuscado= motivoSvc.getTarifa(idActo, idMotivo);
		return actoMotivoBuscado.getValorMotivoCobroCatalogoActo();

	}
	public Double getTarifaActosMotivo( String nombreBase, String nombreLibro, String nombreActo, String nombreMotivo) {
		ActoNotarial actoBuscado=this.getActoByParametros(nombreBase, nombreLibro, nombreActo);
		MotivoCobroActo motivoBuscado= motivoCobroActoSvc.getMotivoUnico(nombreMotivo);
		MotivoCobroCatalogoActo actoMotivoBuscado= new MotivoCobroCatalogoActo();
		String idActo= actoBuscado.getIdCatalogoActoNotarial().toString();
		String idMotivo= motivoBuscado.getIdMotivoCobroActo().toString();
		actoMotivoBuscado= motivoSvc.getTarifa(idActo, idMotivo);
		return actoMotivoBuscado.getValorMotivoCobroCatalogoActo();

	}
	
	
	public Double getTarifaActosTabla( String nombreBase,  String nombreLibro, String nombreActo, BigDecimal max, BigDecimal min) {
		ActoNotarial actoBuscado=this.getActoByParametros(nombreBase, nombreLibro, nombreActo);
		RangoTarifa rangoBuscado= rangoTSvc.getRangoTarifaByMinMax(max, min);
		ActoRangoTarifa actoRangoBuscado= new ActoRangoTarifa();
		String idActo= actoBuscado.getIdCatalogoActoNotarial().toString();
		String idRango= rangoBuscado.getIdRangoTarifa().toString();
		actoRangoBuscado= rangoSvc.getActoRangoUnico(idActo,idRango);
		return actoRangoBuscado.getPorcentajeActoRangoTarifa()*425;

	}
	
	
	public Double getTarifaGeneral(String nombreBase, String nombreLibro, String nombreActo, String nombreMotivo, BigDecimal max, BigDecimal min) {
		Double tarifa=null;
		ActoNotarial actoBuscado=this.getActoByParametros(nombreBase, nombreLibro, nombreActo);
		boolean usaCalculoTarifa= actoBuscado.getUsaCalculoTablaCatalogoActoNotarial();
		if(usaCalculoTarifa) {
			//tarifa=this.getTarifaActosTabla(nombreBase, nombreClasificacion, nombreLibro, nombreActo, max, min);
			tarifa= this.getTarifaActosTablaConActo(actoBuscado, max, min);
		}
		else {
			//tarifa= this.getTarifaActosMotivo(nombreBase, nombreClasificacion, nombreLibro, nombreActo, nombreMotivo);
			tarifa=this.getTarifaActosMotivoconActo(actoBuscado, nombreMotivo);
		}
		
		return tarifa;
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
				rangoNuevo.setPrecio(tarifa.getPorcentajeActoRangoTarifa() * 450);
				listadoPrecios.add(rangoNuevo);
			}
			return listadoPrecios;
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
