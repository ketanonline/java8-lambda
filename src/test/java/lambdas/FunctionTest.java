package lambdas;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FunctionTest {

    @Test
    void testReadTemperatureInFahrenheit() {
        Meteo meteo = new Meteo(10);

        Function<Meteo, Integer> readCelsius = m -> m.getTemperature();
        Function<Integer, Double> celsiusToFahrenheit = t -> t*9d/5d + 32d;

        Function<Meteo, Double> readFahrenheit = readCelsius.andThen(celsiusToFahrenheit);

        readFahrenheit = celsiusToFahrenheit.compose(readCelsius);

        System.out.println(" Meteo is F " + readFahrenheit.apply(meteo));
    }

    @Test
    void testIdentity() {
        Function<String, String> identity = Function.identiy();

    }
}