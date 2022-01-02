package interfacerules.bill;

import java.util.List;

public class ComplexBillWriter implements BillWriter {

    @Override
    public String writeBill(List<String> billItems) {
        StringBuilder complexBill = new StringBuilder();
        for (String row : billItems) {
            String[] values = row.split(";");
            complexBill.append(values[0]);
            complexBill.append("; darabszám: ");
            complexBill.append(values[2]);
            complexBill.append(", egységár: ");
            complexBill.append(values[1]);
            complexBill.append(", összesen: ");
            complexBill.append(Integer.parseInt(values[1]) * Integer.parseInt(values[2]));
            complexBill.append(" Ft\n");
        }
        return complexBill.toString();
    }
}
