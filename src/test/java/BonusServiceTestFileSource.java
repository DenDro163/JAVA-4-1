import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class BonusServiceTestFileSource {

    @ParameterizedTest
    @CsvFileSource(resources = "/data.csv", delimiter = ',', numLinesToSkip = 1)

    public void shouldCalculateBonus(String test, long amount, boolean registered, int expected) {
        BonusService service = new BonusService();
        int actual = (int) service.calculate(amount, registered);
        assertEquals(expected, actual);
    }

}