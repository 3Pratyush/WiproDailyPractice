package DP_Day12;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
public class FileHandling {
public static void main(String[] args) {
	try {
		File file = new File("Raj.txt");
		if(file.createNewFile()) {
			System.out.println("File created successfully!!");
		}else {
			System.out.println("File already exist!!");
		}
		FileWriter writer = new FileWriter(file);
		writer.write("Hello World..");
		writer.close();
		System.out.println("Data written successfully");
		FileReader reader = new FileReader(file);
		int ch;
		 System.out.println("Reading File Content:");
		 while ((ch = reader.read()) != -1) {
             System.out.print((char) ch);
         }
		 reader.close();

	}
	catch (IOException e) {
        System.out.println("Error: " + e.getMessage());
    }
}
}
