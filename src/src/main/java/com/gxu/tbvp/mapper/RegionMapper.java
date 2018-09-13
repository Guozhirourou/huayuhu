package com.gxu.tbvp.mapper;

import com.gxu.tbvp.domain.Region;
import com.gxu.tbvp.utils.MyMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper

@Component(value = "RegionMapper")
public interface RegionMapper extends MyMapper<Region> {
    public List<Region> getProvinceMsg();
<<<<<<< HEAD
    public int selectCountProvince(String province);
    public int selectCountProvinceById(int id);
=======
>>>>>>> a0046ff29998cd277d16735fe59d099dc6c45191
}