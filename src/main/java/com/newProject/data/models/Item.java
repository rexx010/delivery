package com.newProject.data.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Item {
    @Id
    private String id;
    private String itemName;
    private String itemDescription;
    private int weightInGrams;
    private String senderName;
    private String receiverName;
    private String contactPhoneNumber;

    @DBRef
    private TrackingInfosImp trackingInfos;
}
