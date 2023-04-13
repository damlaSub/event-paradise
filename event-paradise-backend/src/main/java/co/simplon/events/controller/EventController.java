package co.simplon.events.controller;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.events.database.DataBase;
import co.simplon.events.dtos.EventCreateDto;
import co.simplon.events.dtos.EventView;
import co.simplon.events.entities.Event;
import co.simplon.events.database.DataBase;

@RestController
@RequestMapping("/events")
@CrossOrigin
public class EventController {
	@PostMapping
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void create (
		@RequestBody EventCreateDto inputs) {
		
		Event event = new Event();
		event.setName(inputs.getName());
		event.setDate(inputs.getDate());
		event.setTopic(DataBase.findOneByTopic(inputs.getTopicId()));
		event.setLocation(DataBase.findOneByLocation(inputs.getLocationId()));
		event.setPrice(inputs.getPrice());
		event.setDescription(inputs.getDescription());
		DataBase.createEvent(event);
		System.out.println(event);
	}
		 
}
