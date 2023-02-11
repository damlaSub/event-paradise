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
		event.setTopic(inputs.getTopic());
		event.setLocation(inputs.getLocation());
		event.setPrice(inputs.getPrice());
		event.setDescription(inputs.getDescription());
		DataBase.createEvent(event);
	}

	@GetMapping
	public Collection<EventView> getAll(){
		Collection<Event> events = DataBase.findAllEvents();
		Collection<EventView> eventViews = new ArrayList<>();
		for(Event event: events) {
			EventView eventView = new EventView();
			eventView.setId(event.getId());
			eventView.setName(event.getName());
			eventView.setTopic(event.getTopic());
			eventView.setLocation(event.getLocation());
			eventView.setPrice(event.getPrice());
			eventView.setDescription(event.getDescription());
			eventViews.add(eventView);
		}
		return eventViews;
		 
	}
	
}
