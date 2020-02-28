package com.ncedu.eventx.models.DTO;

import lombok.*;

import java.util.Set;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EventWithUsersDTO {
    private EventDTO event;
    private Set<UserDTO> users;
    private int showOrder;

}
