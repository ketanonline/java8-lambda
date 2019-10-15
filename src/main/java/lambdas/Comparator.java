package lambdas;

import java.util.Objects;

@FunctionalInterface
public interface Comparator<T> {

    int compare(T t1, T t2);

    static <T, R extends Comparable<? super R>> Comparator<T> comparing(Function<T, R> keyExtractor) {
        Objects.requireNonNull(keyExtractor);
        return (t1, t2) -> {
            R r1 = keyExtractor.apply(t1);
            R r2 = keyExtractor.apply(t2);
            return r1.compareTo(r2);
        };
    }

    default Comparator<T> reversed() {
        return (t1, t2) -> this.compare(t2, t1);
    }

    default Comparator<T> andThen(Comparator<T> other) {
        Objects.requireNonNull(other);
        return (T t1, T t2) -> {
            int compare = this.compare(t1, t2);
            if(compare == 0)
                return other.compare(t1, t2);
            else
                return compare;
        };
    }
}
