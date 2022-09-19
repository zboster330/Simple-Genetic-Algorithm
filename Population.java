package geneticAlgorithmString;

import java.util.Arrays;

public class Population {
	int popSize;
	int numGenerations;
	double mutateProb;
	String goal;
	Organism[] thisGeneration;
	Organism[] nextGeneration;
	
	public Population(String goal, int popSize, int numGenerations, double mutateProb) 
	{
		this.popSize = popSize;
		this.numGenerations = numGenerations;
		this.mutateProb = mutateProb;
		this.goal = goal;
		thisGeneration = new Organism[popSize];
		nextGeneration = new Organism[popSize];
		for (int i = 0; i < popSize; i++)
		{
			thisGeneration[i] = new Organism(goal);
		}
	}
	public void iterate() 
	{
		for (int g = 0; g < numGenerations; g++) 
		{
			Arrays.sort(thisGeneration);
			for (int i = 0; i < popSize/2; i++) 
			{
				Organism parent1 = thisGeneration[0];
				Organism parent2 = thisGeneration[i];
				
				Organism[] children = parent1.mate(parent2);
				Organism child1 = children[0];
				child1.mutate(mutateProb);
				Organism child2 = children[1];
				child2.mutate(mutateProb);
				
				nextGeneration[2*i] = child1;
				nextGeneration[2*i + 1] = child2;
			}
			Arrays.sort(nextGeneration);
			thisGeneration = nextGeneration;
			System.out.println((thisGeneration[0].toString(thisGeneration[0])));
		}
	}
	
}
