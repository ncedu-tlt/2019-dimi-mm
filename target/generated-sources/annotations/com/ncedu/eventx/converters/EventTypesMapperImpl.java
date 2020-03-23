package com.ncedu.eventx.converters;

import com.ncedu.eventx.models.DTO.EventTypeDTO;
import com.ncedu.eventx.models.entities.EventTypeEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-03-22T22:01:15+0400",
    comments = "version: 1.3.0.Beta2, compiler: javac, environment: Java 13 (Oracle Corporation)"
)
public class EventTypesMapperImpl implements EventTypesMapper {

    @Override
    public List<EventTypeDTO> getEventTypeDTOs(List<EventTypeEntity> eventTypeEntityList) {
        if ( eventTypeEntityList == null ) {
            return null;
        }

        List<EventTypeDTO> list = new ArrayList<EventTypeDTO>( eventTypeEntityList.size() );
        for ( EventTypeEntity eventTypeEntity : eventTypeEntityList ) {
            list.add( toEventTypeDTO( eventTypeEntity ) );
        }

        return list;
    }

    @Override
    public EventTypeEntity toEventTypeEntity(EventTypeDTO eventTypeDTO) {
        if ( eventTypeDTO == null ) {
            return null;
        }

        EventTypeEntity eventTypeEntity = new EventTypeEntity();

        eventTypeEntity.setId( eventTypeDTO.getId() );
        eventTypeEntity.setType( eventTypeDTO.getType() );

        return eventTypeEntity;
    }

    @Override
    public EventTypeDTO toEventTypeDTO(EventTypeEntity eventTypeEntity) {
        if ( eventTypeEntity == null ) {
            return null;
        }

        EventTypeDTO eventTypeDTO = new EventTypeDTO();

        eventTypeDTO.setId( eventTypeEntity.getId() );
        eventTypeDTO.setType( eventTypeEntity.getType() );

        return eventTypeDTO;
    }
}
