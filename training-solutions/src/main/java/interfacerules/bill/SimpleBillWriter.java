package interfacerules.bill;

import java.util.List;

public class SimpleBillWriter implements BillWriter {

    @Override
    public String writeBill(List<String> billItems) {
        StringBuilder simpleBill = new StringBuilder();
        for (String row : billItems) {
            String[] values = row.split(";");
            simpleBill.append(values[0]);
            simpleBill.append(", ");
            simpleBill.append(values[2]);
            simpleBill.append(" * ");
            simpleBill.append(values[1]);
            simpleBill.append(" = ");
            simpleBill.append(Integer.parseInt(values[1]) * Integer.parseInt(values[2]));
            simpleBill.append(" Ft\n");
        }
        return simpleBill.toString();
    }
}
