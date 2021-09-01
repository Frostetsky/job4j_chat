package com.nikita.rest_api_chat.controller;

import com.nikita.rest_api_chat.dao.PersonRepository;
import com.nikita.rest_api_chat.dao.RoomRepository;
import com.nikita.rest_api_chat.entity.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/person/{person_id}/room")
public class RoomController {

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private PersonRepository personRepository;

    @GetMapping("/")
    public List<Room> findAllPersonsRooms(@PathVariable int person_id) {
        personRepository.findById(person_id);
        return roomRepository.findAll();
    }

    @GetMapping("/{room_id}")
    public Room findRoomById(@PathVariable int person_id,
                             @PathVariable int room_id) {
        personRepository.findById(person_id);
        return roomRepository.findById(room_id).orElseThrow(NoSuchElementException::new);
    }
}
