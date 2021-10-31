package stringmethods;

public class UrlManager {

    private String protocol;
    private Integer port;
    private String host;
    private String path;
    private String query;

    public UrlManager(String url) {
        this.protocol = setProtocolByUrl(url);
        this.port = setPortByUrl(url);
        this.host = setHostByUrl(url);
        this.path = setPathByUrl(url);
        this.query = setQueryByUrl(url);
    }

    public String getProtocol() {
        return protocol;
    }

    public Integer getPort() {
        return port;
    }

    public String getHost() {
        return host;
    }

    public String getPath() {
        return path;
    }

    public boolean hasProperty(String key) {
        if (query == null) {
            return false;
        }
        return query.contains(key);
    }

    public String getProperty(String key) {
        if (!hasProperty(key)) {
            return "I didn't find the key in the URL.";
        }
        int firstIndexOfProperty = query.indexOf("=", query.indexOf(key)) + 1;
        int lastIndexOfProperty = query.indexOf("&", firstIndexOfProperty);
        if (lastIndexOfProperty == -1) {
            lastIndexOfProperty = query.length();
        }
        return query.substring(firstIndexOfProperty, lastIndexOfProperty);
    }

    private int getHostStartIndex(String url) {
        return url.indexOf("://") + 3;
    }

    private int getPortStartIndex(String url) {
        return url.indexOf(":", getHostStartIndex(url));
    }

    private int getHostEndIndex(String url) {
        return url.indexOf("/", getHostStartIndex(url));
    }

    private int getQueryStartIndex(String url) {
        return url.indexOf("?");
    }

    private String setProtocolByUrl(String url) {
        return (url.substring(0, url.indexOf("://"))).toLowerCase();
    }

    private String setHostByUrl(String url) {
        int startIndex = getHostStartIndex(url);
        int endIndex = getHostEndIndex(url);
        if (endIndex == -1) {
            host = url.substring(startIndex);
        } else {
            host = url.substring(startIndex, endIndex);
        }
        if (getPortStartIndex(url) >= 0) {
            host = url.substring(startIndex, getPortStartIndex(url));
        }
        return host.toLowerCase();
    }

    private Integer setPortByUrl(String url) {
        int startIndex = getPortStartIndex(url) + 1;
        if (startIndex <= getHostStartIndex(url)) {
            return null;
        }
        int endIndex = getHostEndIndex(url);
        if (endIndex == -1) {
            endIndex = url.length() - 1;
        }
        if (startIndex >= 0) {
            String portString = url.substring(startIndex, endIndex);
            return Integer.parseInt(portString);
        }
        return null;
    }

    private String setPathByUrl(String url) {
        int startIndex = getHostEndIndex(url);
        if (startIndex == -1) {
            return null;
        }
        int endIndex = getQueryStartIndex(url);
        if (endIndex == -1) {
            endIndex = url.length();
        }
        path = url.substring(startIndex, endIndex);
        if (path.length() <= 1) {
            path = null;
        }
        return path;
    }

    private String setQueryByUrl(String url) {
        if (url.indexOf("?") >= 0) {
            return url.substring(url.indexOf("?"));
        }
        return null;
    }
}