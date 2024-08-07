package com.hotelhub.service;

import com.hotelhub.dto.ApiResponse;
import com.hotelhub.dto.AuthRequest;
import com.hotelhub.dto.UserRegisterDTO;
import com.hotelhub.dto.UserRespDTO;
import com.hotelhub.entity.User;

public interface UserService  {
//user signin
	UserRespDTO authenticateUser(AuthRequest dto);
	 //ApiResponse registerUser(AuthRequest dto);
	Long registerUser(UserRegisterDTO dto);
	
}
