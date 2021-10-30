package conversions;

public class DigitsMain {

    public static void main(String[] args) {

        Digits digits = new Digits();

        String text = "A 12 fejű sárkány 100 vitézt elnyelt, de a 101. csak 1 fejét kímélte meg.\n" +
                "A sárkány 3 várát immár a vitéz 1000 katonája őrzi, a király pedig neki adta\n" +
                "1 leányát, és 0.5 királyságát.";
        digits.addDigitsToList(text);

        System.out.println(digits.getDigits().toString());
    }
}
