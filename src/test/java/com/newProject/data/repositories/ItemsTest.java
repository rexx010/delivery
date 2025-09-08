package com.newProject.data.repositories;

import com.newProject.data.models.Item;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import static org.junit.jupiter.api.Assertions.*;

@DataMongoTest
class ItemsTest {
    @Autowired
    private Items items;

    @Test
    public void testThatItemIsAddedToDatabase(){
        items.save(new Item());
        assertEquals(1, items.count());
        items.deleteAll();
    }

}