package com.newProject.data.repositories;

import com.newProject.data.models.TrackingInfosImp;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


public interface TrackingInfos extends MongoRepository  <TrackingInfosImp, String>{
    Optional<TrackingInfosImp> findByItemId(String id);
}
