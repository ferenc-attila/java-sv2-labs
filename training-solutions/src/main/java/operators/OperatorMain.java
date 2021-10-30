package operators;

public class OperatorMain {

    public static void main(String[] args) {

//        System.out.println(Integer.toBinaryString(9));
//        System.out.println(Integer.toBinaryString(9 << 1));
//        System.out.println(Integer.toBinaryString(9 >> 1));
//
//        System.out.println(Integer.toBinaryString(Integer.MIN_VALUE));
//        System.out.println(Integer.toBinaryString(Integer.MIN_VALUE >> 1));
//        System.out.println(Integer.toBinaryString(Integer.MIN_VALUE >>> 1));
//
//        int i;
//        int j;
//        i = 5;
//        j = (i = 5);
//
//        System.out.println(true | (1 / 0 == 0));

        Operators operators = new Operators();

        System.out.println(Integer.toBinaryString(65));
        System.out.println(operators.isEven(65));
        System.out.println(operators.isEven(66));

        System.out.println(operators.getResultOfDivision(48,8));

        String s = null;
        System.out.println(operators.isNull(s));
        System.out.println(operators.isEmpty(s));
        s = "";
        System.out.println(operators.isNull(s));
        System.out.println(operators.isEmpty(s));
        s = " ";
        System.out.println(operators.isNull(s));
        System.out.println(operators.isEmpty(s));
    }
}
