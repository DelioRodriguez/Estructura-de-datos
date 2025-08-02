package models;

import java.util.ArrayList;

public class Group {

    private String groupName;
    public ArrayList<Student> students = new ArrayList<>();

    public Group(String groupName) {
        this.groupName = groupName;
    }

    public OperationResult<Void> addStudent(Student s) {
        students.add(s);
        return OperationResult.ok(null);
    }

    public void printGrades() {
        System.out.println("Notas del grupo " + groupName);
        for (Student s : students) {
            System.out.println(s.getInfo());
        }
    }

    public double getApprovalRate() {
        if (students.isEmpty()) return 0;
        long approved = students.stream().filter(Student::isApproved).count();
        return (approved * 100.0) / students.size();
    }

    public String getGroupName() {
        return groupName;
    }

}