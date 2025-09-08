package com.newProject.data.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@Document
public class TrackingInfosImp {
    @Id
    private String trackingId;
    private String itemId;
    private List<TrackingInfo> trackingInfos = new ArrayList<>();
}
