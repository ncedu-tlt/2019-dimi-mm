package com.ncedu.eventx.converters;

import com.ncedu.eventx.models.DTO.UserDTO;
import com.ncedu.eventx.models.DTO.UserRoleDTO;
import com.ncedu.eventx.models.entities.RoleEntity;
import com.ncedu.eventx.models.entities.UserEntity;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-03-22T17:24:36+0400",
    comments = "version: 1.3.0.Beta2, compiler: javac, environment: Java 13 (Oracle Corporation)"
)
public class UsersMapperImpl implements UsersMapper {

    @Override
    public UserDTO toDTO(UserEntity userEntity) {
        if ( userEntity == null ) {
            return null;
        }

        UserDTO userDTO = new UserDTO();

        userDTO.setId( userEntity.getId() );
        userDTO.setRoles( userRoleEntityListToUserRoleDTOList( userEntity.getRoles() ) );
        userDTO.setEmail( userEntity.getEmail() );
        userDTO.setPassword( userEntity.getPassword() );
        userDTO.setUsername( userEntity.getUsername() );
        userDTO.setOrganizationName( userEntity.getOrganizationName() );
        userDTO.setPositionName( userEntity.getPositionName() );
        userDTO.setAvatarImg( userEntity.getAvatarImg() );

        return userDTO;
    }

    @Override
    public UserEntity toUserEntity(UserDTO userDTO) {
        if ( userDTO == null ) {
            return null;
        }

        UserEntity userEntity = new UserEntity();

        userEntity.setId( userDTO.getId() );
        userEntity.setRoles( userRoleDTOListToUserRoleEntityList( userDTO.getRoles() ) );
        userEntity.setPassword( userDTO.getPassword() );
        userEntity.setUsername( userDTO.getUsername() );
        userEntity.setOrganizationName( userDTO.getOrganizationName() );
        userEntity.setPositionName( userDTO.getPositionName() );
        userEntity.setAvatarImg( userDTO.getAvatarImg() );
        userEntity.setEmail( userDTO.getEmail() );

        return userEntity;
    }

    @Override
    public List<UserDTO> toUserDTOList(List<UserEntity> userEntityList) {
        if ( userEntityList == null ) {
            return null;
        }

        List<UserDTO> list = new ArrayList<UserDTO>( userEntityList.size() );
        for ( UserEntity userEntity : userEntityList ) {
            list.add( toDTO( userEntity ) );
        }

        return list;
    }

    @Override
    public UserDTO toUserDTO(UserDTO userById) {
        if ( userById == null ) {
            return null;
        }

        UserDTO userDTO = new UserDTO();

        userDTO.setId( userById.getId() );
        List<UserRoleDTO> list = userById.getRoles();
        if ( list != null ) {
            userDTO.setRoles( new ArrayList<UserRoleDTO>( list ) );
        }
        userDTO.setEmail( userById.getEmail() );
        userDTO.setPassword( userById.getPassword() );
        userDTO.setPasswordConfirm( userById.getPasswordConfirm() );
        userDTO.setUsername( userById.getUsername() );
        userDTO.setOrganizationName( userById.getOrganizationName() );
        userDTO.setPositionName( userById.getPositionName() );
        userDTO.setAvatarImg( userById.getAvatarImg() );

        return userDTO;
    }

    protected UserRoleDTO userRoleEntityToUserRoleDTO(RoleEntity roleEntity) {
        if ( roleEntity == null ) {
            return null;
        }

        UserRoleDTO userRoleDTO = new UserRoleDTO();

        userRoleDTO.setId( roleEntity.getId() );
        userRoleDTO.setName( roleEntity.getName() );

        return userRoleDTO;
    }

    protected List<UserRoleDTO> userRoleEntityListToUserRoleDTOList(List<RoleEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<UserRoleDTO> list1 = new ArrayList<UserRoleDTO>( list.size() );
        for ( RoleEntity roleEntity : list ) {
            list1.add( userRoleEntityToUserRoleDTO(roleEntity) );
        }

        return list1;
    }

    protected RoleEntity userRoleDTOToUserRoleEntity(UserRoleDTO userRoleDTO) {
        if ( userRoleDTO == null ) {
            return null;
        }

        RoleEntity roleEntity = new RoleEntity();

        roleEntity.setId( userRoleDTO.getId() );
        roleEntity.setName( userRoleDTO.getName() );

        return roleEntity;
    }

    protected List<RoleEntity> userRoleDTOListToUserRoleEntityList(List<UserRoleDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<RoleEntity> list1 = new ArrayList<RoleEntity>( list.size() );
        for ( UserRoleDTO userRoleDTO : list ) {
            list1.add( userRoleDTOToUserRoleEntity( userRoleDTO ) );
        }

        return list1;
    }
}
