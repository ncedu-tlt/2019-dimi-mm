package com.ncedu.eventx.converters;

import com.ncedu.eventx.models.DTO.UserRoleDTO;
import com.ncedu.eventx.models.entities.RoleEntity;
import org.mapstruct.Mapper;

@Mapper
public interface UserRoleMapper {

    RoleEntity toUserRoleEntity(UserRoleDTO userRoleDTO);

    UserRoleDTO toUserRoleDTO(RoleEntity roleEntity);

}
