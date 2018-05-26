package com.wlmiao.dao;

import com.wlmiao.bo.TrainingPlan;
import com.wlmiao.bo.TrainingPlanExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TrainingPlanMapper {
    long countByExample(TrainingPlanExample example);

    int insert(TrainingPlan record);

    int insertSelective(TrainingPlan record);

    List<TrainingPlan> selectByExampleWithRowbounds(TrainingPlanExample example, RowBounds rowBounds);

    List<TrainingPlan> selectByExample(TrainingPlanExample example);

    int updateByExampleSelective(@Param("record") TrainingPlan record, @Param("example") TrainingPlanExample example);

    int updateByExample(@Param("record") TrainingPlan record, @Param("example") TrainingPlanExample example);
}