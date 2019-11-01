package com.example.springjmsreceiver.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springjmsreceiver.domain.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message, UUID> {

}
