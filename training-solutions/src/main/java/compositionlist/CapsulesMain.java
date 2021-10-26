package compositionlist;

public class CapsulesMain {

    public static void main(String[] args) {

        Capsules capsules = new Capsules();

        capsules.addFirst("brown");
        capsules.addLast("yellow");
        capsules.addFirst("green");
        capsules.addLast("orange");
        capsules.addFirst("blue");
        capsules.addLast("red");
        System.out.println(capsules.getColors().toString());

        capsules.removeFirst();
        capsules.removeLast();
        System.out.println(capsules.getColors().toString());

        capsules.removeFirst();
        capsules.removeLast();
        System.out.println(capsules.getColors().toString());
    }
}
