package introconstructors;

public class TaskMain {

    public static void main(String[] args) {

        Task task = new Task("Shopping", "Buy bread and milk in local store");
        task.setDuration(30);
        task.start();

        System.out.print("title: " + task.getTitle() + ";\n" +
                        "description: " + task.getDescription() + ";\n" +
                        "duration: " + task.getDuration() + ";\n" +
                        "start time: " + task.getStartDateTime() + ";\n");
    }
}
