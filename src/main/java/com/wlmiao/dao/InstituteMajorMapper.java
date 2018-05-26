package com.wlmiao.dao;

import com.wlmiao.bo.InstituteMajor;
import com.wlmiao.bo.InstituteMajorExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface InstituteMajorMapper {
    long countByExample(InstituteMajorExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(InstituteMajor record);

    int insertSelective(InstituteMajor record);

    List<InstituteMajor> selectByExampleWithRowbounds(InstituteMajorExample example, RowBounds rowBounds);

    List<InstituteMajor> selectByExample(InstituteMajorExample example);

    InstituteMajor selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") InstituteMajor record,
        @Param("example") InstituteMajorExample example);

    int updateByExample(@Param("record") InstituteMajor record, @Param("example") InstituteMajorExample example);

    int updateByPrimaryKeySelective(InstituteMajor record);

    int updateByPrimaryKey(InstituteMajor record);
}