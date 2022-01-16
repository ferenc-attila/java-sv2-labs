package collectionsiterator;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class HomeSchooling {

    private List<OnlineLesson> lessons = new ArrayList<>();

    public List<OnlineLesson> getLessons() {
        return List.copyOf(lessons);
    }

    public void addNewLesson(OnlineLesson lesson) {
        int index = 0;
        for (Iterator<OnlineLesson> iterator = lessons.iterator(); iterator.hasNext(); ) {
            OnlineLesson actual = iterator.next();
            if (actual.getStartTime().isBefore(lesson.getStartTime())) {
                index++;
            }
        }
        lessons.add(index, lesson);
    }

    public List<OnlineLesson> getLessonsByTitle(String title) {
        List<OnlineLesson> lessonsByTitle = new ArrayList<>();
        for (Iterator<OnlineLesson> iterator = lessons.iterator(); iterator.hasNext(); ) {
            OnlineLesson actual = iterator.next();
            if (title.equals(actual.getLessonTitle())) {
                lessonsByTitle.add(actual);
            }
        }
        return lessonsByTitle;
    }

    public void removeLesson(LocalDateTime startTime) {
        for (Iterator<OnlineLesson> iterator = lessons.iterator(); iterator.hasNext(); ) {
            OnlineLesson actual = iterator.next();
            if (startTime.equals(actual.getStartTime())) {
                iterator.remove();
            }
        }
    }
}
