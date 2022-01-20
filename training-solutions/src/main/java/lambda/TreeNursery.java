package lambda;

import java.util.List;

public class TreeNursery {

    private List<Sapling> saplings;

    public TreeNursery(List<Sapling> saplings) {
        this.saplings = saplings;
    }

    public void prune (int maxHeight) {
        saplings.forEach(sapling -> sapling.cut(maxHeight));
    }

    public void sell(String species, int minHeight) {
        saplings.removeIf(sapling -> species.equals(sapling.getSpecies()) && sapling.getHeight() > minHeight);
    }

    public List<Sapling> getSaplings() {
        return List.copyOf(saplings);
    }
}
