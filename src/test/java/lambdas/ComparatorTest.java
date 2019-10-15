package lambdas;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ComparatorTest {

    @Test
    void testComparatorByName() {
        Person mary = new Person("Mary" , 28);
        Person john = new Person("John" , 22);
        Person linda = new Person("Linda" , 26);
        Person james = new Person("James" , 32);

        Function<Person, String> getName = p -> p.name;
        Comparator<Person> cmp = Comparator.comparing(getName);
        Comparator<Person> cmpReversed = cmp.reversed();

        System.out.println("Mary > John:" + (cmp.compare(mary, john) > 0));
        System.out.println("John > James:" + (cmp.compare(john, james) > 0));
        System.out.println("Linda > James:" + (cmp.compare(linda, james) > 0));
    }

    @Test
    void testComparatorByNameReverse() {
        Person mary = new Person("Mary" , 28);
        Person john = new Person("John" , 22);
        Person linda = new Person("Linda" , 26);
        Person james = new Person("James" , 32);

        Function<Person, String> getName = p -> p.name;
        Comparator<Person> cmp = Comparator.comparing(getName);
        Comparator<Person> cmpReversed = cmp.reversed();

        System.out.println("Mary > John:" + (cmpReversed.compare(mary, john) > 0));
        System.out.println("John > James:" + (cmpReversed.compare(john, james) > 0));
        System.out.println("Linda > James:" + (cmpReversed.compare(linda, james) > 0));
    }

    @Test
    void testComparatorByNameCompose() {
        Person mary = new Person("Mary" , 28);
        Person john = new Person("John" , 22);
        Person linda = new Person("Linda" , 26);
        Person james = new Person("James" , 32);
        Person jamesBis = new Person("James" , 26);

        Function<Person, String> getName = p -> p.name;
        Function<Person, Integer> getAge = p -> p.age;
        Comparator<Person> cmpName = Comparator.comparing(getName);
        Comparator<Person> cmpAge = Comparator.comparing(getAge);

        Comparator<Person> cmp = cmpName.andThen(cmpAge);

        System.out.println("Mary > John:" + (cmp.compare(mary, john) > 0));
        System.out.println("John > James:" + (cmp.compare(john, james) > 0));
        System.out.println("Linda > James:" + (cmp.compare(linda, james) > 0));
        System.out.println("JamesBis > James:" + (cmp.compare(jamesBis, james) > 0));
    }


}