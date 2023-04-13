package co.simplon.events.database;

import java.util.HashMap;
import java.util.Map;
import java.util.Collection;

import co.simplon.events.entities.Location;
import co.simplon.events.entities.Topic;
import co.simplon.events.entities.Event;

public class DataBase {
	private static Map<Long, Location> LOCATIONS = new HashMap<>();
	

	 static {
		Location location1 = new Location();
		location1.setName("Paris");
		location1.setId(1L);
		Location location2 = new Location();
		location2.setName("Rennes");
		location2.setId(2L);
		Location location3 = new Location();
		location3.setName("Marseille");
		location3.setId(3L);
		
		LOCATIONS.put(location1.getId(), location1);

		LOCATIONS.put(location2.getId(), location2);

		LOCATIONS.put(location3.getId(), location3);	
		
	}
	public static Collection<Location> findAllLocations() {
		return LOCATIONS.values();
		
		}

	public static Location findOneByLocation(Long id) {
		return LOCATIONS.get(id);
	}
	private static Map<Long, Topic> TOPICS = new HashMap<>();
	
	static {
		Topic topic1 = new Topic();
		topic1.setName("Écologie");
		topic1.setId(1L);
		Topic topic2 = new Topic();
		topic2.setName("Ressources Humaines");
		topic2.setId(2L);
		Topic topic3 = new Topic();
		topic3.setName("Tech");
		topic3.setId(3L);
		
		TOPICS.put(topic1.getId(), topic1);
		TOPICS.put(topic2.getId(), topic2);
		TOPICS.put(topic3.getId(), topic3);
	}

	public static Collection<Topic> findAllTopics(){
		return TOPICS.values();
		
		}
	public static Topic findOneByTopic(Long id) {
		return TOPICS.get(id);
	}
	
	public static Map<Long, Location> getLocationId() {
		return LOCATIONS;
	}
	public static void setLocationId(Map<Long, Location> locationId) {
		DataBase.LOCATIONS = locationId;
	}
	
	public static Map<Long, Topic> getTopicId() {
		return TOPICS;
	}
	
	public static void setTopicId(Map<Long, Topic> topicId) {
		DataBase.TOPICS = topicId;
	}
	
	private static Long eventId = 0L;
	private static final Map<Long, Event> EVENTS = new HashMap<>();
	
	public static void createEvent(Event event) {
		eventId++;
		event.setId(eventId);
		EVENTS.put(event.getId(), event);
	}
	
	
	public static Collection<Event> findAllEvents(){
		return  EVENTS.values();
	}
	
	}