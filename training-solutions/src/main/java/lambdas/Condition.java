package lambdas;

@FunctionalInterface
public interface Condition {
    boolean test(Employee employee);
}
