package com.gxu.tbvp.service;

import com.gxu.tbvp.domain.Region;

import java.util.List;

public interface RegionService extends IService<Region>{
    public List<Region> selectProvince();
<<<<<<< HEAD
    public int selectCountProvince(String province);
    public int selectCountProvinceById(int id);
=======
>>>>>>> a0046ff29998cd277d16735fe59d099dc6c45191
}
