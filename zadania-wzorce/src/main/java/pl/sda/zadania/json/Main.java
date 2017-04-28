package pl.sda.zadania.json;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Animal animal = new Animal();

		animal.setSpecies("Aptenodytes forsteri");
		animal.setGenus("Aptenodytes");
		animal.setFamily("Spheniscidae");
		animal.setOrder("Sphenisciformes");
		animal.setClazz("Aves");
		animal.setPhylum("Chordata");
		animal.setKingdom("Animalia");

		String json = SerializeAnimal.doSerialization(animal);
		System.out.println(json);
		Animal newAnimal = DeserializeAnimal.doDeserialization(json);
		System.out.println(newAnimal.species);
		System.out.println(newAnimal.genus);
		System.out.println(newAnimal.family);
		System.out.println(newAnimal.order);
		System.out.println(newAnimal.clazz);
		System.out.println(newAnimal.phylum);
		System.out.println(newAnimal.kingdom);

	}

}
