package com.ncedu.eventx.services.impl;

import com.ncedu.eventx.converters.EventTypesMapper;
import com.ncedu.eventx.models.DTO.EventTypeDTO;
import com.ncedu.eventx.models.entities.EventTypeEntity;
import com.ncedu.eventx.repositories.EventTypeRepository;
import com.ncedu.eventx.services.EventTypeService;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventTypeServiceImpl implements EventTypeService {

    @Autowired
    EventTypeRepository eventTypeRepository;

    EventTypesMapper eventTypesMapper = Mappers.getMapper(EventTypesMapper.class);

    @Override
    public boolean createEventType(EventTypeDTO eventTypeDTO) {
        EventTypeEntity eventTypeEntity = new EventTypeEntity();
        eventTypeEntity.setType(eventTypeDTO.getType());
        eventTypeRepository.save(eventTypeEntity);
        return true;
    }

    @Override
    public List<EventTypeDTO> getAllEventTypes() {
        List<EventTypeEntity> entityList = eventTypeRepository.findAll();
        return eventTypesMapper.getEventTypeDTOs(entityList);
    }
}
