package ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.service;

import org.springframework.stereotype.Service;

import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.repository.RequisitoActoNotarialRepository;
import java.util.List;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.Modelo.RequisitoActoNotarial;

@Service
public class RequisitoActoNotarialService {
	
	
	
	public  RequisitoActoNotarialRepository requisitoActoNotarialRepository;

	public RequisitoActoNotarialService(RequisitoActoNotarialRepository requisitoActoNotarialRepository) {
		super();
		this.requisitoActoNotarialRepository = requisitoActoNotarialRepository;
	}
	
	
	
	public List<RequisitoActoNotarial>  getRequisitosActosNotarialesId(Long id)
	
	{
		List<RequisitoActoNotarial>  listRequisitos = requisitoActoNotarialRepository.findByIdActoNotarial(id);
		
		return listRequisitos;
		
	}
	
	
	

	
	
	
	
	
	
	

}
