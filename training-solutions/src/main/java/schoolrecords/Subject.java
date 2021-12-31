package schoolrecords;

public class Subject {

    private String subjectName;

    public Subject(String subjectName) {
        validateSubjectName(subjectName);
        this.subjectName = subjectName;
    }

    private void validateSubjectName(String subjectName) {
        if (subjectName == null || subjectName.isBlank()) {
            throw new IllegalArgumentException("Subject's name can't be empty!");
        }
    }

    public String getSubjectName() {
        return subjectName;
    }
}
