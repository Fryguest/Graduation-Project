package com.wlmiao.dao;

import com.wlmiao.bo.CourseStudent;
import com.wlmiao.bo.CourseStudentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface CourseStudentMapper {
    long countByExample(CourseStudentExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CourseStudent record);

    int insertSelective(CourseStudent record);

    List<CourseStudent> selectByExampleWithRowbounds(CourseStudentExample example, RowBounds rowBounds);

    List<CourseStudent> selectByExample(CourseStudentExample example);

    CourseStudent selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CourseStudent record, @Param("example") CourseStudentExample example);

    int updateByExample(@Param("record") CourseStudent record, @Param("example") CourseStudentExample example);

    int updateByPrimaryKeySelective(CourseStudent record);

    int updateByPrimaryKey(CourseStudent record);
}