package defaultconstructor.date;

public class SimpleDateFormatter {

    public SimpleDateFormatter() {
    }

    public String formatDateString(SimpleDate simpleDate) {
        return formatHuDateString(simpleDate);
    }

    public String formatDateStringByCountryCode(CountryCode countryCode, SimpleDate simpleDate) {
        switch (countryCode.toString()) {
            case "HU":
                return formatHuDateString(simpleDate);
            case "EN":
                return formatEnDateString(simpleDate);
            case "US":
                return formatUsDateString(simpleDate);
            default:
                throw new IllegalArgumentException("Invalid country code!");
        }
    }

    private String formatHuDateString(SimpleDate simpleDate) {
        StringBuilder date = new StringBuilder();
        date.append(simpleDate.getYear()).append("-").append(simpleDate.getMonth()).append("-").append(simpleDate.getDay());
        return date.toString();
    }

    private String formatEnDateString(SimpleDate simpleDate) {
        StringBuilder date = new StringBuilder();
        date.append(simpleDate.getDay()).append("-").append(simpleDate.getMonth()).append("-").append(simpleDate.getYear());
        return date.toString();
    }

    private String formatUsDateString(SimpleDate simpleDate) {
        StringBuilder date = new StringBuilder();
        date.append(simpleDate.getMonth()).append("-").append(simpleDate.getDay()).append("-").append(simpleDate.getYear());
        return date.toString();
    }
}
