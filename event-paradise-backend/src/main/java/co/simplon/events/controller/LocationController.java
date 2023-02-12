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
import co.simplon.events.dtos.LocationCreateDto;
import co.simplon.events.dtos.LocationView;
import co.simplon.events.entities.Location;

@RestController
@RequestMapping("/locations")
@CrossOrigin

public class LocationController {
	@PostMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
	public void create(
			@RequestBody LocationCreateDto inputs) {
		Location location = new Location();
		location.setId(inputs.getId());
		location.setName(inputs.getName());
		DataBase.findAllLocations();
	
	}
	
	
	@GetMapping
	public Collection<LocationView> getAll(){
		Collection<Location> locations = DataBase.findAllLocations();
		Collection<LocationView> views = new ArrayList<>();
		for (Location location : locations) {
			LocationView view = new LocationView();
			view.setId(location.getId());
			view.setName(location.getName());
			views.add(view);
	}
	return views;
}
	
	
}
