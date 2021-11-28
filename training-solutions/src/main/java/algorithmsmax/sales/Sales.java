package algorithmsmax.sales;

import java.util.List;

public class Sales {

    public Salesperson selectSalesPersonWithMaxSalesAmount(List<Salesperson> sales) {
        int maxAmount = 0;
        Salesperson personWithMaxSalesAmount = null;
        for (Salesperson person : sales) {
            if (person.getAmount() > maxAmount) {
                maxAmount = person.getAmount();
                personWithMaxSalesAmount = person;
            }
        }
        return personWithMaxSalesAmount;
    }

    public Salesperson selectSalesPersonWithFurthestAboveTarget(List<Salesperson> sales) {
        int furthestTarget = Integer.MIN_VALUE;
        Salesperson personWithFurthestAboveTarget = null;
        for (Salesperson person : sales) {
            if (person.getDifferenceFromTarget() > furthestTarget) {
                furthestTarget = person.getDifferenceFromTarget();
                personWithFurthestAboveTarget = person;
            }
        }
        return personWithFurthestAboveTarget;
    }

    public Salesperson selectSalesPersonWithFurthestBelowTarget(List<Salesperson> sales) {
        int furthestTarget = Integer.MAX_VALUE;
        Salesperson personWithFurthestBelowTarget = null;
        for (Salesperson person : sales) {
            if (person.getDifferenceFromTarget() < furthestTarget) {
                furthestTarget = person.getDifferenceFromTarget();
                personWithFurthestBelowTarget = person;
            }
        }
        return personWithFurthestBelowTarget;
    }
}
