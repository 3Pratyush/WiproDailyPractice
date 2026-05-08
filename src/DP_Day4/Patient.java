package DP_Day4;

class Patient {
    private int id;
    private String name;
    private int age;
    private String illness;
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public String getIllness() {
        return illness;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setIllness(String illness) {
        this.illness = illness;
    }
    public void display() {
        System.out.println("ID: " + id + ", Name: " + name +
                ", Age: " + age + ", Illness: " + illness);
    }
}