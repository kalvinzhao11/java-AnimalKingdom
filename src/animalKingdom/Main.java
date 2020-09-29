package animalKingdom;

import java.util.List;
import java.util.ArrayList;

public class Main {

	public static List<Animals> filterAnimal(List<Animals> animals, CheckAnimal tester){
		List<Animals> filteredList = new ArrayList<>();

		for (Animals animal: animals){
			if (tester.test(animal)){
				filteredList.add(animal);
			}
		}
		return filteredList;
	}

	public static void main(String[] args) {
		Mammals panda = new Mammals("Panda", 1869);
		Mammals zebra = new Mammals("Zebra", 1778);
		Mammals koala = new Mammals("Koala", 1816);
		Mammals sloth = new Mammals("Sloth", 1804);
		Mammals armadillo = new Mammals("Armadillo", 1758);
		Mammals raccoon = new Mammals("Raccoon", 1758);
		Mammals bigfoot = new Mammals("Bigfoot", 2021);

		Birds pigeon = new Birds("Pigeon", 1837);
		Birds peacock = new Birds("Peacock", 1821);
		Birds toucan = new Birds("Toucan", 1758);
		Birds parrot = new Birds("Parrot", 1824);
		Birds swan = new Birds("Swan",1758);

		Fish salmon = new Fish("Salmon", 1758);
		Fish catfish = new Fish("Catfish", 1817);
		Fish perch = new Fish("Perch", 1758);

		List<Animals> animals = new ArrayList<>();
		animals.add(panda);
		animals.add(zebra);
		animals.add(koala);
		animals.add(sloth);
		animals.add(armadillo);
		animals.add(raccoon);
		animals.add(bigfoot);
		animals.add(pigeon);
		animals.add(peacock);
		animals.add(toucan);
		animals.add(parrot);
		animals.add(swan);
		animals.add(salmon);
		animals.add(catfish);
		animals.add(perch);

		System.out.println("*** MVP ***\n");
		System.out.println("*** List all the animals in descending order by year named ***");
		animals.sort((item1, item2) -> item2.getYearDiscovered() - item1.getYearDiscovered());
		System.out.println((animals));

		System.out.println("\n*** List all the animals alphabetically ***");
		animals.sort((item1, item2) -> item1.getName().compareToIgnoreCase(item2.getName()));
		System.out.println(animals);

		System.out.println("\n*** List all the animals order by how they move ***");
		animals.sort((item1, item2) -> item1.move().compareToIgnoreCase(item2.move()));
		System.out.println(animals);

		System.out.println("\n*** List only those animals the breath with lungs ***");
		List<Animals> filteredAnimal = filterAnimal(animals, animals1 -> (animals1.breath() == "lungs"));
		filteredAnimal.forEach(animals1 -> System.out.println(animals1.getName() + " " + animals1.reproduce() + " " + animals1.move() + " " + animals1.breath() + " " + animals1.getYearDiscovered()));

		System.out.println("\n*** List only those animals that breath with lungs and were named in 1758 ***");
		filteredAnimal = filterAnimal(animals, animals1 -> (animals1.breath() == "lungs" && animals1.getYearDiscovered() == 1758));
		filteredAnimal.forEach(animals1 -> System.out.println(animals1.getName() + " " + animals1.reproduce() + " " + animals1.move() + " " + animals1.breath() + " " + animals1.getYearDiscovered()));

		System.out.println("\n*** List only those animals that lay eggs and breath with lungs ***");
		filteredAnimal = filterAnimal(animals, animals1 -> (animals1.breath() == "lungs" && animals1.reproduce() == "eggs"));
		filteredAnimal.forEach(animals1 -> System.out.println(animals1.getName() + " " + animals1.reproduce() + " " + animals1.move() + " " + animals1.breath() + " " + animals1.getYearDiscovered()));

		System.out.println("\n*** List alphabetically only those animals that were named in 1758 ***");
		filteredAnimal = filterAnimal(animals, animals1 -> (animals1.getYearDiscovered() == 1758));
		filteredAnimal.sort((item1, item2) -> item1.getName().compareToIgnoreCase(item2.getName()));
		filteredAnimal.forEach(animals1 -> System.out.println(animals1.getName() + " " + animals1.reproduce() + " " + animals1.move() + " " + animals1.breath() + " " + animals1.getYearDiscovered()));

		System.out.println("\n*** Stretch Goal ***\n");

		System.out.println("*** For the list of animals, list alphabetically those animals that are mammals ***");
		filteredAnimal = filterAnimal(animals, animals1 -> (animals1.getClass() == Mammals.class));
		filteredAnimal.forEach(animals1 -> System.out.println(animals1.getName() + " " + animals1.reproduce() + " " + animals1.move() + " " + animals1.breath() + " " + animals1.getYearDiscovered()));

//		System.out.println(perch.getClass() == Fish.class);

	}

}