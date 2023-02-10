package co.simplon.events.dtos;

public class TopicCreateDto {

	private Long id;
	private String name;
	
	public TopicCreateDto() {
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
		return "TopicCreateDto [id=" + id + ", name=" + name + "]";
	}
}
