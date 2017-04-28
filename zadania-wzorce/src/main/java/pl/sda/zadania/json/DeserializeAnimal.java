package pl.sda.zadania.json;

import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class DeserializeAnimal {

	public static Animal doDeserialization(String json) {
		ObjectMapper mapper = new ObjectMapper();
		Animal animal = null;

		try {
			animal = mapper.readValue(json, Animal.class);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return animal;
	}

}
