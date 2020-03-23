package com.ncedu.eventx.converters;

import com.ncedu.eventx.models.DTO.RoleDTO;
import com.ncedu.eventx.models.entities.RoleEntity;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-03-22T22:01:18+0400",
    comments = "version: 1.3.0.Beta2, compiler: javac, environment: Java 13 (Oracle Corporation)"
)
public class UserRoleMapperImpl implements UserRoleMapper {

    @Override
    public RoleEntity toUserRoleEntity(RoleDTO roleDTO) {
        if ( roleDTO == null ) {
            return null;
        }

        RoleEntity roleEntity = new RoleEntity();

        roleEntity.setId( roleDTO.getId() );
        roleEntity.setName( roleDTO.getName() );

        return roleEntity;
    }

    @Override
    public RoleDTO toUserRoleDTO(RoleEntity roleEntity) {
        if ( roleEntity == null ) {
            return null;
        }

        RoleDTO roleDTO = new RoleDTO();

        roleDTO.setId( roleEntity.getId() );
        roleDTO.setName( roleEntity.getName() );

        return roleDTO;
    }
}
