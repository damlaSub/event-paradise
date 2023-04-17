package co.simplon.events.dtos;

import java.time.LocalDate;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import co.simplon.events.entities.Location;
import co.simplon.events.entities.Topic;

public class EventCreateDto {

	private Long id;
	
	@NotNull
	@Size(max=255)
	private String name;
	
	@NotNull
	@FutureOrPresent
	private LocalDate date;
	
	@NotNull
	private Long topicId;
	
	@NotNull
	private Long locationId;
	
	@NotNull
	@Positive
	private Double price;
	
	@NotNull
	@Size(max=1000)
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

	public Long getTopicId() {
		return topicId;
	}

	public void setTopicId(Long topicId) {
		this.topicId = topicId;
	}

	public Long getLocationId() {
		return locationId;
	}

	public void setLocationId(Long locationId) {
		this.locationId = locationId;
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
		return "EventCreateDto [id=" + id + ", name=" + name + ", date=" + date + ", topicId=" + topicId
				+ ", locationId=" + locationId + ", price=" + price + ", description=" + description + "]";
	}

}