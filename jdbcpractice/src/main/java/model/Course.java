package model;

import java.util.Objects;

public class Course {

    private Long id;
    private String title;
    private String description;
    private String link;

    public Course(String title, String description, String link) {
        this.title = title;
        this.description = description;
        this.link = link;
    }

    public Course(Long id, String title, String description, String link) {
        this(title, description, link);
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return title.equals(course.title) && description.equals(course.description) && link.equals(course.link);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, description, link);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
