package com.techelevator.dao;

import com.techelevator.model.Reservation;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class JdbcReservationDao implements ReservationDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcReservationDao(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public int createReservation(int siteId, String name, LocalDate fromDate, LocalDate toDate) {
        Reservation r = null;
        String sql = "INSERT INTO reservation(site_id, name, from_date, to_date, create_date) " +
                "VALUES(?,?,?,?,?) ;";
        jdbcTemplate.update(sql, siteId, name, fromDate, toDate, LocalDate.now());
        sql = "SELECT reservation_id, site_id, name, from_date, to_date, create_date " +
                "FROM reservation " +
                "ORDER BY reservation_id DESC";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql);
        if(result.next()){
         r = mapRowToReservation(result);
        }
        return r.getReservationId();
    }

    public List<Reservation> getUpcomingReservations(){
        List<Reservation> upcomingReservations = new ArrayList<>();
        String sql = "SELECT reservation_id, site_id, name, from_date, to_date, create_date " +
                "FROM reservation WHERE from_date > current_date AND to_date < current_date + 30 " +
                "ORDER BY from_date, to_date ;";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql);
        while(result.next()){
            upcomingReservations.add(mapRowToReservation(result));
        }
        return upcomingReservations;
    }

    private Reservation mapRowToReservation(SqlRowSet results) {
        Reservation r = new Reservation();
        r.setReservationId(results.getInt("reservation_id"));
        r.setSiteId(results.getInt("site_id"));
        r.setName(results.getString("name"));
        r.setFromDate(results.getDate("from_date").toLocalDate());
        r.setToDate(results.getDate("to_date").toLocalDate());
        r.setCreateDate(results.getDate("create_date").toLocalDate());
        return r;
    }


}
