package DP_Day12;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Patient {

    private int patientId;
    private String patientName;
    private int age;
    private String gender;
    private String disease;
    private String doctorName;
    private String hospitalName;
    private String bloodGroup;
    private String phoneNumber;
    private String admissionDate;

    private ArrayList<String> medicalReports =
            new ArrayList<>();

    public Patient(int patientId,
                   String patientName,
                   int age,
                   String gender,
                   String disease,
                   String doctorName,
                   String hospitalName,
                   String bloodGroup,
                   String phoneNumber,
                   String admissionDate) {

        this.patientId = patientId;
        this.patientName = patientName;
        this.age = age;
        this.gender = gender;
        this.disease = disease;
        this.doctorName = doctorName;
        this.hospitalName = hospitalName;
        this.bloodGroup = bloodGroup;
        this.phoneNumber = phoneNumber;
        this.admissionDate = admissionDate;

        medicalReports.add("Patient Registered Successfully");
    }

    public void addReport(String report) {
        medicalReports.add(report);
    }

    public void savePatientData(String fileName) {

        try {

            FileWriter fw = new FileWriter(fileName);

            fw.write("========== PATIENT DETAILS ==========\n");

            fw.write("Patient ID      : " + patientId + "\n");
            fw.write("Patient Name    : " + patientName + "\n");
            fw.write("Age             : " + age + "\n");
            fw.write("Gender          : " + gender + "\n");
            fw.write("Disease         : " + disease + "\n");
            fw.write("Doctor Name     : " + doctorName + "\n");
            fw.write("Hospital Name   : " + hospitalName + "\n");
            fw.write("Blood Group     : " + bloodGroup + "\n");
            fw.write("Phone Number    : " + phoneNumber + "\n");
            fw.write("Admission Date  : " + admissionDate + "\n");

            fw.write("\n========== MEDICAL REPORTS ==========\n");

            for (String r : medicalReports) {
                fw.write(r + "\n");
            }

            fw.close();

            System.out.println("Patient Record Saved Successfully!");

        }

        catch (IOException e) {
            System.out.println(e);
        }
    }
}