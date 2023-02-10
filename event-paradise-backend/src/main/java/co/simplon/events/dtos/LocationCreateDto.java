package co.simplon.events.dtos;

public class LocationCreateDto {

	private Long id;
	private String name;
	
	public LocationCreateDto() {
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

	@Override
	public String toString() {
		return "LocationCreateDto [id=" + id + ", name=" + name + "]";
	}
}
