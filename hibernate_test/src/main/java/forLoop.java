public class forLoop {

    public static void main(String[] args) {

        for (int k = 0; k < 200; k++) {
            System.out.println("____________Try no. " + k + " _____________");
            int counter = 0;
            for (int i = 0; i <= callMethod(); i++) {
                System.out.println("Loop no. " + i);
                counter++;
            }
            if (counter > 1) System.out.println("Success! " + counter);
        }
        System.gc();
    }

    private static int callMethod() {
        int result = (int)(Math.random() + 0.5);
        System.out.println("Method called! " + result);
        return result;
    }
}
