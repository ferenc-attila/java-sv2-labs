package catalog;

import java.util.List;

public class Validators {

    private Validators() {
    }

    public static boolean isBlank(String string) {
        return (string == null || string.isBlank());
    }

    public static boolean isEmpty(List list) {
        return (list == null || list.isEmpty());
    }
}
