package com.ncedu.eventx.services.impl;

import com.ncedu.eventx.models.DTO.EventItemDTO;
import com.ncedu.eventx.models.DTO.UserDTO;
import com.ncedu.eventx.models.entities.*;
import com.ncedu.eventx.repositories.EventItemRepository;
import com.ncedu.eventx.repositories.RolesRepository;
import com.ncedu.eventx.repositories.UserEventItemRepository;
import com.ncedu.eventx.repositories.UserRepository;
import com.ncedu.eventx.services.EventItemService;
import com.ncedu.eventx.services.UserEventItemService;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.ncedu.eventx.enums.UserRoleItems.SPEAKER;
import static com.ncedu.eventx.enums.UserRoleItems.VISITOR;

@Service
public class UserEventItemServiceImpl implements UserEventItemService {

    final UserRepository userRepository;
    final RolesRepository rolesRepository;
    final UserEventItemRepository userEventItemRepository;
    final EventItemRepository eventItemRepository;
    final EventItemService eventItemService;

    public UserEventItemServiceImpl(UserRepository userRepository,
                                    RolesRepository rolesRepository,
                                    UserEventItemRepository eventItemRepository,
                                    EventItemRepository eventItemRepository1,
                                    EventItemService eventItemService) {
        this.userRepository = userRepository;
        this.rolesRepository = rolesRepository;
        this.userEventItemRepository = eventItemRepository;
        this.eventItemRepository = eventItemRepository1;
        this.eventItemService = eventItemService;
    }

    @Override
    public List<UserEventItemEntity> getAll() {
        return null;
    }

    @Override
    public boolean createEventItem(EventItemDTO eventItemDTO, UserDTO user) {
        UserEntity userEntity = userRepository.findById(user.getId());
        EventItemEntity eventItemEntity = eventItemService.createEventItem(eventItemDTO);
        RoleEntity roleEntity = rolesRepository.findByName(SPEAKER.getDescription());

        UserEventItemKey key = new UserEventItemKey(eventItemEntity.getId(),userEntity.getId(), roleEntity.getId());
        UserEventItemEntity entity = new UserEventItemEntity(key,userEntity,eventItemEntity, roleEntity,1);

        userEventItemRepository.save(entity);

        return true;
    }

    @Override
    public boolean addToFeatured(EventItemDTO itemDTO, UserDTO user) {
        EventItemEntity itemEntity = eventItemRepository.findById(itemDTO.getId());
        UserEntity userEntity = userRepository.findById(user.getId());
        RoleEntity roleEntity = rolesRepository.findByName(VISITOR.getDescription());

        UserEventItemKey key = new UserEventItemKey(itemEntity.getId(),userEntity.getId(), roleEntity.getId());
        UserEventItemEntity entity = new UserEventItemEntity(key,userEntity,itemEntity, roleEntity,1);

        userEventItemRepository.save(entity);

        return true;
    }
}
