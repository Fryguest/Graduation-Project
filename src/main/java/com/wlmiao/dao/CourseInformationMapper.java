package com.wlmiao.dao;

import com.wlmiao.bo.CourseInformation;
import com.wlmiao.bo.CourseInformationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface CourseInformationMapper {
    long countByExample(CourseInformationExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CourseInformation record);

    int insertSelective(CourseInformation record);

    List<CourseInformation> selectByExampleWithRowbounds(CourseInformationExample example, RowBounds rowBounds);

    List<CourseInformation> selectByExample(CourseInformationExample example);

    CourseInformation selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CourseInformation record,
        @Param("example") CourseInformationExample example);

    int updateByExample(@Param("record") CourseInformation record, @Param("example") CourseInformationExample example);

    int updateByPrimaryKeySelective(CourseInformation record);

    int updateByPrimaryKey(CourseInformation record);
}