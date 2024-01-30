package db.main;

import java.util.List;

import db.dao.UserDao;
import db.dto.UserDto;

public class MainClass {

	public static void main(String[] args) {
		
		UserDao userDao = UserDao.getInstance();
		
		UserDto userDto = new UserDto(1, "테스트이름", "테스트연락처", null);
		int result = userDao.saveUser(userDto);
		System.out.println(result + " 행이 삽입되었습니다.");
		
		userDto = userDao.getUser(3);
		System.out.println(userDto + "\n");
		
		List<UserDto> list = userDao.getUsers();
		for(UserDto user : list) {
			System.out.println(user);
		}
		  
		System.out.println(userDao.modifyUser(userDto) + " 행이 수정되었습니다.");
		System.out.println(userDao.removeUser(5) + " 행이 삭제되었습니다.");
		
	}

}
