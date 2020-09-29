package animalKingdom;

abstract class Animals {

	private static int maxId = 0;
	protected int id;
	protected String name;
	protected int yearDiscovered;

	public Animals(String name, int yearDiscovered) {
		maxId++;
		id = maxId;
		this.name = name;
		this.yearDiscovered = yearDiscovered;
	}

	public String consumeFood(){
		return "mouth";
	}

	abstract String move();
	abstract String breath();
	abstract String reproduce();

	public String getName() {
		return name;
	}

	public int getYearDiscovered() {
		return yearDiscovered;
	}

	 @Override
	 public String toString(){
	 	return "Animals{id=" + id + ", name='" + name + "', yearNamed=" + yearDiscovered + "}";
	 }
}