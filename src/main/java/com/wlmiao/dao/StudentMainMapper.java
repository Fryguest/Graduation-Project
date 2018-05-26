package com.wlmiao.dao;

import com.wlmiao.bo.StudentMain;
import com.wlmiao.bo.StudentMainExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StudentMainMapper {
    long countByExample(StudentMainExample example);

    int deleteByPrimaryKey(Long id);

    int insert(StudentMain record);

    int insertSelective(StudentMain record);

    List<StudentMain> selectByExampleWithRowbounds(StudentMainExample example, RowBounds rowBounds);

    List<StudentMain> selectByExample(StudentMainExample example);

    StudentMain selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") StudentMain record, @Param("example") StudentMainExample example);

    int updateByExample(@Param("record") StudentMain record, @Param("example") StudentMainExample example);

    int updateByPrimaryKeySelective(StudentMain record);

    int updateByPrimaryKey(StudentMain record);
}