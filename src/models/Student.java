package models;

public abstract class Student {

    public String name ;
    public String id;
    public double examScore;
    public double practiceScore;

    public String getName() {
        return name;
    }

    public Student(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public void setScores(double exam, double practice) {
        this.examScore = exam;
        this.practiceScore = practice;
    }

    public abstract double getFinalScore();

    public boolean isApproved() {
        return getFinalScore() >= 70;
    }

    public String getInfo() {
        return String.format("%s - %s | Final: %.2f | %s", id, name, getFinalScore(), isApproved() ? "Aprobado" : "Reprobado");
    }

}
