package com.gxu.tbvp.service;

import com.gxu.tbvp.domain.Accessrecord;

<<<<<<< HEAD
import javax.xml.crypto.Data;
import java.util.List;

public interface AccessrecordService extends IService<Accessrecord> {

    int bachInsert(List<Accessrecord> accessrecordList);
    int selectAccessCountByTime(String startTime,String endTime);
=======
import java.util.List;

public interface AccessrecordService {

    int bachInsert(List<Accessrecord> accessrecordList);
>>>>>>> a0046ff29998cd277d16735fe59d099dc6c45191
}
