package DP_Day4;
abstract class Doctor {
    protected String name;
    protected String specialization;
    public Doctor(String name, String specialization) {
        this.name = name;
        this.specialization = specialization;
    }
    abstract void diagnose(Patient p);
}