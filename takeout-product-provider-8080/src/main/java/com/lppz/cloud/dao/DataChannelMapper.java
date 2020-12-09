package com.lppz.cloud.dao;

import com.lppz.cloud.api.entities.DataChannel;
import org.apache.ibatis.annotations.Mapper;

/**
 * 操作数据库表的mapper
 */
@Mapper
public interface DataChannelMapper {

    public DataChannel getDataChannelById(int id);

    public int insertDataChannel(DataChannel dataChannel) throws Exception;

    public int updateDataChannel(DataChannel dataChannel) throws Exception;

    public int deleteDataChannel(DataChannel dataChannel) throws Exception;
}
