package com.chatwebsocket.chatwebsocket.Entity;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@Getter
@Setter
public class Message {
	
	
	private String sender;
	
	private String content;
	
	private LocalDateTime timestamp;
	
	
	
	
	public Message(String Sender,String Content)
	{
		
		this.sender=Sender;
		this.content=Content;
		timestamp=LocalDateTime.now();
		
		
	}

}
