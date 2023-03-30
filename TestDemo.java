import java.util.Random;
import java.util.function.IntPredicate;

public class TestDemo {

    public class MyClass {
        public int addPositive(int a, int b) {
            if (a <= 0 || b <= 0) {
                throw new IllegalArgumentException("Both parameters must be positive!");
            }
            return a + b;
        }
    }

    public int add(int i, int j) {
        return i + j;
    }

    public int subtract(int i, int j) {
        return i - j;
    }

    int getRandomInt() {
        Random random = new Random();
        return random.nextInt(10) + 1;
    }

    int randomNumberSquared() {
        int randomInt = getRandomInt();
        return randomInt * randomInt;
    }

	public IntPredicate addPositive(int a, int b) {
		// TODO Auto-generated method stub
		return null;
	}
}

// HI TESTING
