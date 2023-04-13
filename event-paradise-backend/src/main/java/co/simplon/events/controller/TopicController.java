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
import co.simplon.events.dtos.TopicView;
import co.simplon.events.entities.Topic;

@RestController
@RequestMapping("/topics")
@CrossOrigin

public class TopicController {
	
	@GetMapping
	public Collection<TopicView> getAll(){
		Collection<Topic> topics = DataBase.findAllTopics();
		Collection<TopicView> views = new ArrayList<>();
		for (Topic topic : topics) {
			TopicView view = new TopicView();
			view.setId(topic.getId());
			view.setName(topic.getName());
			views.add(view);
	}
	return views;
}
		
}
