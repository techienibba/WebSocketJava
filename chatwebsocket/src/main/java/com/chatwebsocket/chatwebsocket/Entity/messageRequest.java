package com.chatwebsocket.chatwebsocket.Entity;

import java.time.LocalDateTime;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@Getter
@Setter
public class messageRequest {
	
	
	private String content;
	private String sender;
	private String roomid;
	private LocalDateTime timestamp;
	
	
	
	
	

}
