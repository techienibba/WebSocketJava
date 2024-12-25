package com.chatwebsocket.chatwebsocket.Controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;

import com.chatwebsocket.chatwebsocket.Entity.Message;
import com.chatwebsocket.chatwebsocket.Entity.Room;
import com.chatwebsocket.chatwebsocket.Entity.messageRequest;
import com.chatwebsocket.chatwebsocket.Repository.RoomRepository;

@Controller
@CrossOrigin("http://localhost:1345")
public class chatController {
	
	

	@Autowired
	private RoomRepository roomrepo;
	
	
	
	
	@MessageMapping("/sendmessage/{roomid}")
	@SendTo("/topic/room/{roomid}")
	public Message Sendmessage(@RequestBody messageRequest messagereq, @DestinationVariable String roomid)
	{
		
		Room room=roomrepo.findByRoomId(messagereq.getRoomid());
		Message mes = new Message();
		mes.setContent(messagereq.getContent());
		mes.setSender(messagereq.getSender());
		mes.setTimestamp(LocalDateTime.now());
		if(room!=null)
		{
			
			
			
			
			room.getMessages().add(mes);
			roomrepo.save(room);
			
		}
			
		
		
		
		
		else {
			
			throw new RuntimeException("Room not found");}
		return mes;
		
	}

	

}
