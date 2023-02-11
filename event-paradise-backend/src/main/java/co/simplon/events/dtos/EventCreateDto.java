package co.simplon.events.dtos;

import java.time.LocalDate;

import co.simplon.events.entities.Location;
import co.simplon.events.entities.Topic;

public class EventCreateDto {

private Long id;
	
	private String name;
	
	private LocalDate date;

	private Topic topic;
	
	private Location location;
	
	private Double price;
	
	private String description;

	public EventCreateDto() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "EventCreateDto [id=" + id + ", name=" + name + ", date=" + date + ", topic=" + topic + ", location="
				+ location + ", price=" + price + ", description=" + description + "]";
	}
	
	
}
