package models;

public class OnCampusStudent extends Student {

    public OnCampusStudent(String id, String name) {
        super(id, name);
    }

    @Override
    public double getFinalScore() {
        return examScore * 0.6 + practiceScore * 0.4;
    }

}
