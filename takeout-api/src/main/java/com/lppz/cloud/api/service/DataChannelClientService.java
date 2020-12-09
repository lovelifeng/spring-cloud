package com.lppz.cloud.api.service;

import com.lppz.cloud.api.entities.DataChannel;
import com.lppz.cloud.api.entities.RespData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 使用Feign的注解+接口的形式来进行服务调用
 */
//feign与注册入Eureka的微服务建立连接, 每一个地址有异常都会调用fallback中的同名方法做兜底

@FeignClient(value="takeout-product-provider",fallbackFactory = ApiServiceFallBackFactory.class)
public interface DataChannelClientService {
    //这里映射真正的业务DataChannelController入口地址：“/channel/{id}”
    @RequestMapping(method = RequestMethod.GET, value = "/channel/{id}")
    public RespData getDataChannelById(@PathVariable("id")int id);

    @RequestMapping(method = RequestMethod.POST, value = "/channel")
    public RespData insertDataChannel(DataChannel dataChannel) ;

    @RequestMapping(method = RequestMethod.POST, value = "/channel/update")
    public RespData updateDataChannel(DataChannel dataChannel) ;

    @RequestMapping(method = RequestMethod.POST, value = "/channel/delete")
    public RespData deleteDataChannel(DataChannel dataChannel) ;
}
