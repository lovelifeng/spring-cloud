package com.lppz.cloud.controller;

import com.lppz.cloud.api.entities.DataChannel;
import com.lppz.cloud.api.entities.RespData;
import com.lppz.cloud.api.service.DataChannelClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class DataChannelController_Feign {

    @Autowired
    private DataChannelClientService service;

    @RequestMapping(value = "/consumer/channel/{id}",method = RequestMethod.GET)
    public RespData getDataChannelById(@PathVariable("id") int id) {
        //去找微服务的入口地址，就是第二步里的@FeignClient(value="TAKEOUT3-PROVIDER-PRODUCT")的“/channel/{id}”
        return service.getDataChannelById(id);
    }
    @RequestMapping(value = "/consumer/channel",method = RequestMethod.POST)
    public RespData insertDataChannel(DataChannel dataChannel) throws Exception {
        return service.insertDataChannel(dataChannel);
    }
    @RequestMapping(value = "/consumer/channel/update",method = RequestMethod.POST)
    public RespData updateDataChannel(DataChannel dataChannel) throws Exception {

        return service.updateDataChannel(dataChannel);

    }
    @RequestMapping(value = "/consumer/channel/delete",method = RequestMethod.POST)
    public RespData deleteDataChannel(DataChannel dataChannel) throws Exception {

        return service.deleteDataChannel(dataChannel);

    }
}