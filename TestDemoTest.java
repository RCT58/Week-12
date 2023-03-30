import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.*;
import static org.mockito.Mockito.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class TestDemoTest {
    private TestDemo testDemo;

    @BeforeEach
    void setUp() throws Exception {
        testDemo = new TestDemo();
    }

    @ParameterizedTest
    @MethodSource("TestDemoTest#argumentsForAddPositive")
    void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected, boolean expectException) {
        if (!expectException) {
            assertThat(testDemo.addPositive(a, b)).isEqualTo(expected);
        } else {
            assertThatThrownBy(() -> testDemo.addPositive(a, b))
                    .isInstanceOf(IllegalArgumentException.class);
        } 
    }

    static Stream<Arguments> argumentsForAddPositive() {
        return Stream.of(
                arguments(0, 0, 0, false),
                arguments(0, 1, 1, false),
                arguments(1, 0, 1, false),
                arguments(1, 1, 2, false),
                arguments(-1, 1, 0, true),
                arguments(1, -1, 0, true),
                arguments(Integer.MAX_VALUE, 1, Integer.MIN_VALUE, true),
                arguments(Integer.MAX_VALUE, -1, Integer.MIN_VALUE + 1, true)
        );
    }

    @Test
    void assertThatNumberSquaredIsCorrect() {
        TestDemo mockDemo = spy(new TestDemo());
        doReturn(5).when(mockDemo).getRandomInt();
            
        int fiveSquared = mockDemo.randomNumberSquared();
            
        assertThat(fiveSquared).isEqualTo(25);
    }   
}

// TEST
