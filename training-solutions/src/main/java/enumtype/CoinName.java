package enumtype;

public class CoinName {

    public static void main(String[] args) {

        Coin c = Coin.HUNDRED;

        for (Coin i : Coin.values()) {
            System.out.println(i);
        }

        System.out.println(c.ordinal());

        System.out.println(c.name());

        Coin c2 = Coin.valueOf("FIVE");
        System.out.println(c2);

        System.out.println(c2.getValue());
    }
}
