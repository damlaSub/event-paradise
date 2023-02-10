package co.simplon.events.dtos;

public class TopicView {

	private Long id;
	private String name;
	
	public TopicView() {
		
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
		return "TopicView [id=" + id + ", name=" + name + "]";
	}
}
