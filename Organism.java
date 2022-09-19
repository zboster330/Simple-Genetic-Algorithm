package geneticAlgorithmString;

public class Organism implements Comparable<Organism>{
	
	String value;
	String goal;
	
	public Organism (String value, String goal) 
	{
		this.value = value;
		this.goal = goal;
	}
	public Organism (String goal)
	{
		this.goal = goal;
		StringBuilder builder = new StringBuilder(goal.length());
		for (int i = 0; i < goal.length(); i++) 
		{
			int randInt = 20 + (int) (Math.random() * (126 - 20 + 1));
			builder.append((char) randInt);
		}
		value = builder.toString();
	}
	public int fitness () {
		int fit = 0;
		for (int i = 0; i < goal.length() -1; i++)
		{
			if (value.charAt(i) == goal.charAt(i)) 
			{
				fit++;
			}
			
		}
		return fit;
	}
	public Organism[] mate(Organism other)
	{
		int crossOver = (int) (Math.random() * goal.length());
		String first = this.value.substring(0, crossOver).concat(value.substring(crossOver));
		String second = other.value.substring(0, crossOver).concat(value.substring(crossOver));
		Organism child0 = new Organism(first, goal);
		Organism child1 = new Organism(second, goal);
		Organism[] organisms = new Organism[] {child0, child1};
		return organisms;
	}
	public void mutate(double mutateProb) 
	{
		for (int i = 0; i < value.length(); i++) 
		{
			double randDouble = (Math.random());
			if (randDouble <= mutateProb) 
			{
				int randInt = 20 + (int) (Math.random() * (126 - 20 + 1));
				String temp = value.substring(0, i) + ((char) randInt) + value.substring(i+1);
				this.value = temp;
			}
		}
	}
	@Override
	public int compareTo (Organism other) 
	{
		int compare = 0;
		if (other.fitness() > this.fitness()) 
		{
			compare = 1;
		}
		if (other.fitness() < this.fitness())
		{
			compare = -1;
		}
		return compare;
	}
	
	public String toString (Organism organism)
	{
		String temp = "Value: " + organism.value + " Goal: " + organism.goal + " Fitness: " + organism.fitness();
		return temp;
	}
}
