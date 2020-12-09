package com.lppz.cloud.api.service;

import com.lppz.cloud.api.entities.DataChannel;
import com.lppz.cloud.api.entities.RespData;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * sentinel的服务异常兜底回调接口
 * 每个对外暴露的服务都要事先改接口
 */
@Component
public class ApiServiceFallBackFactory implements FallbackFactory<DataChannelClientService> {


    @Override
    public DataChannelClientService create(Throwable throwable) {
        return new DataChannelClientService() {
            @Override
            public RespData getDataChannelById(int id) {
                RespData res= RespData.getDefaultErrRespData();
                res.setMsg("服务降级");
                return res;
            }

            @Override
            public RespData insertDataChannel(DataChannel dataChannel) {
                RespData res= RespData.getDefaultErrRespData();
                res.setMsg("服务降级");
                return res;
            }

            @Override
            public RespData updateDataChannel(DataChannel dataChannel) {
                RespData res= RespData.getDefaultErrRespData();
                res.setMsg("服务降级");
                return res;
            }

            @Override
            public RespData deleteDataChannel(DataChannel dataChannel) {
                RespData res= RespData.getDefaultErrRespData();
                res.setMsg("服务降级");
                return res;
            }
        };
    }

}
