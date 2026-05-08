package DP_Day11;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Q1_bufferWriter {
  public static void main(String[] args) {
    try (BufferedWriter bw = new BufferedWriter(new FileWriter("Pratyush.txt"))) {
      bw.write("Hello Pratyush");
      System.out.println("Successful");
    } catch (IOException e) {
      System.out.println("Error");
    }
  }
}