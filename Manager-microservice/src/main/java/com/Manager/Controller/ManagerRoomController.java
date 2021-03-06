package com.Manager.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.Manager.Models.Room;
import com.Manager.Models.RoomList;

@RestController
@RequestMapping("/manager/room")
public class ManagerRoomController {
	
	
	@Autowired
	private RestTemplate restTemplate;
	
	
	@PostMapping("/addRoom")
	public Room addRoom(@RequestBody Room room) {
		return restTemplate.postForObject("http://Room-Microservice/rooms/addRoom/", room, Room.class);
	}
	
	
	@PutMapping("/updateRoom")
	public Room updateRoom(@RequestBody Room room) {
	 restTemplate.put("http://Room-Microservice/rooms/updateRoom/",room, Room.class);
	 return room;
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteRoom(@PathVariable("id") String id) {
		 restTemplate.delete("http://Room-Microservice/rooms/delete/"+id);
		return "Deleted room "+id;
	}
	
	
	
	
	
	@GetMapping("/findAllRoom")
	public RoomList getRoom() 
	{
		return restTemplate.getForObject("http://Room-Microservice/rooms/findAllRoom/", RoomList.class);
	}
	
	
	@GetMapping("/findById/{id}")
	public Room getRoom(@PathVariable("id") String id) 
	{
		return restTemplate.getForObject("http://Room-Microservice/rooms/findById/"+id, Room.class);
	}
	

}
