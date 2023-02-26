import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Put a short phrase describing the program here.
 *
 * @author Put your name here
 *
 */
public final class GeneticAlgorithm {

    /**
     * No argument constructor--private to prevent instantiation.
     */
    private GeneticAlgorithm() {
    }

    /**
     *
     * @param array
     *
     *            array to be printed
     */
    private static void print2D(char[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j]);
            }
            System.out.println();
        }
    }

    /**
     *
     * @param lib
     *            Library of characters to choose from
     * @param popSize
     *            Population size of generation
     * @param targetSize
     *            Length of the target string
     * @param gen
     *            Array to contain Strings
     */
    private static void genPop(String lib, int popSize, int targetSize,
            char[][] gen) {

        int random;

        for (int i = 0; i < gen.length; i++) {

            for (int j = 0; j < targetSize; j++) {
                random = (int) Math.floor(Math.random() * (51 - 0 + 1) + 0);
                gen[i][j] = lib.charAt(random);
            }
        }

    }

    /**
     *
     * @param fitness
     *            array of fitness scores
     * @param gen
     *            array of guesses
     */
    private static void gradePop(int[] fitness, char[][] gen, char[] target) {
        for (int i = 0; i < gen.length; i++) {
            for (int j = 0; j < gen[i].length; j++) {
                if (gen[i][j] == target[j]) {
                    fitness[i]++;
                }
            }
        }
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {
        SimpleReader in = new SimpleReader1L();
        SimpleWriter out = new SimpleWriter1L();

        String lib = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

        out.println("Enter a target string: ");
        String input = in.nextLine();

        int wordSize = input.length();

        char[] target = new char[wordSize];

        for (int i = 0; i < target.length; i++) {
            target[i] = input.charAt(i);
        }

        // Have string target converted to char array @target

        out.println("Enter a population size: ");
        int popSize = in.nextInteger();

        char[][] gen = new char[popSize][wordSize];
        int[] fitness = new int[popSize];

        // Generate initial population

        genPop(lib, popSize, wordSize, gen);

        print2D(gen);

        gradePop(fitness, gen, target);

        for (int i = 0; i < fitness.length; i++) {
            System.out.println(fitness[i]);
        }

        boolean running = true;

//        while (running) {
//
//            // Grade the population, return array of scores, array of guesses
//
//            // Create a new array with the top half of the scorers, retain orginal
//
//            // Modify the original array by taking first x and last y # of chars
//            // from stop scorer array
//
//        }

        in.close();
        out.close();
    }

}
