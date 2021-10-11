public class NoteMain {

    public static void main(String[] args) {

        Note note = new Note();

        note.setName("John Doe");
        note.setTopic("Bevásárlólista");
        note.setText("Tej, kenyér, citromlé, vaj, krumpli, paradicsom");

        System.out.println(note.getNoteText());
    }
}
