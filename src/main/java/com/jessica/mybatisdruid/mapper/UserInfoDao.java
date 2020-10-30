package com.jessica.mybatisdruid.mapper;

import java.util.HashMap;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
@Repository
public interface UserInfoDao {
	@Select("select * from appuserlogin where ID=#{id}")
	public HashMap<String, Object> getUserinfoByID(@Param("id")long l);
	@Select("select * from appuserlogin where telNumber=#{telNumber}")
	public HashMap<String, Object> getUserinfoBytelNumber(@Param("telNumber")String telNumber);
}
