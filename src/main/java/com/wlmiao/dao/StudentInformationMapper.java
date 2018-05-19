package com.wlmiao.dao;

import com.wlmiao.bo.StudentInformation;
import com.wlmiao.bo.StudentInformationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface StudentInformationMapper {
    long countByExample(StudentInformationExample example);

    int deleteByPrimaryKey(Long id);

    int insert(StudentInformation record);

    int insertSelective(StudentInformation record);

    List<StudentInformation> selectByExampleWithRowbounds(StudentInformationExample example, RowBounds rowBounds);

    List<StudentInformation> selectByExample(StudentInformationExample example);

    StudentInformation selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") StudentInformation record,
        @Param("example") StudentInformationExample example);

    int updateByExample(@Param("record") StudentInformation record, @Param("example") StudentInformationExample example);

    int updateByPrimaryKeySelective(StudentInformation record);

    int updateByPrimaryKey(StudentInformation record);
}