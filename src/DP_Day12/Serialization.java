package DP_Day12;
import java.io.*;
class Student implements Serializable{
	int id;
	String name;
	Student(int id, String name){
		this.id = id;
		this.name = name;
	}
}
public class Serialization {
public static void main(String[] args) {
	try {
		Student s = new Student(101,"Pratyush");
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Pratyush.txt"));
		out.writeObject(s);
		out.close();
		System.out.println("Serialized");
	}catch(Exception e) {
		System.out.println(e);
	}
	 try {
         ObjectInputStream in = new ObjectInputStream(new FileInputStream("Pratyush.txt"));
         Student s1 = (Student) in.readObject();
         in.close();
         System.out.println("Deserialized");
         System.out.println("ID: " + s1.id);
         System.out.println("Name: " + s1.name);
     }catch (Exception e) {
        System.out.println(e);
     }
}
}
