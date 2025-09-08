package com.newProject.services;

import com.newProject.data.models.Item;
import com.newProject.data.models.TrackingInfosImp;
import com.newProject.data.repositories.Items;
import com.newProject.data.repositories.TrackingInfos;
import com.newProject.dtos.requests.SendItemRequest;
import com.newProject.dtos.responses.SendItemResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ItemServiceImpTest {
    @Autowired
    private ItemService itemService;
    @Autowired
    private Items items;
    @Autowired
    private TrackingInfos trackingInfos;


    @BeforeEach
    public void setUp(){
        items.deleteAll();
        trackingInfos.deleteAll();
    }

    @Test
    public void sendItemTest(){
        SendItemRequest sendItemRequest = new SendItemRequest();
        itemService.sendItem(sendItemRequest);
        assertEquals(1, items.count());
    }
    @Test
    public void sendItem_RetrieveSentItemReturnSaveItemTest() {
        SendItemRequest sendItemRequest = new SendItemRequest();
        sendItemRequest.setItemDescription("Laptop");
        sendItemRequest.setWeightInGrams(2000);
        sendItemRequest.setSenderName("John Doe");
        sendItemRequest.setReceiverName("Jane Smith");
        sendItemRequest.setContactPhoneNumber("1234567890");

        SendItemResponse  response = itemService.sendItem(sendItemRequest);

        Item item = items.findItemsById(response.getTrackingNumber()).get();
        assertEquals("Laptop", response.getItemDescription());
        assertEquals(2000, response.getWeightInGrams());
        assertEquals("John Doe", response.getSenderName());
        assertEquals("Jane Smith", response.getReceiverName());
        assertEquals("1234567890", response.getContactPhoneNumber());
    }

    @Test
    public void sendItem_trackingInfoIsOneTest() {
        SendItemRequest sendItemRequest = new SendItemRequest();
        sendItemRequest.setItemDescription("Laptop");
        sendItemRequest.setWeightInGrams(2000);
        sendItemRequest.setSenderName("John Doe");
        sendItemRequest.setReceiverName("Jane Smith");
        sendItemRequest.setContactPhoneNumber("1234567890");

        SendItemResponse response = itemService.sendItem(sendItemRequest);
        assertEquals(1, trackingInfos.count());
    }

}