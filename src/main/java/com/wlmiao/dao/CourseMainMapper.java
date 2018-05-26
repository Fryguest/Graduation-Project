package com.wlmiao.dao;

import com.wlmiao.bo.CourseMain;
import com.wlmiao.bo.CourseMainExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CourseMainMapper {
    long countByExample(CourseMainExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CourseMain record);

    int insertSelective(CourseMain record);

    List<CourseMain> selectByExampleWithRowbounds(CourseMainExample example, RowBounds rowBounds);

    List<CourseMain> selectByExample(CourseMainExample example);

    CourseMain selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CourseMain record, @Param("example") CourseMainExample example);

    int updateByExample(@Param("record") CourseMain record, @Param("example") CourseMainExample example);

    int updateByPrimaryKeySelective(CourseMain record);

    int updateByPrimaryKey(CourseMain record);
}