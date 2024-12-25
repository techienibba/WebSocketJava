package com.chatwebsocket.chatwebsocket.Entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.annotation.Collation;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@Getter
@Setter
@Collation(value="mychat")
public class Room {
	
	@Id
	private String id;
	private String roomId;
	private List<Message> messages;

}
