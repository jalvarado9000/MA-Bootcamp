package com.techelevator.dao;

import com.techelevator.model.Reservation;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class JdbcReservationDaoTests extends BaseDaoTests {

    private ReservationDao dao;

    @Before
    public void setup() {
        dao = new JdbcReservationDao(dataSource);
    }

    @Test
    public void createReservation_Should_ReturnNewReservationId() {
        int reservationCreated = dao.createReservation(1,
                "TEST NAME",
                LocalDate.now().plusDays(1),
                LocalDate.now().plusDays(3));

        assertEquals(5, reservationCreated);
    }

    @Test
    public void getUpcomingReservations_Returns_Correctly() {
        List<Reservation> reservations = dao.getUpcomingReservations();

        assertEquals(2, reservations.size());
        assertEquals( false, reservations.get(1).getFromDate().compareTo(LocalDate.now()) > 30);
        assertEquals( true, reservations.get(1).getToDate().compareTo(LocalDate.now()) < 30);
        assertEquals( false, reservations.get(1).getFromDate().compareTo(LocalDate.now()) < 1);
        assertEquals( false, reservations.get(0).getFromDate().compareTo(LocalDate.now()) > 30);
        assertEquals( true, reservations.get(0).getToDate().compareTo(LocalDate.now()) < 30);
        assertEquals( false, reservations.get(0).getFromDate().compareTo(LocalDate.now()) < 1);
    }

}
