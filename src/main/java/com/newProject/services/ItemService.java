package com.newProject.services;

import com.newProject.dtos.requests.SendItemRequest;
import com.newProject.dtos.responses.SendItemResponse;

public interface ItemService {
    SendItemResponse sendItem(SendItemRequest sendItemRequest);
}
