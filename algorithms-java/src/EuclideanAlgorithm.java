public class EuclideanAlgorithm {
    public static void main(String[] args) {
        System.out.println(gcd(252, 105));
    }

    public static int gcd(int p, int q) {
        if (q == 0) {
            return p;
        } else {
            return gcd(q, p % q);
        }
    }
}
