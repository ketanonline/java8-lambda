package problems;

import java.util.Comparator;
import java.util.List;

public class SeatBooking {

    public static void book(List<SeatGroup> seatGroups, Integer i) {
        seatGroups.sort(Comparator.comparingLong(SeatGroup::availableCount));
        SeatGroup seatGroup = seatGroups.stream()
                .filter(sg -> sg.availableCount() >= i.intValue())
                .findFirst()
                .orElseThrow(() -> new RuntimeException("No slots available for " + i.intValue() + " in group"));
        long bookedCount = seatGroup.seats.stream()
                .filter(Seat::available)
                .map(Seat::book)
                .limit(i.intValue())
                .count();
        if(bookedCount != i.intValue())
            throw new RuntimeException("Unexpected Error occured. Couldn't allocate all the seats." );

    }
}
