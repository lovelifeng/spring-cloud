package com.lppz.cloud.service.impl;

import com.lppz.cloud.api.entities.DataChannel;
import com.lppz.cloud.dao.DataChannelMapper;
import com.lppz.cloud.exception.MyException;
import com.lppz.cloud.service.DataChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class DataChannelServiceImpl implements DataChannelService {
    @Autowired
    DataChannelMapper dataChannelMapper;

    @Override
    public DataChannel getDataChannelById(@PathVariable("id") int id) {
        DataChannel dc= dataChannelMapper.getDataChannelById(id);
        return dc;
    }
    @Override
    public DataChannel insertDataChannel(DataChannel dataChannel) throws Exception {
        try {
            dataChannelMapper.insertDataChannel(dataChannel);
        } catch (Exception e) {
            e.printStackTrace();
            throw  new MyException("2004","添加渠道错误");
        }
        return dataChannel;
    }

    @Override
    public int updateDataChannel(DataChannel dataChannel) throws Exception {
      return dataChannelMapper.updateDataChannel(dataChannel);
    }

    @Override
    public int deleteDataChannel(DataChannel dataChannel) throws Exception {

       return dataChannelMapper.deleteDataChannel(dataChannel);

    }
}
