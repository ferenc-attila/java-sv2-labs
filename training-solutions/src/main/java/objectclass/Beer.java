package objectclass;

public class Beer {

    String name;
    int price;

    public Beer(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        Beer beer = (Beer) o;
        return (price == beer.price) && (name.equals(beer.name));
    }
}
