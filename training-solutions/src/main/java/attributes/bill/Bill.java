package attributes.bill;

public class Bill {

    public static void main(String[] args) {

        BillItem billItem = new BillItem("bread", 500, 2, 27.0);

        System.out.println(billItem.getProduct());
        System.out.println(billItem.getPrice());
        System.out.println(billItem.getQuantity());
        System.out.println(billItem.getVatPercent());
        System.out.println(billItem.calculateTotalPrice());
    }
}
