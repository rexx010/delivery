package com.newProject.utils;

import com.newProject.data.models.Item;
import com.newProject.dtos.requests.SendItemRequest;
import com.newProject.dtos.responses.SendItemResponse;

import java.time.format.DateTimeFormatter;

public class Mapper {
    public static Item map(SendItemRequest sendItemRequest) {
        Item item = new Item();
        item.setItemDescription(sendItemRequest.getItemDescription());
        item.setWeightInGrams(sendItemRequest.getWeightInGrams());
        item.setSenderName(sendItemRequest.getSenderName());
        item.setReceiverName(sendItemRequest.getReceiverName());
        item.setContactPhoneNumber(sendItemRequest.getContactPhoneNumber());
        return item;
    }

    public static SendItemResponse map(Item item) {
        SendItemResponse response = new SendItemResponse();
//        response.setId(item.getId());
        response.setTrackingNumber(item.getId());
        response.setItemDescription(item.getItemDescription());
        response.setWeightInGrams(item.getWeightInGrams());
        response.setSenderName(item.getSenderName());
        response.setReceiverName(item.getReceiverName());
        response.setContactPhoneNumber(item.getContactPhoneNumber());
        response.setDateSent(DateTimeFormatter.ofPattern("EEE, dd MM, yyyy, hh:mm:ss a"));
        return response;
    }
}
