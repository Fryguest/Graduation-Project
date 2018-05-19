package com.wlmiao.dao;

import com.wlmiao.bo.ClassInformation;
import com.wlmiao.bo.ClassInformationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface ClassInformationMapper {
    long countByExample(ClassInformationExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ClassInformation record);

    int insertSelective(ClassInformation record);

    List<ClassInformation> selectByExampleWithRowbounds(ClassInformationExample example, RowBounds rowBounds);

    List<ClassInformation> selectByExample(ClassInformationExample example);

    ClassInformation selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ClassInformation record,
        @Param("example") ClassInformationExample example);

    int updateByExample(@Param("record") ClassInformation record, @Param("example") ClassInformationExample example);

    int updateByPrimaryKeySelective(ClassInformation record);

    int updateByPrimaryKey(ClassInformation record);
}