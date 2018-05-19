package com.wlmiao.dao;

import com.wlmiao.bo.StudentScore;
import com.wlmiao.bo.StudentScoreExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface StudentScoreMapper {
    long countByExample(StudentScoreExample example);

    int deleteByPrimaryKey(Long id);

    int insert(StudentScore record);

    int insertSelective(StudentScore record);

    List<StudentScore> selectByExampleWithRowbounds(StudentScoreExample example, RowBounds rowBounds);

    List<StudentScore> selectByExample(StudentScoreExample example);

    StudentScore selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") StudentScore record, @Param("example") StudentScoreExample example);

    int updateByExample(@Param("record") StudentScore record, @Param("example") StudentScoreExample example);

    int updateByPrimaryKeySelective(StudentScore record);

    int updateByPrimaryKey(StudentScore record);
}