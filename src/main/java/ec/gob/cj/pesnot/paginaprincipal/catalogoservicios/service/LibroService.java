package ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.Modelo.AuditoriaAdministracionPesnot;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.Modelo.Libro;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.repository.AuditoriaAdministracionPesnotRepository;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.repository.LibroRepository;

@Service
public class LibroService {
	public LibroRepository libroRepository;
	public AuditoriaAdministracionPesnotRepository auditoriaRepo;

	//public LibroService(LibroRepository libroRepository, AuditoriaAdministracionPesnotRepository auditoriaRepo) {
    public LibroService(LibroRepository libroRepository) {
		super();
		this.libroRepository = libroRepository;
		//this.auditoriaRepo=auditoriaRepo;
	}

	public List<Libro> getLibros() {
		List<Libro> ListaLibros = new ArrayList<>();
		ListaLibros = libroRepository.findAll();
		return ListaLibros;
	}

	public List<Libro> getLibrosActivos() {
		return libroRepository.getAllActives();
	}

	public List<Libro> getLibrosWithActN() {
		return libroRepository.getAllLibrosWithActosN();
	}

	public Optional<Libro> getLibroByNombre(String adjuntoLibro) {
		return libroRepository.getLibroByNombre(adjuntoLibro);
	}

	public Libro ingresarLibrosL(Libro libro) {
		return libroRepository.save(libro);
	}

	public Optional<Libro> libroById(Long idEntrante) {
		return libroRepository.findById(idEntrante);
	}

	/*
	 * public Optional<Libro> ingresarAdministracion(Libro libroEntrante) {
	 * Optional<Libro> libroAntiguo =
	 * libroRepository.findById(libroEntrante.getIdTipoLibro()); String
	 * datosAntiguos = libroAntiguo.toString(); AuditoriaAdministracionPesnot audi =
	 * new AuditoriaAdministracionPesnot();
	 * 
	 * try { Libro libroNuevo = libroRepository.save(libroEntrante);
	 * 
	 * String datosNuevos = libroAntiguo.toString();
	 * audi.setNombreTabla(libroAntiguo.getClass().getSimpleName());
	 * audi.setAccion("MODIFICACIÓN"); audi.setValoresAnteriores(datosAntiguos);
	 * audi.setValoresActuales(datosNuevos); audi = auditoriaRepo.save(audi); return
	 * libroAntiguo; } catch (Exception e) {
	 * System.out.println(">>>> ERROR:JPAGenericDAO:update " + e); }
	 * 
	 * return null; }
	 */
}
