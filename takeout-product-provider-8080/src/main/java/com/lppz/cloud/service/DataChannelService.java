package com.lppz.cloud.service;
import com.lppz.cloud.api.entities.DataChannel;

public interface DataChannelService {

    public DataChannel getDataChannelById(int id);

    public DataChannel insertDataChannel(DataChannel dataChannel) throws Exception;

    public int updateDataChannel(DataChannel dataChannel) throws Exception;

    public int deleteDataChannel(DataChannel dataChannel) throws Exception;
}
