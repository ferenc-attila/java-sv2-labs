package collectonsqueue;

import java.util.*;

public class ToDoList {

    private List<ToDo> todos;

    public ToDoList(List<ToDo> todos) {
        this.todos = todos;
    }

    public Deque<ToDo> getTodosInUrgencyOrder() {
        Deque<ToDo> priority = new ArrayDeque<>();
        for (ToDo actual : todos) {
            if (actual.isUrgent()) {
                priority.addFirst(actual);
            } else {
                priority.addLast(actual);
            }
        }
        return priority;
    }

    public static void main(String[] args) {

        List<ToDo> todos = new ArrayList<>(Arrays.asList(new ToDo("Bevásárlás", false),
                new ToDo("Okmányiroda", true),
                new ToDo("Mozi", false),
                new ToDo("Tesztek írása", true),
                new ToDo("Terepi munka", true),
                new ToDo("Squash", false)));

        ToDoList toDoList = new ToDoList(todos);

        Deque<ToDo> priority = toDoList.getTodosInUrgencyOrder();

        System.out.println(priority.pop());
        System.out.println(priority.pop());
        System.out.println(priority.pop());
        System.out.println(priority.pop());
        System.out.println(priority.pop());
        System.out.println(priority.pop());
    }
}
