import static org.junit.jupiter.api.Assertions.*;

public class BonusServiceTest {

    @org.junit.jupiter.api.Test
    void shouldCalculateForRegisteredAndUnderLimit() {
        BonusService service = new BonusService();

        // подготавливаем данные:
        long amount = 1000_60;//Сумма покупки в копейках
        boolean registered = true;
        long expected = 30;

        // вызываем целевой метод:
        long actual = service.calculate(amount, registered);

        // производим проверку (сравниваем ожидаемый и фактический):
        assertEquals(expected, actual);
    }


        @org.junit.jupiter.api.Test
        void shouldCalculateForRegisteredAndOverLimit() {
            BonusService service = new BonusService();

            // подготавливаем данные:
            long amount = 1_000_000_60;
            boolean registered = true;
            long expected = 500;

            // вызываем целевой метод:
            long actual = service.calculate(amount, registered);

            // производим проверку (сравниваем ожидаемый и фактический):
            assertEquals(expected, actual);

        }

            @org.junit.jupiter.api.Test
            void shouldCalculateForNotRegisteredAndUnderLimit() {// Тест для незарегистр. меньше лимита.
                BonusService service = new BonusService();

                // подготавливаем данные:
                long amount = 1000_60;//Сумма покупки в копейках
                boolean registered = false;
                long expected = 10;

                // вызываем целевой метод:
                long actual = service.calculate(amount, registered);

                // производим проверку (сравниваем ожидаемый и фактический):
                assertEquals(expected, actual);
            }


    @org.junit.jupiter.api.Test
    void shouldCalculateForNotRegisteredAndOverLimit() {// Тест для незарегистр. больше лимита.
        BonusService service = new BonusService();

        // подготавливаем данные:
        long amount = 1_000_000_60;
        boolean registered = false;
        long expected = 500;

        // вызываем целевой метод:
        long actual = service.calculate(amount, registered);

        // производим проверку (сравниваем ожидаемый и фактический):
        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void shouldCalculateForRegisteredAndBoundaryUnderLimit() {// Тест для зарегистр. граничн. значение ниже лимита.
        BonusService service = new BonusService();

        // подготавливаем данные:
        long amount = 1663400;//Сумма покупки в копейках
        boolean registered = true;
        long expected = 499;

        // вызываем целевой метод:
        long actual = service.calculate(amount, registered);

        // производим проверку (сравниваем ожидаемый и фактический):
        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void shouldCalculateForNotRegisteredAndBoundaryUnderLimit() {// Тест для незарегистр. граничн. значение ниже лимита.
        BonusService service = new BonusService();

        // подготавливаем данные:
        long amount = 4990200;//Сумма покупки в копейках
        boolean registered = false;
        long expected = 499;

        // вызываем целевой метод:
        long actual = service.calculate(amount, registered);

        // производим проверку (сравниваем ожидаемый и фактический):
        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void shouldCalculateForRegisteredAndBoundaryOverLimit() {// Тест для зарегистр. граничн. значение больше лимита.
        BonusService service = new BonusService();

        // подготавливаем данные:
        long amount = 1670000;
        boolean registered = true;
        long expected = 500;

        // вызываем целевой метод:
        long actual = service.calculate(amount, registered);

        // производим проверку (сравниваем ожидаемый и фактический):
        assertEquals(expected, actual);

    }

    @org.junit.jupiter.api.Test
    void shouldCalculateForNotRegisteredAndBoundaryOverLimit() {// Тест для незарегистр. граничн. значение больше лимита.
        BonusService service = new BonusService();

        // подготавливаем данные:
        long amount = 5010000;
        boolean registered = false;
        long expected = 500;

        // вызываем целевой метод:
        long actual = service.calculate(amount, registered);

        // производим проверку (сравниваем ожидаемый и фактический):
        assertEquals(expected, actual);
    }
}
