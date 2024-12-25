package com.chatwebsocket.chatwebsocket.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.chatwebsocket.chatwebsocket.Entity.Room;

public interface RoomRepository extends MongoRepository<Room,String> {
	
	
	
	
	Room findByRoomId(String roomid);

}
