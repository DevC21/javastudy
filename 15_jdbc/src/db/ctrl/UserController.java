package db.ctrl;

import db.dto.UserDto;
import db.service.UserService;
import db.service.UserServiceImpl;

/*
 * Controller
 * 1. 사용자의 요청을 받는 영역이다.
 * 2. 사용자에게 응답을 보내는 영역이다.
 * 3. 요청에 따른 Service 를 실행하고 실행 결과를 응답한다.
 */

public class UserController {
	
	// field
	private UserService userService;
	
	// constructor
	public UserController() {
		userService = new UserServiceImpl();
	}
	
	// method
	public String requestHandle(String choice, UserDto userDto) {
		
		StringBuilder message = new StringBuilder();
		
		switch(choice) {
  		case "1":
  			for(UserDto user : userService.getUsers()) {
  				message.append(user.toString()).append("\n");
  			}
  			break;
  		case "2":
  			UserDto user = userService.getUser(userDto.getUser_no());
  			if(user == null) {
  				message.append("조회된 사용자 정보가 없습니다.");
  			} else {
  				message.append(user.toString());
  			}
  			break;
  		case "3":
  			message.append(userService.saveUser(userDto)).append(" ").append("명의 정보가 등록되었습니다.");
  			break;
  		case "4":
  			message.append(userService.modifyUser(userDto)).append(" ").append("명의 정보가 수정되었습니다.");
  			break;
  		case "5":
  			message.append(userService.removeUser(userDto.getUser_no())).append(" ").append("명의 정보가 삭제되었습니다.");
  			break;
		}
		
		
		return message.toString();
	}
}
