package com.tour.auth.dao;

import com.alibaba.fastjson.JSONObject;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface DemoDAO {

    @Select("select * from sys_users where id = #{id}")
    JSONObject getById(@Param("id") String id);

}
