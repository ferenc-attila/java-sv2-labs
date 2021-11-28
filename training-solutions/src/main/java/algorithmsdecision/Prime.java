package algorithmsdecision;

public class Prime {

    public boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        int i = 2;
        while (i < (number / 2)) {
            if (number % i == 0) {
                return false;
            }
            i++;
        }
        return true;
    }
}
