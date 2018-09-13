package com.gxu.tbvp.mapper;

import com.gxu.tbvp.domain.Accessrecord;
import com.gxu.tbvp.utils.MyMapper;
<<<<<<< HEAD
import org.apache.ibatis.annotations.Param;


public interface AccessrecordMapper extends MyMapper<Accessrecord> {
    Integer selectAccessCountByTime(@Param("startTime")String startTime, @Param("endTime")String endTime);
=======

public interface AccessrecordMapper extends MyMapper<Accessrecord> {
>>>>>>> a0046ff29998cd277d16735fe59d099dc6c45191
}