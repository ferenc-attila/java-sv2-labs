package searching;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LostAndFoundOffice {

    private List<LostProperty> lostProperties = new ArrayList<>();

    public void addProperty(LostProperty property) {
        lostProperties.add(property);
    }

    public LostProperty findLostProperty(LostProperty property) {
        if (Collections.binarySearch(lostProperties, property) < 0) {
            throw new IllegalArgumentException("Property not found.");
        } else {
            return (lostProperties.get(Collections.binarySearch(lostProperties, property)));
        }
    }
}
