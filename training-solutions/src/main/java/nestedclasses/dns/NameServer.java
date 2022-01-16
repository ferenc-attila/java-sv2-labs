package nestedclasses.dns;

import java.util.ArrayList;
import java.util.List;

public class NameServer {

    private List<DnsEntry> entries = new ArrayList<>();

    private static class DnsEntry {
        private String hostName;
        private String hostIp;

        public DnsEntry(String hostName, String hostIp) {
            this.hostName = hostName;
            this.hostIp = hostIp;
        }
    }

    public void addEntry(String hostName, String hostIp) {
        validateNewEntry(hostName, hostIp);
        entries.add(new DnsEntry(hostName, hostIp));
    }

    private void validateNewEntry(String hostName, String hostIp) {
        for (DnsEntry actual : entries) {
            if (actual.hostName.equals(hostName) || actual.hostIp.equals(hostIp)) {
                throw new IllegalArgumentException("Already exists");
            }
        }
    }

    public void removeEntryByName(String hostName) {
        for (int i = 0; i < entries.size(); i++) {
            if (entries.get(i).hostName.equals(hostName)) {
                entries.remove(entries.get(i));
            }
        }
    }

    public void removeEntryByIp(String hostIp) {
        for (int i = 0; i < entries.size(); i++) {
            if (entries.get(i).hostIp.equals(hostIp)) {
                entries.remove(entries.get(i));
            }
        }
    }

    public String getIpByName(String hostName) {
        for (DnsEntry actual : entries) {
            if (actual.hostName.equals(hostName)) {
                return actual.hostIp;
            }
        }
        throw new IllegalArgumentException("Element not found");
    }

    public String getNameByIp(String hostIp) {
        for (DnsEntry actual : entries) {
            if (actual.hostIp.equals(hostIp)) {
                return actual.hostName;
            }
        }
        throw new IllegalArgumentException("Element not found");
    }
}
