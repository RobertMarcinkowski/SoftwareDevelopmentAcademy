package pl.sda.zadania.json;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class SerializeAnimal {

	public static String doSerialization(Animal animal) {

		ObjectMapper mapper = new ObjectMapper();

		String serializedAnimal = null;
		try {
			serializedAnimal = mapper.writeValueAsString(animal);
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return serializedAnimal;

	}

}
