package stringmethods;

import java.util.ArrayList;
import java.util.List;

public class UrlManagerMain {

    public static void main(String[] args) {

        String firstUrl = "SSH://earthquake.USGS.GOV/fdsNWS/event/1/query?format=geojson&starttime=2014-01-01&endtime=2014-01-02";
        String secondUrl = "https://earthquake.usgs.gov:443/fdsnws/event/1/query?format=geojson&starttime=2014-01-01&endtime=2014-01-02";
        String thirdUrl = "ftp://earthquake.usgs.gov:443/fdsnws/event/1/query";
        String fourthUrl = "http://earthquake.usgs.gov/fdsnws/event/1/query";
        String fifthUrl = "http://earthquake.usgs.gov/?format=geojson&starttime=2014-01-01";
        String sixthUrl = "http://earthquake.usgs.gov";
        String seventhUrl = "http://earthquake.usgs.gov:443";
        String eighthUrl = "http://earthquake.usgs.gov:443/?format=geojson";

        UrlManager firstUrlManager = new UrlManager(firstUrl);
        UrlManager secondUrlManager = new UrlManager(secondUrl);
        UrlManager thirdUrlManager = new UrlManager(thirdUrl);
        UrlManager fourthUrlManager = new UrlManager(fourthUrl);
        UrlManager fifthUrlManager = new UrlManager(fifthUrl);
        UrlManager sixthUrlManager = new UrlManager(sixthUrl);
        UrlManager seventhUrlManager = new UrlManager(seventhUrl);
        UrlManager eighthUrlManager = new UrlManager(eighthUrl);

        List<UrlManager> urlManagers = new ArrayList<>();

        urlManagers.add(firstUrlManager);
        urlManagers.add(secondUrlManager);
        urlManagers.add(thirdUrlManager);
        urlManagers.add(fourthUrlManager);
        urlManagers.add(fifthUrlManager);
        urlManagers.add(sixthUrlManager);
        urlManagers.add(seventhUrlManager);
        urlManagers.add(eighthUrlManager);

        for (int i = 0; i < urlManagers.size(); i++) {
            System.out.println(i + 1 + ". protocol: " + urlManagers.get(i).getProtocol());
            System.out.println(i + 1 + ". host: " + urlManagers.get(i).getHost());
            System.out.println(i + 1 + ". port: " + urlManagers.get(i).getPort());
            System.out.println(i + 1 + ". path: " + urlManagers.get(i).getPath());
            System.out.println(i + 1 + ". property \"format\": " + urlManagers.get(i).getProperty("format"));
            System.out.println(i + 1 + ". property \"Start time\": " + urlManagers.get(i).getProperty("starttime"));
            System.out.println(i + 1 + ". property \"End time\": " + urlManagers.get(i).getProperty("endtime"));
        }
    }
}
