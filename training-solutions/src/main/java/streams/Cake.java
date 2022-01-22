package streams;

import java.util.List;

public class Cake {

    private String name;
    private List<String> ingredients;

    public Cake(String name, List<String> ingredients) {
        this.name = name;
        this.ingredients = ingredients;
    }

    public String getName() {
        return name;
    }

    public List<String> getIngredients() {
        return List.copyOf(ingredients);
    }
}
