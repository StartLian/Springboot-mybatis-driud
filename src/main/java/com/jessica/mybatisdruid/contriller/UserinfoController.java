package com.jessica.mybatisdruid.contriller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.druid.support.json.JSONParser;
import com.jessica.mybatisdruid.mapper.UserInfoDao;


@RestController
public class UserinfoController {
	@Autowired
	UserInfoDao userinfodao;
	
	@RequestMapping("/getUserinfoByid")
	public String getUserinfoByid(@RequestParam("id") long id,@RequestParam("telNumber") String telNumber) {
		System.out.println("id:"+id);
		String username = "";
		HashMap<String,Object> userinfoBytelNumber = new HashMap<>();
		for (int i = 0; i < 100; i++) {
			HashMap<String,Object> userinfoByID = userinfodao.getUserinfoByID(id+i);
			username = (String) userinfoByID.get("telNumber");
			userinfoBytelNumber = userinfodao.getUserinfoBytelNumber(telNumber);
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return "收到："+username +userinfoBytelNumber.toString();
	}
}
