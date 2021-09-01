package com.nikita.rest_api_chat.controller;

import com.nikita.rest_api_chat.dao.MessageRepository;
import com.nikita.rest_api_chat.dao.PersonRepository;
import com.nikita.rest_api_chat.dao.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private MessageRepository messageRepository;
}
