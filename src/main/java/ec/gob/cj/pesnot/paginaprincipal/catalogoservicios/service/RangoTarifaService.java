package ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.model.RangoTarifa;
import ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.repository.RangoTarifaRepository;

@Service
public class RangoTarifaService {
	
	public RangoTarifaRepository rangoTarifarepo;
	
	public RangoTarifaService(RangoTarifaRepository rangoTarifaObjet)
	{
		super();
		this.rangoTarifarepo=rangoTarifaObjet;
	}
	
	public List<RangoTarifa> getRangoTarifa()
	{
		return rangoTarifarepo.findAll();
	}
	
	public RangoTarifa ingresarRangoTarifa(RangoTarifa rangoTafEntrante)
	{
		return rangoTarifarepo.save(rangoTafEntrante);
	}
	
	public Optional<RangoTarifa> getRangoTarifaById(Long id)
	{
		return rangoTarifarepo.findById(id);
	}
	public RangoTarifa getRangoTarifaByMinMax(BigDecimal max, BigDecimal min)
	{
		return rangoTarifarepo.getRangoByMinMax(max,min);
	}

}
