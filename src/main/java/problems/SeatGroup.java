package problems;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class SeatGroup {
    List<Seat> seats;
    private SeatGroup() {}
    public static SeatGroup of(int size) {
        SeatGroup seatGroup = new SeatGroup();
        seatGroup.seats = IntStream.range(0, size).mapToObj(i -> new Seat()).collect(Collectors.toList());
        return seatGroup;
    }

    public long availableCount() {
        return seats.stream().filter(Seat::available).count();
    }

    public String status() {
        return seats.stream().map(Seat::status).collect(Collectors.joining(" "));
    }
}
