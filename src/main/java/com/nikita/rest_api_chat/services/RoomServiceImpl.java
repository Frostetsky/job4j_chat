package com.nikita.rest_api_chat.services;

import com.nikita.rest_api_chat.dao.RoomRepository;
import com.nikita.rest_api_chat.entity.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomRepository roomRepository;

    @Override
    public Room saveOrUpdate(Room room) {
        return roomRepository.save(room);
    }

    @Override
    @Transactional
    public void delete(Room room) {
        roomRepository.delete(room);
    }

    @Override
    public Optional<Room> findById(int id) {
        return roomRepository.findById(id);
    }

    @Override
    public List<Room> findAll() {
        return roomRepository.findAll();
    }
}
