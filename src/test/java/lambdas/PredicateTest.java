package lambdas;

import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class PredicateTest {

    @Test
    void testPredicate1() {
        Predicate<String> p1 = Objects::nonNull;
        Predicate<String> p2 = String::isEmpty;

        Predicate<String> p3 = p1.and(p2.negate());
        System.out.println("p3.test(null) = " + p3.test(null));
        System.out.println("p3.test(null) = " + p3.test(""));
        System.out.println("p3.test(null) = " + p3.test("Hello"));

    }
}