package mock;

import java.util.ArrayList;
import java.util.List;

import model.Person;

public class MockGenerator {

	public static List<Person> generateMockData() {
		List<Person> persons = new ArrayList<>();
		Person person1 = new Person("Jan", "Nowak", 25);
		Person person2 = new Person("Tomasz", "Kowalski", 20);
		Person person3 = new Person("Joanna", "Kot", 16);

		persons.add(person1);
		persons.add(person2);
		persons.add(person3);

		return persons;

	}

}
