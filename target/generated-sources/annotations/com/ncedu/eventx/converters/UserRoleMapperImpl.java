package com.ncedu.eventx.converters;

import com.ncedu.eventx.models.DTO.UserRoleDTO;
import com.ncedu.eventx.models.entities.UserRoleEntity;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-03-22T17:24:35+0400",
    comments = "version: 1.3.0.Beta2, compiler: javac, environment: Java 13 (Oracle Corporation)"
)
public class UserRoleMapperImpl implements UserRoleMapper {

    @Override
    public UserRoleEntity toUserRoleEntity(UserRoleDTO userRoleDTO) {
        if ( userRoleDTO == null ) {
            return null;
        }

        UserRoleEntity userRoleEntity = new UserRoleEntity();

        userRoleEntity.setId( userRoleDTO.getId() );
        userRoleEntity.setName( userRoleDTO.getName() );

        return userRoleEntity;
    }

    @Override
    public UserRoleDTO toUserRoleDTO(UserRoleEntity userRoleEntity) {
        if ( userRoleEntity == null ) {
            return null;
        }

        UserRoleDTO userRoleDTO = new UserRoleDTO();

        userRoleDTO.setId( userRoleEntity.getId() );
        userRoleDTO.setName( userRoleEntity.getName() );

        return userRoleDTO;
    }
}
