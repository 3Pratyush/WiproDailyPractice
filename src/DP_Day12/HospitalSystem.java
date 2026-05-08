package DP_Day12;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class HospitalSystem {

    public static void main(String[] args) {

        Patient p = new Patient(
                101,
                "Pratyush",
                23,
                "Male",
                "Fever",
                "Dr. Sen",
                "Apollo Hospital",
                "B+",
                "9876543210",
                "06-May-2026"
        );

        p.addReport("Blood Test Completed");
        p.addReport("Temperature Normal");
        p.addReport("Medicine Prescribed");
        p.addReport("Patient Under Observation");

        String fileName = "patientdata.txt";

        // Save patient data into file
        p.savePatientData(fileName);

        // Read patient data from file
        try {

            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);

            String line;

            System.out.println("\n========== READING PATIENT DATA ==========\n");

            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

            br.close();

        }

        catch (IOException e) {
            System.out.println(e);
        }
    }
}