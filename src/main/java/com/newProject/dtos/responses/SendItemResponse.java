package com.newProject.dtos.responses;

import com.newProject.data.models.TrackingInfosImp;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.format.DateTimeFormatter;

@Data
public class SendItemResponse {
//    private String itemName;
//    private String TrackingId;
    private String itemDescription;
    private int weightInGrams;
    private String senderName;
    private String receiverName;
    private String contactPhoneNumber;
    private String trackingNumber;
    private DateTimeFormatter dateSent;
}
