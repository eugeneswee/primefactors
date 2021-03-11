import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class PrimeFactors {
    public static List<Long> primeFactors(long number) {
        long n = number;
        List<Long> factors = new ArrayList<Long>();
        for (long i = 2; i <= n; i++) {
            while (n % i == 0) {
                factors.add(i);
                n /= i;
            }
        }
        return factors;
    }

    public static String humanReadableFormat(Duration duration) {
        return duration.toString()
                .substring(2)
                .replaceAll("(\\d[HMS])(?!$)", "$1 ")
                .toLowerCase();
    }

    public static void main(String[] args) {
        Long prime = null;
        if (System.getenv("prime") == null) {
            prime = 1127451830576035879L;
        } else {
            prime = Long.valueOf(System.getenv("prime"));
        }

        System.out.println("# of CPU cores:" + Runtime.getRuntime().availableProcessors());

        Instant start = Instant.now();

        System.out.println("Prime Factors of " + prime);
        for (Long number : primeFactors(prime)) {
            System.out.println(number);
        }

        Instant end = Instant.now();

        System.out.println("Duration:" + humanReadableFormat(Duration.between(start, end)));
    }
}
