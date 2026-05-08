package DP_Day4;

class DoctorTypes extends Doctor {

    public DoctorTypes(String name, String specialization) {
        super(name, specialization);
    }
    @Override
    void diagnose(Patient p) {

        if (p == null) {
            System.out.println("Invalid patient.");
            return;
        }
        String illness = p.getIllness().toLowerCase();

        if (specialization.equalsIgnoreCase("cardiologist")) {

            if (illness.contains("heart")) {
                System.out.println("Cardiologist " + name +
                        " treats heart patient " + p.getName());
            } else {
                System.out.println("Cardiologist " + name +
                        " suggests general checkup for " + p.getName());
            }

        } else {
            System.out.println("General Physician " + name +
                    " treats " + p.getName() +
                    " for " + p.getIllness());
        }

        System.out.println();
    }
}