public class StoreMain {

    public static void main(String[] args) {

        Store krumpliStore = new Store ("krumpli", 5);
        Store repaStore = new Store ("répa", 8);

        krumpliStore.store(6);
        System.out.println("A " + krumpliStore.getProduct() + " raktárban tárolt mennyisége " + krumpliStore.getStock() + " tonna.");

        repaStore.store(1234);
        System.out.println("A " + repaStore.getProduct() + " raktárban tárolt mennyisége " + repaStore.getStock() + " tonna.");

        krumpliStore.dispatch (9);
        System.out.println("A " + krumpliStore.getProduct() + " raktárban tárolt mennyisége " + krumpliStore.getStock() + " tonna.");

        repaStore.dispatch(789);
        System.out.println("A " + repaStore.getProduct() + " raktárban tárolt mennyisége " + repaStore.getStock() + " tonna.");
        
    }
}
