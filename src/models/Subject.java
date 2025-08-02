package models;

import java.util.ArrayList;

public class Subject {

    private String name;
    private ArrayList<Group> groups = new ArrayList<>();

    public Subject(String name) {
        this.name = name;
    }

    public Group createGroup(String groupName) {
        Group g = new Group(groupName);
        groups.add(g);
        return g;
    }

    public ArrayList<Group> getGroups() {
        return groups;
    }

    public String getName() {
        return name;
    }

}
