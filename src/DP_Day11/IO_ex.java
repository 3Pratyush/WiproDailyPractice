package DP_Day11;

import java.io.FileWriter;
import java.io.IOException;

public class IO_ex {
    public static void main(String[] args) {

        try (FileWriter fw = new FileWriter("Pratyush.txt")) {
            fw.write("Hello Java IO");
            System.out.println("Data written successfully!");
        } catch (IOException e) {
            System.out.println("Error occurred: " + e.getMessage());
        }

    }
}