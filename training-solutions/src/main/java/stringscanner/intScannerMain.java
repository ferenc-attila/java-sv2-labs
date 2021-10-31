package stringscanner;

public class intScannerMain {

    public static void main(String[] args) {

        IntScanner intScanner = new IntScanner();

        String firstIntList = "5;3;107;12;123;18;198";
        String secondIntList = "5;3;107;12;18";
        String thirdIntList = "5;3;12;18";
        String fourthIntList = "";
        String fifthIntList = "101";


        System.out.println(intScanner.convertInts(firstIntList));
        System.out.println(intScanner.convertInts(secondIntList));
        System.out.println(intScanner.convertInts(thirdIntList));
        System.out.println(intScanner.convertInts(fourthIntList));
        System.out.println(intScanner.convertInts(fifthIntList));
    }
}
