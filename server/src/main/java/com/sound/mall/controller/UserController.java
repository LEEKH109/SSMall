package com.sound.mall.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sound.mall.model.dto.User;
import com.sound.mall.model.service.UserService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api-user")
public class UserController {
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";
	
	@Autowired
	private UserService userService;
	
	@PostMapping("signup")
	@ApiOperation(value = "회원가입시 유저객체 생성,DB입력 성공여부(boolean)에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	public ResponseEntity<String> signup(User user){
		if(userService.signUp(user)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK); // 200 OK
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.BAD_REQUEST); // 400 Bad Request
	}
	
	@PostMapping("idcheck")
	@ApiOperation(value = "사용가능한 ID인지 여부를 반환한다.", response = String.class)
	public ResponseEntity<String> idcheck(String userId){
		if(userService.indentifyId(userId)) {
	        return new ResponseEntity<>("ID available", HttpStatus.OK); // 200 OK
	    }
	    return new ResponseEntity<>("ID not available", HttpStatus.CONFLICT); // 409 Conflict
	}
	
	@PostMapping("login")
	@ApiOperation(value = "로그인성공시 비밀번호를 제외한 로그인 유저의 정보를 반환한다.", response = User.class)
    public ResponseEntity<?> login(User user, HttpSession session) {
        User loggedInUser = userService.logIn(user.getUserId(), user.getPassword());
        if (loggedInUser != null) {
            loggedInUser.setPassword(null);//비밀번호는 제외한 정보만 반환
            Map<String, Object> response = new HashMap<>();
            response.put("user", loggedInUser);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(FAIL, HttpStatus.UNAUTHORIZED);
    }
	@PutMapping("updateuser")
	@ApiOperation(value = "DB 수정 성공여부(boolean)에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	public ResponseEntity<String> updateuser(User user){
		boolean updateResult = userService.updateUser(user);
	    if (updateResult) {
	        return new ResponseEntity<>(SUCCESS, HttpStatus.OK); // 200 OK
	    }
	    return new ResponseEntity<>(FAIL, HttpStatus.BAD_REQUEST); // 400 Bad Request
	}
	// 로그인 정보를 세션으로 관리하지 않으므로 로그인 기능은 컨트롤러에서 관리하지 않는다.
	// 추후 JWT, Refresh 토큰을 적용할시 로그아웃을 컨트롤러에서 관리한다.
}
