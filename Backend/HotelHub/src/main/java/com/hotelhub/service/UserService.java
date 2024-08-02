package com.hotelhub.service;

import com.hotelhub.dto.ApiResponse;
import com.hotelhub.dto.AuthRequest;
import com.hotelhub.dto.UserRegisterDTO;
import com.hotelhub.dto.UserRespDTO;

public interface UserService {
//user signin
	UserRespDTO authenticateUser(AuthRequest dto);
	 //ApiResponse registerUser(AuthRequest dto);
	void registerUser(UserRegisterDTO dto);
}
