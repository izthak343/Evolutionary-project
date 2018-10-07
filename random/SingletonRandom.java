package random;
import java.util.Random;


public enum SingletonRandom {
    INSTANCE(new Random()); // 4568321548855l

    private Random rand;

    private SingletonRandom(Random rand) {
        this.rand = rand;
    }

    public synchronized int nextInt(int low, int high) {
        return rand.nextInt(high-low) + low;
    }
    
    public synchronized int nextInt(int n) {
        return rand.nextInt(n);
    }

    public Random getRand() {
        return rand;
    }
}
