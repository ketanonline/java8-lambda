package problems;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

class SeatBookingTest {

    private List<SeatGroup> seatGroups;

    @BeforeEach
    public void init() {
        SeatGroup seatGroup1 = SeatGroup.of(2);
        SeatGroup seatGroup2 = SeatGroup.of(4);
        SeatGroup seatGroup3 = SeatGroup.of(2);

        seatGroups = Arrays.asList(seatGroup1, seatGroup2, seatGroup3);
    }
    @Test
    void testBookSeats() {
        System.out.println("Before status = " + seatGroups.stream().map(SeatGroup::status).collect(Collectors.joining("\t\t")));
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] s1 = s.split(" ");
        Arrays.stream(s1).map(Integer::parseInt).forEach(i -> SeatBooking.book(seatGroups, i));
        System.out.println("status = " + seatGroups.stream().map(SeatGroup::status).collect(Collectors.joining("\t\t")));
    }
}