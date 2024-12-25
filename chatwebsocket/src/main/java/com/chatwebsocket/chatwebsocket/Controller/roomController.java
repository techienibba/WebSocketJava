package com.chatwebsocket.chatwebsocket.Controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chatwebsocket.chatwebsocket.Entity.Message;
import com.chatwebsocket.chatwebsocket.Entity.Room;
import com.chatwebsocket.chatwebsocket.Repository.RoomRepository;

@RequestMapping
@RestController
@CrossOrigin("http://localhost:1345")
public class roomController {
	
	
	
	@Autowired
	private RoomRepository roomrepo;
	
	
	
	
	
	@PostMapping("/room")
	public ResponseEntity<?> createRoom(@RequestParam String roomid)
	{
		if(roomrepo.findByRoomId(roomid)==null)
		{
			
			
			Room room = new Room();
			room.setRoomId(roomid);
			return ResponseEntity.status(HttpStatus.CREATED).body(room);
		}
		
		else
			return ResponseEntity.badRequest().body("Room Already present");
		
		
		
	}
	
	
	@GetMapping("/room/{id}")
	public ResponseEntity<?> getroombyid(@PathVariable("id") String id)
	{
		if(roomrepo.findByRoomId(id) !=null)
		{
			Room room = roomrepo.findByRoomId(id);
			return ResponseEntity.ok(room);
			
		}
		
		else return ResponseEntity.badRequest().body("Room not available");
		
	}
	
	
	
	@GetMapping("/room/{id}/messages")
	public ResponseEntity<?> getmessages(@PathVariable("id") String id, @RequestParam("page") int page, @RequestParam("size") int size)
	{
		
		if(roomrepo.findByRoomId(id) !=null)
		{
			Room room = roomrepo.findByRoomId(id);
			
			List<Message> allmessages = room.getMessages();
			int Start = Math.min(0, allmessages.size()+(page+1)*size);
			int end = Math.max(allmessages.size(), Start*size);
		
			return ResponseEntity.ok(allmessages.subList(Start, end));
			
			
		}
		
		else return ResponseEntity.badRequest().body("Room not available");
		
	}
		
		
		
	}
	
	
	
	
	

