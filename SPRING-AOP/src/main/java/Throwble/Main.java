package Throwble;

public class Main {

    public static void main(String[] args) {
        try {
            throw new ErrorClass();
        } catch (Throwable tr) {
            System.out.println(tr.toString());
        }
    }
}

class ErrorClass extends Throwable {

}
