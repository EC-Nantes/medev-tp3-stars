/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.ec_nantes.stars;

import java.io.*;
import java.util.Scanner;


public class PgmImage {

    public int width;
    public int height;
    public int maxGray;
    public int[][] pixels;

    // Constructor
    public PgmImage(int width, int height, int maxGray) {
        this.width = width;
        this.height = height;
        this.maxGray = maxGray;
        this.pixels = new int[height][width];
    }

    public static PgmImage read(File file) throws IOException {

        try (Scanner sc = new Scanner(file)) {

            String magic = sc.next();
            if (!magic.equals("P2")) {
                throw new IOException("Not a valid P2 PGM file");
            }

            if (sc.hasNext("#")) {
                sc.nextLine(); 
            }

            int width = sc.nextInt();
            int height = sc.nextInt();

            int maxGray = sc.nextInt();

            PgmImage img = new PgmImage(width, height, maxGray);

            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    img.pixels[i][j] = sc.nextInt();
                }
            }

            return img;
        }
    }

    public void write(File file) throws IOException {
        try (PrintWriter out = new PrintWriter(new FileWriter(file))) {

            out.println("P2");
            out.println("# Created by TP3 STARS");
            out.println(width + " " + height);
            out.println(maxGray);

            int charCount = 0;

            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    String v = String.valueOf(pixels[i][j]);


                    if (charCount + v.length() > 70) {
                        out.println();
                        charCount = 0;
                    }

                    out.print(v + " ");
                    charCount += v.length() + 1;
                }
                out.println();
                charCount = 0;
            }
        }
    }
}

