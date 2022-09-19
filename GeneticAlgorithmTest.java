package geneticAlgorithmString;

import java.util.Scanner;

public class GeneticAlgorithmTest {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter the string to guess: ");
		String goal = scan.nextLine();
		System.out.print("Enter the number of organisms per generation: ");
		int popSize = scan.nextInt();
		System.out.print("Enter the number of generations: ");
		int generations = scan.nextInt();
		System.out.print("Enter the probability of mutation: ");
		double mutateProb = scan.nextDouble();
		System.out.println("");
		Population population = new Population(goal, popSize, generations, mutateProb);
		population.iterate();

	}
}
