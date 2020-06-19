package ro.unibuc.fmi;

import java.util.Random;

public class Action implements Comparable<Action> {

    private Integer priority;
    private String name;
    private ActionType actionType;

    public Action(String name) {
        this(name, new Random().nextInt(100), ActionType.CLIENT_ACTION);
    }

    public Action(String name, Integer priority, ActionType actionType) {
        this.priority = priority;
        this.name = name;
        this.actionType = actionType;
    }

    public Integer getPriority() {
        return priority;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Action o) {
        int reversedCompare = o.getPriority().compareTo(priority);
        if (reversedCompare != 0) {
            return reversedCompare;
        }

        return name.compareTo(o.getName());
    }

    @Override
    public String toString() {
        return "Action: " + name + " --- Priority: " + priority + " --- Type: " + actionType;
    }
}
