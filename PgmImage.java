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

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {

            // 1. First line: must be P2
            String magic = br.readLine();
            if (magic == null || !magic.trim().equals("P2")) {
                throw new IOException("Not a valid P2 PGM file");
            }

            // 2. Skip blank lines + comments (# ...)
            String line = br.readLine();
            while (line != null && (line.trim().isEmpty() || line.trim().startsWith("#"))) {
                line = br.readLine();
            }

            if (line == null) {
                throw new IOException("Unexpected end of file after header");
            }

            String[] dims = line.trim().split("\\s+");
            int width = Integer.parseInt(dims[0]);
            int height = Integer.parseInt(dims[1]);

            line = br.readLine();
            while (line.trim().isEmpty() || line.trim().startsWith("#")) {
                line = br.readLine();
            }
            int maxGray = Integer.parseInt(line.trim());

            PgmImage img = new PgmImage(width, height, maxGray);

            // 5. Read pixel values with Scanner
            Scanner sc = new Scanner(br);
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if (!sc.hasNextInt()) {
                        throw new IOException("Unexpected end of pixel data");
                    }
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

                    // Ensure max 70 characters per line
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