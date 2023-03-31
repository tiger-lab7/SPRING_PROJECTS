package ArithmeticErrorCatching;

public class ArithmeticErrorCatching {

    public static void main(String[] args) {

        try {
            int n = 678 / 0;
        } catch (Error er) { System.out.printf("This is error: %s", er.toString());}
    }
}
