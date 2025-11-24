package fr.ec_nantes.stars;

import java.io.File;

public class MainApp {

    public static void main(String[] args) {
        try {


            System.out.println("Loading baboon.pgm...");
            PgmImage img = PgmImage.read(new File("baboon.pgm"));
            System.out.println("Loaded image: " + img.width + " x " + img.height);


            System.out.println("Saving copy -> output_copy.pgm");
            img.write(new File("output_copy.pgm"));


            System.out.println("Applying threshold...");
            PgmImage th = ImageOperations.threshold(img, 120);
            th.write(new File("threshold.pgm"));
            System.out.println("Threshold saved to threshold.pgm");


            System.out.println("Loading second image (baboon.pgm again)...");
            PgmImage img2 = PgmImage.read(new File("baboon.pgm")); // same size for testing

            System.out.println("Computing difference...");
            PgmImage diff = ImageOperations.difference(img, img2);
            diff.write(new File("difference_same.pgm"));
            System.out.println("Difference saved to difference_same.pgm");


            System.out.println("Scaling image x1.5...");
            PgmImage big = ImageOperations.scale(img, 1.5);
            big.write(new File("bigger.pgm"));
            System.out.println("Saved bigger.pgm");


            System.out.println("ALL TESTS DONE SUCCESSFULLY");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
