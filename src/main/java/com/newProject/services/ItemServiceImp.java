package com.newProject.services;

//import com.newProject.data.models.Item;
import com.newProject.data.models.Item;
import com.newProject.data.models.TrackingInfo;
import com.newProject.data.models.TrackingInfosImp;
import com.newProject.data.repositories.Items;
import com.newProject.data.repositories.TrackingInfos;
import com.newProject.dtos.requests.SendItemRequest;
import com.newProject.dtos.responses.SendItemResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

import static com.newProject.utils.Mapper.map;

@Service
@Slf4j
public class ItemServiceImp implements ItemService {
    @Autowired
    private Items items;
    @Autowired
    private TrackingInfos trackingInfos;

    @Override
    public SendItemResponse sendItem(SendItemRequest sendItemRequest) {
        Item item = map(sendItemRequest);
        addTrackingInfoFor(item, String.format("%s sent a package to %s", item.getSenderName(), item.getReceiverName()));
        return map(items.save(item));
    }

    private void addTrackingInfoFor(Item item, String info) {
        Optional<TrackingInfosImp> optionalTrackingInfos = trackingInfos.findByItemId(item.getId());
        if(optionalTrackingInfos.isPresent()){
            log.info("i reach here");
            TrackingInfo trackingInfo = new TrackingInfo();
            trackingInfo.setDateCreated(LocalDateTime.now());
            trackingInfo.setDescription(info);
            optionalTrackingInfos.get().getTrackingInfos().add(trackingInfo);
            trackingInfos.save(optionalTrackingInfos.get());
        }
        else {
            TrackingInfosImp infos = new TrackingInfosImp();
            TrackingInfo trackingInfo = new TrackingInfo();
            trackingInfo.setDateCreated(LocalDateTime.now());
            trackingInfo.setDescription(info);
            infos.getTrackingInfos().add(trackingInfo);

            infos.setTrackingId(items.save(item).getId());
            item.setTrackingInfos(trackingInfos.save(infos));
            items.save(item);

        }
    }
}
