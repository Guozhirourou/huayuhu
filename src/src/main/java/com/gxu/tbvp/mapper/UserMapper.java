package com.gxu.tbvp.mapper;

import com.gxu.tbvp.domain.User;
import com.gxu.tbvp.utils.MyMapper;

<<<<<<< HEAD
import java.util.Map;

public interface UserMapper extends MyMapper<User> {
    void autoIncrement();

    int countAge(Map<String, Object> age);
=======
public interface UserMapper extends MyMapper<User> {
    void autoIncrement();
>>>>>>> a0046ff29998cd277d16735fe59d099dc6c45191
}