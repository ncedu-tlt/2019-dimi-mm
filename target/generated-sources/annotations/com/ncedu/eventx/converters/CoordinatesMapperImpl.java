package com.ncedu.eventx.converters;

import com.ncedu.eventx.models.DTO.CoordinatesDTO;
import com.ncedu.eventx.models.entities.CoordinatesEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-03-22T17:24:36+0400",
    comments = "version: 1.3.0.Beta2, compiler: javac, environment: Java 13 (Oracle Corporation)"
)
public class CoordinatesMapperImpl implements CoordinatesMapper {

    @Override
    public CoordinatesDTO toCoordinatesDTO(CoordinatesEntity entity) {
        if ( entity == null ) {
            return null;
        }

        CoordinatesDTO coordinatesDTO = new CoordinatesDTO();

        coordinatesDTO.setId( entity.getId() );
        coordinatesDTO.setName( entity.getName() );
        coordinatesDTO.setPoint( entity.getPoint() );

        return coordinatesDTO;
    }

    @Override
    public CoordinatesEntity toCoordinatesEntity(CoordinatesDTO coordinatesDTO) {
        if ( coordinatesDTO == null ) {
            return null;
        }

        CoordinatesEntity coordinatesEntity = new CoordinatesEntity();

        coordinatesEntity.setId( coordinatesDTO.getId() );
        coordinatesEntity.setName( coordinatesDTO.getName() );
        coordinatesEntity.setPoint( coordinatesDTO.getPoint() );

        return coordinatesEntity;
    }

    @Override
    public List<CoordinatesDTO> toCoordinatesDTOList(List<CoordinatesEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<CoordinatesDTO> list1 = new ArrayList<CoordinatesDTO>( list.size() );
        for ( CoordinatesEntity coordinatesEntity : list ) {
            list1.add( toCoordinatesDTO( coordinatesEntity ) );
        }

        return list1;
    }
}
