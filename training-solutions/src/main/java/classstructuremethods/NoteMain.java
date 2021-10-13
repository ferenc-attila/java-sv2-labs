package classstructuremethods;

public class NoteMain {

    public static void main(String[] args) {

        Note note = new Note();

        note.setName("Minta Géza");
        note.setTopic("bevásárlólista");
        note.setText("kenyér, tej, szalámi");

        System.out.println(note.getName());
        System.out.println(note.getTopic());
        System.out.println(note.getText());

        System.out.println(note.getNoteText());

    }
}
