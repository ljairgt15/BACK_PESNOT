package ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.Modelo.Tarifa;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.repository.TarifaRepository;

@Service
public class TarifaService {	
	
	public TarifaRepository tarifaRepository;

	public TarifaService(TarifaRepository tarifaRepository) {
		super();
		this.tarifaRepository = tarifaRepository;
	}	
	
	public List<Tarifa> getTarifa (){		
		List<Tarifa> ListaTarifa = new ArrayList<>();		
		ListaTarifa = tarifaRepository.getTarifa();		
		return ListaTarifa;		
	}	
	
	public Tarifa ingresarTarifa(Tarifa tarifa)
	
	{
		return tarifaRepository.save(tarifa);				
	}

    }
