class MathUtility {

    // Factorial Method
    public static long factorial(int n) {
        if (n < 0) return -1;

        long fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }

    // Prime Check Method
    public static boolean isPrime(int n) {
        if (n <= 1) return false;

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    // GCD Method
    public static int gcd(int a, int b) {
        if (a < 0 || b < 0) return -1;

        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // Fibonacci Method
    public static int fibonacci(int n) {
        if (n < 0) return -1;
        if (n == 0) return 0;
        if (n == 1) return 1;

        int a = 0, b = 1, c;
        for (int i = 2; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return b;
    }
}

// Testing MathUtility
class MathUtilityTest {
    public static void main(String[] args) {

        System.out.println("Factorial(5): " + MathUtility.factorial(5));
        System.out.println("Factorial(-3): " + MathUtility.factorial(-3));

        System.out.println("Is 7 Prime? " + MathUtility.isPrime(7));
        System.out.println("Is 1 Prime? " + MathUtility.isPrime(1));

        System.out.println("GCD(48, 18): " + MathUtility.gcd(48, 18));
        System.out.println("GCD(-5, 10): " + MathUtility.gcd(-5, 10));

        System.out.println("Fibonacci(7): " + MathUtility.fibonacci(7));
        System.out.println("Fibonacci(0): " + MathUtility.fibonacci(0));
    }
}
