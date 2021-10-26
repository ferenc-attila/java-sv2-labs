package compositionlist;

import java.util.ArrayList;
import java.util.List;

public class Capsules {

    private List<String> capsules = new ArrayList<>();

    public void addLast(String capsule) {
        capsules.add(capsules.size(), capsule);
    }

    public void addFirst(String capsule) {
        capsules.add(0, capsule);
    }

    public void removeFirst() {
        capsules.remove(0);
    }

    public void removeLast() {
        capsules.remove(capsules.size()-1);
    }

    public List<String> getColors() {
        return capsules;
    }
}
