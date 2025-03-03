package com.example.SpringBoot3.repositories;

import com.example.SpringBoot3.entities.MessageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.yaml.snakeyaml.events.Event;

@Repository
public interface GreetingRepository extends JpaRepository<MessageEntity, Event.ID> {


}
