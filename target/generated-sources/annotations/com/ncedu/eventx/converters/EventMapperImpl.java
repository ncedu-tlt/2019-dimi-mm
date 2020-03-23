package com.ncedu.eventx.converters;

import com.ncedu.eventx.models.DTO.CityDTO;
import com.ncedu.eventx.models.DTO.CoordinatesDTO;
import com.ncedu.eventx.models.DTO.EventDTO;
import com.ncedu.eventx.models.DTO.EventItemDTO;
import com.ncedu.eventx.models.DTO.EventWithItemsDTO;
import com.ncedu.eventx.models.entities.CityEntity;
import com.ncedu.eventx.models.entities.CoordinatesEntity;
import com.ncedu.eventx.models.entities.EventEntity;
import com.ncedu.eventx.models.entities.EventItemEntity;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-03-22T22:01:18+0400",
    comments = "version: 1.3.0.Beta2, compiler: javac, environment: Java 13 (Oracle Corporation)"
)
public class EventMapperImpl implements EventMapper {

    @Override
    public EventDTO toDTO(EventEntity eventEntity) {
        if ( eventEntity == null ) {
            return null;
        }

        EventDTO eventDTO = new EventDTO();

        eventDTO.setId( eventEntity.getId() );
        eventDTO.setCity( cityEntityToCityDTO( eventEntity.getCity() ) );
        eventDTO.setName( eventEntity.getName() );
        eventDTO.setCoord( coordinatesEntityToCoordinatesDTO( eventEntity.getCoord() ) );
        eventDTO.setTimeStart( eventEntity.getTimeStart() );
        eventDTO.setTimeEnd( eventEntity.getTimeEnd() );
        eventDTO.setDescription( eventEntity.getDescription() );
        eventDTO.setAddress( eventEntity.getAddress() );

        return eventDTO;
    }

    @Override
    public List<EventDTO> toListDTO(List<EventEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<EventDTO> list1 = new ArrayList<EventDTO>( list.size() );
        for ( EventEntity eventEntity : list ) {
            list1.add( toDTO( eventEntity ) );
        }

        return list1;
    }

    @Override
    public EventEntity toEventEntity(EventDTO eventDTO) {
        if ( eventDTO == null ) {
            return null;
        }

        EventEntity eventEntity = new EventEntity();

        eventEntity.setId( eventDTO.getId() );
        eventEntity.setCity( cityDTOToCityEntity( eventDTO.getCity() ) );
        eventEntity.setCoord( coordinatesDTOToCoordinatesEntity( eventDTO.getCoord() ) );
        eventEntity.setAddress( eventDTO.getAddress() );
        eventEntity.setName( eventDTO.getName() );
        eventEntity.setDescription( eventDTO.getDescription() );
        eventEntity.setTimeStart( eventDTO.getTimeStart() );
        eventEntity.setTimeEnd( eventDTO.getTimeEnd() );

        return eventEntity;
    }

    @Override
    public EventWithItemsDTO toEventWithItemsDTO(EventEntity eventEntity) {
        if ( eventEntity == null ) {
            return null;
        }

        EventWithItemsDTO eventWithItemsDTO = new EventWithItemsDTO();

        eventWithItemsDTO.setItems( eventItemEntityListToEventItemDTOSet( eventEntity.getItems() ) );
        eventWithItemsDTO.setId( eventEntity.getId() );
        eventWithItemsDTO.setCity( cityEntityToCityDTO( eventEntity.getCity() ) );
        eventWithItemsDTO.setName( eventEntity.getName() );
        eventWithItemsDTO.setCoord( coordinatesEntityToCoordinatesDTO( eventEntity.getCoord() ) );
        eventWithItemsDTO.setTimeStart( eventEntity.getTimeStart() );
        eventWithItemsDTO.setTimeEnd( eventEntity.getTimeEnd() );
        eventWithItemsDTO.setDescription( eventEntity.getDescription() );
        eventWithItemsDTO.setAddress( eventEntity.getAddress() );

        return eventWithItemsDTO;
    }

    protected CityDTO cityEntityToCityDTO(CityEntity cityEntity) {
        if ( cityEntity == null ) {
            return null;
        }

        CityDTO cityDTO = new CityDTO();

        cityDTO.setId( cityEntity.getId() );
        cityDTO.setAbbrev( cityEntity.getAbbrev() );
        cityDTO.setName( cityEntity.getName() );

        return cityDTO;
    }

    protected CoordinatesDTO coordinatesEntityToCoordinatesDTO(CoordinatesEntity coordinatesEntity) {
        if ( coordinatesEntity == null ) {
            return null;
        }

        CoordinatesDTO coordinatesDTO = new CoordinatesDTO();

        coordinatesDTO.setId( coordinatesEntity.getId() );
        coordinatesDTO.setName( coordinatesEntity.getName() );
        coordinatesDTO.setPoint( coordinatesEntity.getPoint() );

        return coordinatesDTO;
    }

    protected CityEntity cityDTOToCityEntity(CityDTO cityDTO) {
        if ( cityDTO == null ) {
            return null;
        }

        CityEntity cityEntity = new CityEntity();

        cityEntity.setId( cityDTO.getId() );
        cityEntity.setAbbrev( cityDTO.getAbbrev() );
        cityEntity.setName( cityDTO.getName() );

        return cityEntity;
    }

    protected CoordinatesEntity coordinatesDTOToCoordinatesEntity(CoordinatesDTO coordinatesDTO) {
        if ( coordinatesDTO == null ) {
            return null;
        }

        CoordinatesEntity coordinatesEntity = new CoordinatesEntity();

        coordinatesEntity.setId( coordinatesDTO.getId() );
        coordinatesEntity.setName( coordinatesDTO.getName() );
        coordinatesEntity.setPoint( coordinatesDTO.getPoint() );

        return coordinatesEntity;
    }

    protected EventItemDTO eventItemEntityToEventItemDTO(EventItemEntity eventItemEntity) {
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

    protected Set<EventItemDTO> eventItemEntityListToEventItemDTOSet(List<EventItemEntity> list) {
        if ( list == null ) {
            return null;
        }

        Set<EventItemDTO> set = new HashSet<EventItemDTO>( Math.max( (int) ( list.size() / .75f ) + 1, 16 ) );
        for ( EventItemEntity eventItemEntity : list ) {
            set.add( eventItemEntityToEventItemDTO( eventItemEntity ) );
        }

        return set;
    }
}
