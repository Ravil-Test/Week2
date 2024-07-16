package ru.nurullin.springcourse.models;

public class Person {
    private int id;
    private String workName;
    private String workSurname;
    private int workAge;
    private double workExp;
    private String workSpec;

    private String manName;
    private String manSurname;
    private int manAge;
    private double manExp;
    private String manSpec;

    public Person() {}

    public Person(int id, String workName, String workSurname,
                  int workAge, double workExp, String workSpec, String manName) {
        this.id = id;
        this.workName = workName;
        this.workSurname = workSurname;
        this.workAge = workAge;
        this.workExp = workExp;
        this.workSpec = workSpec;
        this.manName = manName;
    }

    public Person(int id, String manName, String manSurname, int manAge, double manExp, String manSpec) {
        this.id = id;
        this.manName = manName;
        this.manSurname = manSurname;
        this.manAge = manAge;
        this.manExp = manExp;
        this.manSpec = manSpec;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWorkName() {
        return workName;
    }

    public void setWorkName(String workName) {
        this.workName = workName;
    }

    public String getWorkSurname() {
        return workSurname;
    }

    public void setWorkSurname(String workSurname) {
        this.workSurname = workSurname;
    }

    public int getWorkAge() {
        return workAge;
    }

    public void setWorkAge(int workAge) {
        this.workAge = workAge;
    }

    public double getWorkExp() {
        return workExp;
    }

    public void setWorkExp(double workExp) {
        this.workExp = workExp;
    }

    public String getWorkSpec() {
        return workSpec;
    }

    public void setWorkSpec(String workSpec) {
        this.workSpec = workSpec;
    }

    public String getManName() {
        return manName;
    }

    public void setManName(String manName) {
        this.manName = manName;
    }

    public String getManSurname() {
        return manSurname;
    }

    public void setManSurname(String manSurname) {
        this.manSurname = manSurname;
    }

    public int getManAge() {
        return manAge;
    }

    public void setManAge(int manAge) {
        this.manAge = manAge;
    }

    public double getManExp() {
        return manExp;
    }

    public void setManExp(double manExp) {
        this.manExp = manExp;
    }

    public String getManSpec() {
        return manSpec;
    }

    public void setManSpec(String manSpec) {
        this.manSpec = manSpec;
    }
}