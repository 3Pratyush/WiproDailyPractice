package DP_Day4;

public class HealthCareSystem {
    public static void main(String[] args) {
        PatientServiceImpl ps = new PatientServiceImpl();
        Patient p1 = new Patient();
        p1.setId(1);
        p1.setName("Akash");
        p1.setAge(23);
        p1.setIllness("Fever");

        Patient p2 = new Patient();
        p2.setId(2);
        p2.setName("Raj");
        p2.setAge(25);
        p2.setIllness("Heart Problem");

        ps.registerPatient(p1);
        ps.registerPatient(p2);

        ps.showPatient(p1.getId());
        ps.showPatient(p2.getId());

        System.out.println("\n--- Diagnosis ---");

        Doctor d1 = new DoctorTypes("Ayush", "general");
        Doctor d2 = new DoctorTypes("Rahul", "cardiologist");

        d1.diagnose(p1);
        d2.diagnose(p1);

        d1.diagnose(p2);
        d2.diagnose(p2);
    }
}