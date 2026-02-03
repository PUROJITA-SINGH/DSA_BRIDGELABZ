public class NullPointerDemo {
    static void generateException() {
        String text = null;
        System.out.println(text.length()); // This will throw NullPointerException
    }

    static void handleException() {
        String text = null;
        try {
            System.out.println(text.length());
        } catch (NullPointerException e) {
            System.out.println("Caught NullPointerException!");
        }
    }

    public static void main(String[] args) {
        //generateException(); // Uncomment to see the exception
        handleException(); // Safely handled
    }
}

