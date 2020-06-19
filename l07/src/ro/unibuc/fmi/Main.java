package ro.unibuc.fmi;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Action action1 = new Action("Action_1");
        Action action2 = new Action("Action_2");
        Action action3 = new Action("Action_3");
        Action action4 = new Action("Action_4");
        Action action5 = new Action("Action_5");
        Action action6 = new Action("Action_C", 0, ActionType.ADMIN_ACTION);
        Action action7 = new Action("Action_A", 0, ActionType.ADMIN_ACTION);
        Action action8 = new Action("Action_B", 0, ActionType.ADMIN_ACTION);

        Set<Action> treeSet = new TreeSet<>(Arrays.asList(action1, action2, action3, action4, action5, action6, action7, action8, action8));
        for (Action action : treeSet) {
            System.out.println(action);
        }
        System.out.println("------------------------------------");


        Queue<Action> priorityQueue = new PriorityQueue<>(Arrays.asList(action1, action2, action3, action4, action5, action6, action7, action8, action8));
        System.out.println(priorityQueue.peek());
        System.out.println(priorityQueue.peek());
        System.out.println(priorityQueue.poll());
        System.out.println(priorityQueue.peek());
        System.out.println("------------------------------------");


        Deque<Action> arrayDeque = new ArrayDeque<>(Arrays.asList(action1, action2, action3, action4, action5));
        System.out.println(arrayDeque.pollFirst());
        System.out.println(arrayDeque.pollLast());
        System.out.println(arrayDeque.pollFirst());
        System.out.println(arrayDeque.pollLast());
        System.out.println(arrayDeque.poll());

        try {
            System.out.println(arrayDeque.getLast());
        } catch (RuntimeException re) {
            System.out.println("Caught exception: " + re.getClass());
        }
        System.out.println(arrayDeque.peekLast());
        System.out.println(arrayDeque.pollLast());
    }
}
