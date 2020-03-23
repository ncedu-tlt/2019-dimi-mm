package com.ncedu.eventx.converters;

import com.ncedu.eventx.models.DTO.RoleDTO;
import com.ncedu.eventx.models.DTO.UserDTO;
import com.ncedu.eventx.models.entities.RoleEntity;
import com.ncedu.eventx.models.entities.UserEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-03-22T22:01:18+0400",
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
        userDTO.setRoles( roleEntityListToRoleDTOList( userEntity.getRoles() ) );
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
        userEntity.setRoles( roleDTOListToRoleEntityList( userDTO.getRoles() ) );
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
        List<RoleDTO> list = userById.getRoles();
        if ( list != null ) {
            userDTO.setRoles( new ArrayList<RoleDTO>( list ) );
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

    protected RoleDTO roleEntityToRoleDTO(RoleEntity roleEntity) {
        if ( roleEntity == null ) {
            return null;
        }

        RoleDTO roleDTO = new RoleDTO();

        roleDTO.setId( roleEntity.getId() );
        roleDTO.setName( roleEntity.getName() );

        return roleDTO;
    }

    protected List<RoleDTO> roleEntityListToRoleDTOList(List<RoleEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<RoleDTO> list1 = new ArrayList<RoleDTO>( list.size() );
        for ( RoleEntity roleEntity : list ) {
            list1.add( roleEntityToRoleDTO( roleEntity ) );
        }

        return list1;
    }

    protected RoleEntity roleDTOToRoleEntity(RoleDTO roleDTO) {
        if ( roleDTO == null ) {
            return null;
        }

        RoleEntity roleEntity = new RoleEntity();

        roleEntity.setId( roleDTO.getId() );
        roleEntity.setName( roleDTO.getName() );

        return roleEntity;
    }

    protected List<RoleEntity> roleDTOListToRoleEntityList(List<RoleDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<RoleEntity> list1 = new ArrayList<RoleEntity>( list.size() );
        for ( RoleDTO roleDTO : list ) {
            list1.add( roleDTOToRoleEntity( roleDTO ) );
        }

        return list1;
    }
}
