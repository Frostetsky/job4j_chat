package com.nikita.rest_api_chat.controller;

import com.nikita.rest_api_chat.entity.Message;
import com.nikita.rest_api_chat.entity.Person;
import com.nikita.rest_api_chat.entity.Room;
import com.nikita.rest_api_chat.services.MessageService;
import com.nikita.rest_api_chat.services.PersonService;
import com.nikita.rest_api_chat.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/person/{person_id}/room/{room_id}/message")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @Autowired
    private PersonService personService;

    @Autowired
    private RoomService roomService;

    @GetMapping("/")
    public List<Message> findAllMessages(@PathVariable int person_id,
                                         @PathVariable int room_id) {
        personService.findById(person_id).orElseThrow(NoSuchElementException::new);
        roomService.findById(room_id).orElseThrow(NoSuchElementException::new);
        return messageService.findAll();
    }

    @PostMapping("/")
    public Message addMessage(@PathVariable int person_id,
                              @PathVariable int room_id,
                              @RequestBody Message message) {
        Person person = personService.findById(person_id).orElseThrow(NoSuchElementException::new);
        Room room = roomService.findById(room_id).orElseThrow(NoSuchElementException::new);
        message.setRoom(room);
        message.setPerson(person);
        message.setCreated(LocalDateTime.now());
        return messageService.saveOrUpdate(message);
    }

    @PutMapping("/")
    public Message updateMessage(@PathVariable int person_id,
                                 @PathVariable int room_id,
                                 @RequestParam int id,
                                 @RequestBody Message update_text) {
        personService.findById(person_id).orElseThrow(NoSuchElementException::new);
        roomService.findById(room_id).orElseThrow(NoSuchElementException::new);
        Message message = messageService.findById(id).orElseThrow(NoSuchElementException::new);
        message.setMessage(update_text.getMessage());
        messageService.saveOrUpdate(message);
        return message;
    }

    @GetMapping("/{id}")
    public Message findMessageById(@PathVariable int person_id,
                                   @PathVariable int room_id,
                                   @PathVariable int id) {
        personService.findById(person_id).orElseThrow(NoSuchElementException::new);
        roomService.findById(room_id).orElseThrow(NoSuchElementException::new);
        Optional<Message> rsl = messageService.findById(id);
        if (rsl.isPresent()) {
            return rsl.get();
        } else {
            throw new NoSuchElementException("There is no Message with ID = " + id + " in DataBase");
        }
    }

    @DeleteMapping("/{id}")
    public void deleteMessageById(@PathVariable int person_id,
                                  @PathVariable int room_id,
                                  @PathVariable int id) {
        personService.findById(person_id).orElseThrow(NoSuchElementException::new);
        roomService.findById(room_id).orElseThrow(NoSuchElementException::new);
        Optional<Message> rsl = messageService.findById(id);
        rsl.ifPresent(message -> messageService.delete(message));
    }
}
