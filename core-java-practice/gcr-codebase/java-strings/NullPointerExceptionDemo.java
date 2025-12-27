class NullPointerExceptionDemo {

    // Method to generate NullPointerException
    public static void generateException() {
        String text = null;                 // text initialized to null
        System.out.println(text.length()); // causes NullPointerException
    }

    // Method to handle NullPointerException
    public static void handleException() {
        String text = null;          // text initialized to null

        try {
            System.out.println(text.length()); // causes NullPointerException
        } catch (NullPointerException e) {
            System.out.println("NullPointerException handled successfully.");
        }
    }

    public static void main(String[] args) {

        // 1. Calling method that generates NullPointerException
        try {
            generateException();
        } catch (NullPointerException e) {
            System.out.println("Exception generated in generateException() method.");
        }

        // 2. Calling refactored method that handles NullPointerException
        handleException();
    }
}
