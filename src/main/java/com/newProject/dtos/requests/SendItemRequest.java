package com.newProject.dtos.requests;

import com.newProject.data.models.TrackingInfosImp;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.DBRef;

@Data
public class SendItemRequest {
//    private String itemName;
    private String itemDescription;
    private int weightInGrams;
    private String senderName;
    private String receiverName;
    private String contactPhoneNumber;
}
