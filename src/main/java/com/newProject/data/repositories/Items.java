package com.newProject.data.repositories;

import com.newProject.data.models.Item;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


public interface Items extends MongoRepository <Item, String>{
    Optional<Item> findItemsById(String id);

}
