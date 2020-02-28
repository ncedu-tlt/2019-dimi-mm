package com.ncedu.eventx.converters;

import com.ncedu.eventx.models.DTO.EventDTO;
import com.ncedu.eventx.models.entities.EventEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface EventMapper {

    EventDTO toDTO(EventEntity eventEntity);

    List<EventEntity> toListDTO(List<EventDTO> list);

}
