package com.ncedu.eventx.services.impl;

import com.ncedu.eventx.converters.UsersMapper;
import com.ncedu.eventx.models.DTO.UserDTO;
import com.ncedu.eventx.models.entities.UserEntity;
import com.ncedu.eventx.repositories.UserRepository;
import com.ncedu.eventx.services.UsersService;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    UserRepository userRepository;

    UsersMapper usersMapper = Mappers.getMapper(UsersMapper.class);

    @Override
    public List<UserDTO> getAllUsers() {
        List<UserEntity> userEntityList = userRepository.findAll();
        return usersMapper.toUserDTOList(userEntityList);
    }

    @Override
    public boolean createUser(UserDTO userDTO) {
        return true; //TODO
    }
}
