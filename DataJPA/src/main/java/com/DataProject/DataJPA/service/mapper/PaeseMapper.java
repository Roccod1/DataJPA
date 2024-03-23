package com.DataProject.DataJPA.service.mapper;

import org.mapstruct.Mapper;
import com.DataProject.DataJPA.service.dto.PaeseDTO;
import com.DataProject.DataJPA.domain.Paese;

@Mapper(componentModel = "spring")
public interface PaeseMapper extends EntityMapper<PaeseDTO, Paese>{

}
