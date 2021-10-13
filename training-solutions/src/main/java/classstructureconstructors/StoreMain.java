package classstructureconstructors;

public class StoreMain {

    public static void main(String[] args) {

        Store krumpliStore = new Store("krumpli");
        Store repaStore = new Store("répa");

        krumpliStore.store(25);
        repaStore.store(12);

        System.out.println("Stored " + krumpliStore.getProduct() + ": " + krumpliStore.getStock() + "t.");
        System.out.println("Stored " + repaStore.getProduct() + ": " + repaStore.getStock() + "t.");

        krumpliStore.dispatch(16);
        repaStore.dispatch(6);

        System.out.println("Stored " + krumpliStore.getProduct() + ": " + krumpliStore.getStock() + "t.");
        System.out.println("Stored " + repaStore.getProduct() + ": " + repaStore.getStock() + "t.");

    }





}
