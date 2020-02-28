package com.ncedu.eventx.services;
import com.ncedu.eventx.models.DTO.EventDTO;
import com.ncedu.eventx.models.DTO.EventWithUsersDTO;

import java.util.List;

public interface EventsService {
    boolean createEvent(EventDTO event);

    List<EventDTO> getEventsList();

    EventWithUsersDTO getEventById(int id);

    List<EventDTO> getEventsBySearchParams();// TODO

 }
