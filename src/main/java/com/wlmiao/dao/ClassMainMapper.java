package com.wlmiao.dao;

import com.wlmiao.bo.ClassMain;
import com.wlmiao.bo.ClassMainExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ClassMainMapper {
    long countByExample(ClassMainExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ClassMain record);

    int insertSelective(ClassMain record);

    List<ClassMain> selectByExampleWithRowbounds(ClassMainExample example, RowBounds rowBounds);

    List<ClassMain> selectByExample(ClassMainExample example);

    ClassMain selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ClassMain record, @Param("example") ClassMainExample example);

    int updateByExample(@Param("record") ClassMain record, @Param("example") ClassMainExample example);

    int updateByPrimaryKeySelective(ClassMain record);

    int updateByPrimaryKey(ClassMain record);
}