package com.ncedu.eventx.services.impl;

import com.ncedu.eventx.converters.UsersMapper;
import com.ncedu.eventx.models.DTO.PasswordChangeDTO;
import com.ncedu.eventx.models.DTO.UserDTO;

import com.ncedu.eventx.models.DTO.UserForUpdateDTO;


import com.ncedu.eventx.models.entities.RoleEntity;
import com.ncedu.eventx.models.entities.UserEntity;

import com.ncedu.eventx.repositories.RolesRepository;
import com.ncedu.eventx.repositories.UserRepository;
import com.ncedu.eventx.services.UsersService;
import org.hibernate.SessionFactory;
import org.mapstruct.factory.Mappers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.Blob;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Service

public class UsersServiceImpl implements UsersService, UserDetailsService {

    final UserRepository userRepository;
    final RolesRepository rolesRepository;
    final LobHelper lobHelper;

    final BCryptPasswordEncoder bCryptPasswordEncoder;

    UsersMapper usersMapper = Mappers.getMapper(UsersMapper.class);

    public UsersServiceImpl(UserRepository userRepository,
                            RolesRepository rolesRepository,
                            LobHelper lobHelper,
                            BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.rolesRepository = rolesRepository;
        this.lobHelper = lobHelper;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<UserEntity> userEntityList = userRepository.findAll();
        return usersMapper.toUserDTOList(userEntityList);
    }

    @Override
    public UserForUpdateDTO updatePassword(PasswordChangeDTO data) {
        UserEntity userEntity = userRepository.findById(data.getId());

        if (!bCryptPasswordEncoder.matches(data.getPassword(),userEntity.getPassword()))  return null;

        userEntity.setPassword(bCryptPasswordEncoder.encode(data.getNewPassword()));

        userRepository.save(userEntity);

        return usersMapper.toUserForUpdateDTO(userEntity);
    }

    @Override
    public UserForUpdateDTO savePicture(MultipartFile file, String username) throws IOException {
        UserEntity userEntity = userRepository.findByUsername(username);

        Blob blob = lobHelper.createBlob(file.getInputStream(),file.getSize());
        userEntity.setAvatarImg(blob);
        userRepository.save(userEntity);

        return usersMapper.toUserForUpdateDTO(userEntity);
    }

    @Override
     public boolean createRegisteredUser(UserDTO userDTO) {
        UserEntity userEntity = new UserEntity();
        RoleEntity role = rolesRepository.findByName("ROLE_USER");

        if(userRepository.findByUsername(userDTO.getUsername()) != null) {
            return false;
        }

        userEntity.setRole(role);
        userEntity.setEmail(userDTO.getEmail());
        userEntity.setUsername(userDTO.getUsername());
        userEntity.setName(userDTO.getName());

        userEntity.setPassword(bCryptPasswordEncoder.encode(userDTO.getPassword()));
        userEntity.setOrganizationName(userDTO.getOrganizationName());
        userEntity.setPositionName(userDTO.getPositionName());
        userEntity.setAvatarImg(null);

        userRepository.save(userEntity);
        return true;
    }

    @Override
    public UserForUpdateDTO updateUser(UserForUpdateDTO userDTO) {
        UserEntity userEntity = userRepository.findById(userDTO.getId());

        userEntity.setEmail(userDTO.getEmail());
        userEntity.setUsername(userDTO.getUsername());
        userEntity.setName(userDTO.getName());

        userEntity.setOrganizationName(userDTO.getOrganizationName());
        userEntity.setPositionName(userDTO.getPositionName());
        userEntity.setAvatarImg(null);

        userRepository.save(userEntity);

        return usersMapper.toUserForUpdateDTO(userEntity);
    }

    @Override
    public boolean deleteUser(int id) {
        userRepository.deleteById(id);
        return true;
    }

    @Override
    public UserDTO getUserByUsername(String username) {

        UserEntity user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username + "!!!!!!!!!!!!");
        }

        return usersMapper.toDTO(user);
    }

    @Override
    public UserEntity getUserById(int id) {
        return userRepository.findById(id);
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("Hello from hidden method");
        System.out.println("Username:" +username);
        UserEntity user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        User user1 = new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                true, true, true, true, getAuthorities("ROLE_USER"));

        System.out.println(user1);

        return user1;
    }

    private Collection<? extends GrantedAuthority> getAuthorities(String role) {

        return Arrays.asList(new SimpleGrantedAuthority(role));
    }


}
