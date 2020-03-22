package com.ncedu.eventx.converters;

import com.ncedu.eventx.models.DTO.UserRoleDTO;
import com.ncedu.eventx.models.entities.RoleEntity;

import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-03-22T17:24:35+0400",
    comments = "version: 1.3.0.Beta2, compiler: javac, environment: Java 13 (Oracle Corporation)"
)
public class UserRoleMapperImpl implements UserRoleMapper {

    @Override
    public RoleEntity toUserRoleEntity(UserRoleDTO userRoleDTO) {
        if ( userRoleDTO == null ) {
            return null;
        }

        RoleEntity roleEntity = new RoleEntity();

        roleEntity.setId( userRoleDTO.getId() );
        roleEntity.setName( userRoleDTO.getName() );

        return roleEntity;
    }

    @Override
    public UserRoleDTO toUserRoleDTO(RoleEntity roleEntity) {
        if ( roleEntity == null ) {
            return null;
        }

        UserRoleDTO userRoleDTO = new UserRoleDTO();

        userRoleDTO.setId( roleEntity.getId() );
        userRoleDTO.setName( roleEntity.getName() );

        return userRoleDTO;
    }
}
