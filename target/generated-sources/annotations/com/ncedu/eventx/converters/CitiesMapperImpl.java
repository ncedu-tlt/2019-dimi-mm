package com.ncedu.eventx.converters;

import com.ncedu.eventx.models.DTO.CityDTO;
import com.ncedu.eventx.models.DTO.CityWithEventsDTO;
import com.ncedu.eventx.models.entities.CityEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-03-22T22:01:17+0400",
    comments = "version: 1.3.0.Beta2, compiler: javac, environment: Java 13 (Oracle Corporation)"
)
public class CitiesMapperImpl implements CitiesMapper {

    @Override
    public CityDTO toDTO(CityEntity cityEntity) {
        if ( cityEntity == null ) {
            return null;
        }

        CityDTO cityDTO = new CityDTO();

        cityDTO.setId( cityEntity.getId() );
        cityDTO.setAbbrev( cityEntity.getAbbrev() );
        cityDTO.setName( cityEntity.getName() );

        return cityDTO;
    }

    @Override
    public CityEntity toCityEntity(CityDTO cityDTO) {
        if ( cityDTO == null ) {
            return null;
        }

        CityEntity cityEntity = new CityEntity();

        cityEntity.setId( cityDTO.getId() );
        cityEntity.setAbbrev( cityDTO.getAbbrev() );
        cityEntity.setName( cityDTO.getName() );

        return cityEntity;
    }

    @Override
    public List<CityDTO> toCitiesDTO(List<CityEntity> cityEntityList) {
        if ( cityEntityList == null ) {
            return null;
        }

        List<CityDTO> list = new ArrayList<CityDTO>( cityEntityList.size() );
        for ( CityEntity cityEntity : cityEntityList ) {
            list.add( toDTO( cityEntity ) );
        }

        return list;
    }

    @Override
    public CityWithEventsDTO toCityWithEventsDTOs(CityEntity cityEntity) {
        if ( cityEntity == null ) {
            return null;
        }

        CityWithEventsDTO cityWithEventsDTO = new CityWithEventsDTO();

        cityWithEventsDTO.setId( cityEntity.getId() );
        cityWithEventsDTO.setAbbrev( cityEntity.getAbbrev() );
        cityWithEventsDTO.setName( cityEntity.getName() );

        return cityWithEventsDTO;
    }
}
