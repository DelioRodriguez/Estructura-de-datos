package models;

public class RemoteStudent extends Student {

    public RemoteStudent(String id, String name) {
        super(id, name);
    }

    @Override
    public double getFinalScore() {
        return examScore * 0.5 + practiceScore * 0.5;
    }

}
