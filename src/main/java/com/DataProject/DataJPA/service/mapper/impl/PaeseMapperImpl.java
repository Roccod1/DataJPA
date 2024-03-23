package com.DataProject.DataJPA.service.mapper.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.DataProject.DataJPA.domain.Aeroporto;
import com.DataProject.DataJPA.domain.Paese;
import com.DataProject.DataJPA.service.dto.AeroportoDTO;
import com.DataProject.DataJPA.service.dto.PaeseDTO;
import com.DataProject.DataJPA.service.mapper.PaeseMapper;

@Component
public class PaeseMapperImpl implements PaeseMapper{

	@Override
	public Paese toEntity(PaeseDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PaeseDTO toDto(Paese entity) {
		if ( entity == null ) {
			return null;
		}
		PaeseDTO paeseDTO = new PaeseDTO();
		List<AeroportoDTO> listAeroportoDTO= new ArrayList<>();
		AeroportoDTO aeroportoDTO =null;
		paeseDTO.setChiave(entity.getChiave());
		paeseDTO.setEn(entity.getEn());
		paeseDTO.setTipo(entity.getTipo());
		paeseDTO.setA2(entity.getId());
		
		for(Aeroporto a1 : entity.getAeroporti()) {
			aeroportoDTO = new AeroportoDTO();
			aeroportoDTO.setId(a1.getId());
			aeroportoDTO.setIata(a1.getIata());
			aeroportoDTO.setIcao(a1.getIcao());
			aeroportoDTO.setName(a1.getName());
			aeroportoDTO.setPaeseNome(a1.getPaeseNome());
			aeroportoDTO.setCountryCode(a1.getCountryCode());
			aeroportoDTO.setCitta(a1.getCitta());
			aeroportoDTO.setCity(a1.getCity());
			aeroportoDTO.setState(a1.getState());
			aeroportoDTO.setZoneName(a1.getZoneName());
			aeroportoDTO.setLatitude(a1.getLatitude());
			aeroportoDTO.setLongitude(a1.getLongitude());
			aeroportoDTO.setElevation(a1.getElevation());
			aeroportoDTO.setClasse(a1.getClasse());
			aeroportoDTO.setTipo(a1.getTipo());
			
			listAeroportoDTO.add(aeroportoDTO);		
		}
		paeseDTO.setAeroporti(listAeroportoDTO);
		return paeseDTO;
	}

	@Override
	public List<Paese> toEntity(List<PaeseDTO> dtoList) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PaeseDTO> toDto(List<Paese> entityList) {
		// TODO Auto-generated method stub
		return null;
	}

}
