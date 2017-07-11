import java.util.ArrayList;
import java.util.List;

/**
 * @author stanislav.lapitsky created 7/11/2017.
 */
public class SieveEratosthenes {
    static class PrimePair {
        Integer prime;
        Integer lastCrossed;

        PrimePair(Integer prime, Integer lastCrossed) {
            this.prime = prime;
            this.lastCrossed = lastCrossed;
        }
    }

    private List<PrimePair> primes;

    private SieveEratosthenes() {
        primes = new ArrayList<>();
        primes.add(new PrimePair(2, 2));
        primes.add(new PrimePair(3, 3));
    }

    private void fillNPrimes(int n) {
        while (primes.size()<n) {
            addNextPrime();
        }
    }

    private void addNextPrime() {
        int candidate = primes.get(primes.size()-1).prime + 2;
        for (int i = 1; i < primes.size(); i++) {
            PrimePair p = primes.get(i);
            while (p.lastCrossed < candidate) {
                p.lastCrossed += p.prime;
            }
            if (p.lastCrossed == candidate) {
                //restart
                candidate+=2;
                i=-1;
            }
        }
        System.out.println(candidate);
        primes.add(new PrimePair(candidate, candidate));
    }

    public static void main(String[] args) {
        SieveEratosthenes test = new SieveEratosthenes();
        test.fillNPrimes(1000);
    }
}
