package com.lppz.cloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.lppz.cloud.api.entities.RespData;
import com.lppz.cloud.service.DataChannelService;

import com.lppz.cloud.api.entities.DataChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 此入口就是我们当前微服务的统一入口
 * consumer-feign需要的商品数据，都要从该入口
 * 统一获取。
 */
@RestController
public class DataChannelController {
    private static final Logger logger= LoggerFactory.getLogger(DataChannelController.class);
    @Autowired
    DataChannelService dataChannelService;//此处只是服务的调用样例，未来这里会集中很多关于商品数据的service
    // 原函数
    @SentinelResource(value = "getDataChannelById")
    @GetMapping("/channel/{id}")
    public RespData getDataChannelById(@PathVariable("id") int id) {
        DataChannel dc= dataChannelService.getDataChannelById(id);
        RespData res=RespData.getDefaultSuccRespData();
        if(null!=dc){
            res.setData(dc);
        }
        return res;
    }
    @SentinelResource(value = "insertDataChannel")
    @PostMapping("/channel")
    public RespData insertDataChannel(DataChannel dataChannel){

        DataChannel newdataChannel = null;
        RespData res=RespData.getDefaultSuccRespData();
        try {
            newdataChannel = dataChannelService.insertDataChannel(dataChannel);
            res.setData(newdataChannel);
        } catch (Exception e) {
            e.printStackTrace();
//            throw  new MyException("2000",e.getMessage());
            res.setMsg(e.getMessage());
            res.setCode(RespData.ERROR_CODE);
        }
        return res;
    }
    @SentinelResource(value = "deleteDataChannel")
    @PostMapping("/channel/delete")
    public RespData deleteDataChannel(DataChannel dataChannel) {
        RespData res=RespData.getDefaultSuccRespData();
        int cnt=0;
        try {
            cnt= dataChannelService.deleteDataChannel(dataChannel);
        } catch (Exception e) {
            e.printStackTrace();
            res.setMsg(e.getMessage());
            res.setCode(RespData.ERROR_CODE);
        }
        return res;
    }
    @SentinelResource(value = "updateDataChannel")
    @PostMapping("/channel/update")
    public RespData updateDataChannel(DataChannel dataChannel) {
        RespData res=RespData.getDefaultSuccRespData();
        int cnt=0;
        try {
            cnt= dataChannelService.updateDataChannel(dataChannel);
        } catch (Exception e) {
            e.printStackTrace();
            res.setMsg(e.getMessage());
            res.setCode(RespData.ERROR_CODE);
        }
        return res;
    }

}
