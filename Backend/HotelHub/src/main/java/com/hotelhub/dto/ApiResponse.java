package com.hotelhub.dto;

import java.time.LocalDateTime;

<<<<<<< HEAD
import lombok.*;

=======
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//DTO : data transfer object (used to exchange the data between 
//REST  client n REST server)
>>>>>>> main
@NoArgsConstructor
@Getter
@Setter
public class ApiResponse {
<<<<<<< HEAD

=======
>>>>>>> main
	private String message;
	private LocalDateTime timeStamp;

	public ApiResponse(String message) {
		super();
		this.message = message;
		this.timeStamp = LocalDateTime.now();
	}
}
