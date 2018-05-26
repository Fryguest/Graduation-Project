package com.wlmiao.dao;

import com.wlmiao.bo.TeacherMain;
import com.wlmiao.bo.TeacherMainExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TeacherMainMapper {
    long countByExample(TeacherMainExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TeacherMain record);

    int insertSelective(TeacherMain record);

    List<TeacherMain> selectByExampleWithRowbounds(TeacherMainExample example, RowBounds rowBounds);

    List<TeacherMain> selectByExample(TeacherMainExample example);

    TeacherMain selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TeacherMain record, @Param("example") TeacherMainExample example);

    int updateByExample(@Param("record") TeacherMain record, @Param("example") TeacherMainExample example);

    int updateByPrimaryKeySelective(TeacherMain record);

    int updateByPrimaryKey(TeacherMain record);
}