package com.ncedu.eventx.converters;

import com.ncedu.eventx.models.DTO.EventItemDTO;
import com.ncedu.eventx.models.entities.EventItemEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-03-22T17:24:36+0400",
    comments = "version: 1.3.0.Beta2, compiler: javac, environment: Java 13 (Oracle Corporation)"
)
public class EventItemMapperImpl implements EventItemMapper {

    @Override
    public EventItemDTO toEventItemDTO(EventItemEntity eventItemEntity) {
        if ( eventItemEntity == null ) {
            return null;
        }

        EventItemDTO eventItemDTO = new EventItemDTO();

        eventItemDTO.setId( eventItemEntity.getId() );
        eventItemDTO.setName( eventItemEntity.getName() );
        eventItemDTO.setAuditory( eventItemEntity.getAuditory() );
        eventItemDTO.setTimeStart( eventItemEntity.getTimeStart() );

        return eventItemDTO;
    }

    @Override
    public List<EventItemDTO> toListDTO(List<EventItemEntity> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<EventItemDTO> list = new ArrayList<EventItemDTO>( entityList.size() );
        for ( EventItemEntity eventItemEntity : entityList ) {
            list.add( toEventItemDTO( eventItemEntity ) );
        }

        return list;
    }
}
