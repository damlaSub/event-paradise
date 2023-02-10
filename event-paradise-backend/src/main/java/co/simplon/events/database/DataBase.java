package co.simplon.events.database;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.origin.SystemEnvironmentOrigin;

import java.util.Collection;

import co.simplon.events.entities.Location;
import co.simplon.events.entities.Topic;

public class DataBase {
	
	private static Long locationId =0L;
	private static Long topicId = 0L;
	private static final Map<Long, Location> LOCATIONS = new HashMap<>();
	

	 static {
		locationId++;
		Location location1 = new Location();
		location1.setName("Paris");
		location1.setId(locationId);
		Location location2 = new Location();
		location2.setName("Rennes");
		location2.setId(locationId);
		Location location3 = new Location();
		location3.setName("Marseille");
		location3.setId(locationId);
		
		LOCATIONS.put(locationId, location1);

		LOCATIONS.put(locationId, location2);

		LOCATIONS.put(locationId, location3);
		
		
	}
	public static Collection<Location> findAllLocations() {
		return LOCATIONS.values();
		
		}

	private static final Map<Long, Topic> TOPICS = new HashMap<>();
	
	static {
		topicId++;
		Topic topic1 = new Topic();
		topic1.setName("Écologie");
		topic1.setId(topicId);
		Topic topic2 = new Topic();
		topic2.setName("Ressources Humaines");
		topic2.setId(topicId);
		Topic topic3 = new Topic();
		topic3.setName("Tech");
		topic3.setId(topicId);
		
		TOPICS.put(topicId, topic1);
		TOPICS.put(topicId, topic2);
		TOPICS.put(topicId, topic3);
	}

	public static Collection<Topic> findAllTopics(){
		return TOPICS.values();
		
		}
	
	public static Long getLocationId() {
		return locationId;
	}
	public static void setLocationId(Long locationId) {
		DataBase.locationId = locationId;
	}
	public static Long getTopicId() {
		return topicId;
	}
	public static void setTopicId(Long topicId) {
		DataBase.topicId = topicId;
	}
	
}