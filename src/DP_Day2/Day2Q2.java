package DP_Day2;

//Login Validation

public class Day2Q2 {
	public static void main(String[] args) {
		
		String cusername = "Pratyush";
		String cpassword = "1234";
		
		String username = "Pratyush";
		String password = "1234";
		
		if (username == cusername && password == cpassword) {
			System.out.println("Login Succesful!");
		}
		else {
			System.out.println("Login Failure!");
		}
	}
}
