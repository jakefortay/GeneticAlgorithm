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
            String[] gen) {

        int random;

        for (int i = 0; i < gen.length; i++) {
            gen[i] = "";
            for (int j = 0; j < targetSize; j++) {
                random = (int) Math.floor(Math.random() * (51 - 0 + 1) + 0);
                gen[i] += lib.charAt(random);
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
        String target = in.nextLine();

        int size = target.length();

        out.println("Enter a population size: ");
        int popSize = in.nextInteger();

        String[] gen = new String[popSize];

//        int random = (int) Math.floor(Math.random() * (10 - 0 + 1) + 0);

        genPop(lib, popSize, size, gen);

        for (int i = 0; i < gen.length; i++) {
            out.println(gen[i]);
        }

        in.close();
        out.close();
    }

}
