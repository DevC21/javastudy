package db.dao;

import java.util.List;

import db.dto.UserDto;

public class MainClass {

	public static void main(String[] args) {
		// UserDao 클래스의 getInstance 메소드 호출
		
		// 메소드 호출 방법
		// 1. 객체.메소드()
		// 2. 클래스.메소드()
		UserDao userDao = UserDao.getInstance();
		
		List<UserDto> list = userDao.getUsers();
		UserDto userDto = userDao.getUser(1);
		System.out.println(list);
		System.out.println(userDto);
	}

}
