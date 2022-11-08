package com.techelevator.dao;

import com.techelevator.model.Site;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class JdbcSiteDao implements SiteDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcSiteDao(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Site> getSitesThatAllowRVs(int parkId) {
        List<Site> rvSites = new ArrayList<>();
        String sql = "SELECT site_id, campground_id, site_number, max_occupancy, accessible, max_rv_length, utilities " +
                "FROM site JOIN campground USING(campground_id) WHERE park_id = ? AND max_rv_length != 0;";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, parkId);
        while(result.next()){
            rvSites.add(mapRowToSite(result));
        }
        return rvSites;
    }

    public List<Site> getAvailableSites() {
        List<Site> available = new ArrayList<>();
        String sql = "SELECT site_id, campground_id, site_number, max_occupancy, accessible, max_rv_length, utilities " +
                "FROM site JOIN reservation USING(site_id) " +
                "WHERE from_date <> current_date AND to_date <> current_date AND from_date > current_date ;";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql);
        while(result.next()){
            available.add(mapRowToSite(result));
        }
        return available;
    }

    public List<Site> getFutureAvailableSites(String name, LocalDate start, LocalDate end){
        List<Site> available = new ArrayList<>();
        String sql = "SELECT DISTINCT site_id, campground_id, site_number, max_occupancy, accessible, max_rv_length, utilities " +
                "FROM reservation JOIN site USING(site_id) JOIN campground USING(campground_id) JOIN park USING(park_id)" +
                "WHERE park.name = ? AND (from_date > ? AND to_date > ?) OR (from_date < ? AND to_date < ?) OR (from_date > ? AND to_date > ?);";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, name, start, end, start, start, end, end);
        while(result.next()){
            available.add(mapRowToSite(result));
        }
        return available;
    }

    private Site mapRowToSite(SqlRowSet results) {
        Site site = new Site();
        site.setSiteId(results.getInt("site_id"));
        site.setCampgroundId(results.getInt("campground_id"));
        site.setSiteNumber(results.getInt("site_number"));
        site.setMaxOccupancy(results.getInt("max_occupancy"));
        site.setAccessible(results.getBoolean("accessible"));
        site.setMaxRvLength(results.getInt("max_rv_length"));
        site.setUtilities(results.getBoolean("utilities"));
        return site;
    }
}
