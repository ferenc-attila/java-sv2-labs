package controlselection.week;

public class DayOfWeek {

    public String dayOfWeek(String day) {
        String dayOfWeek;
        day = day.toLowerCase();

        switch (day) {
            case "hétfő":
                dayOfWeek = "hét eleje";
                break;
            case "kedd":
            case "szerda":
            case "csütörtök":
                dayOfWeek = "hét közepe";
                break;
            case "péntek":
                dayOfWeek = "majdnem hétvége";
                break;
            case "szombat":
            case "vasárnap":
                dayOfWeek = "hét vége";
                break;
            default:
                dayOfWeek = "ismeretlen nap";
                break;
        }
        return dayOfWeek;
    }
}
