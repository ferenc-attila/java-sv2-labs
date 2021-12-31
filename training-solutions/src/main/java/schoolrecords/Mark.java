package schoolrecords;

public class Mark {

    private MarkType markType;
    private final Subject subject;
    private final Tutor tutor;

    public Mark(MarkType markType, Subject subject, Tutor tutor) {
        validateMarkType(markType);
        validateSubject(subject);
        validateTutor(tutor);
        this.markType = markType;
        this.subject = subject;
        this.tutor = tutor;
    }

    private void validateMarkType (MarkType markType) {
        if (markType == null) {
            throw new NullPointerException("Mark type can't be null!");
        }
    }

    private void validateSubject (Subject subject) {
        if (subject == null) {
            throw new NullPointerException("Both subject and tutor must be provided!");
        }
    }

    private void validateTutor (Tutor tutor) {
        if (tutor == null) {
            throw new NullPointerException("Both subject and tutor must be provided!");
        }
    }

    @Override
    public String toString() {
        return markType.getDescription() + "(" + markType.getGrade() + ")";
    }

    public MarkType getMarkType() {
        return markType;
    }

    public Subject getSubject() {
        return subject;
    }

    public Tutor getTutor() {
        return tutor;
    }
}
