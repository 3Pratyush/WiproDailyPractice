package DP_Day4;
import java.util.HashMap;
interface PatientService {
    void registerPatient(Patient p);
    void showPatient(int id);
}
class PatientServiceImpl implements PatientService {
    HashMap<Integer, Patient> map = new HashMap<>();
    public void registerPatient(Patient p) {
        if (map.containsKey(p.getId())) {
            System.out.println("Patient already exists!");
        } else {
            map.put(p.getId(), p);
            System.out.println("Patient Registered");
        }
    }
    public void showPatient(int id) {
        Patient p = map.get(id);

        if (p != null) {
            p.display();
        } else {
            System.out.println("No Patient registered");
        }
    }
    public Patient getPatient(int id) {
        return map.get(id);
    }
}