package com.timbuchalka;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Theatre theatre = new Theatre("Olympian", 8, 12);

        if(theatre.reserveSeat("D12")) {
            System.out.println("Please pay for D12");
        } else {
            System.out.println("Seat is already reserved");
        }
        if(theatre.reserveSeat("B13")) {
            System.out.println("Please pay for B13");
        } else {
            System.out.println("Seat is already reserved");
        }
        if(theatre.reserveSeat("D12")) {
            System.out.println("Please pay for D12");
        } else {
            System.out.println("Seat is already reserved");
        }

//        List<Theatre.Seat> reverseSeats = new ArrayList<>(theatre.getSeats());
//        Collections.reverse(reverseSeats);


        List<Theatre.Seat> priceSeats = new ArrayList<>(theatre.getSeats());
        priceSeats.add(theatre.new Seat("B00", 13.00));
        priceSeats.add(theatre.new Seat("A00", 13.00));
        printList(theatre.getSeats());
        Collections.sort(priceSeats, Theatre.PRICE_ORDER);
        printList(priceSeats);
    }

    public static void printList(Collection<Theatre.Seat> list) {
        for(Theatre.Seat seat : list) {
            System.out.print(" " + seat.getSeatNumber() + " $" + seat.getPrice());
        }
        System.out.println();
        System.out.println("========================");
    }
}
