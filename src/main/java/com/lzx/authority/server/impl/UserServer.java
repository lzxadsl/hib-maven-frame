package com.lzx.authority.server.impl;

import org.springframework.stereotype.Service;

import com.lzx.authority.server.IUserServer;
import com.lzx.basic.server.impl.BaseServer;

/**
 * 
 * @author LiZhiXian
 * @version 1.0
 * @date 2016-1-8 下午5:18:01
 */
@Service
public class UserServer extends BaseServer implements IUserServer{

	/**
	 * 
	 * @author LiZhiXian
	 * @version 1.0
	 * @date 2016-1-8 下午5:19:03
	 */
	@Override
	public void add() {
		System.out.println("打印用户名："+getUsername());
	}

}
