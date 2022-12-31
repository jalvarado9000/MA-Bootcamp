package com.techelevator.auctions.services;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.techelevator.auctions.model.Auction;

public class AuctionService {

    public static final String API_BASE_URL = "http://localhost:3000/auctions/";
    private RestTemplate restTemplate = new RestTemplate();



    public Auction[] getAllAuctions() {
        // call api here
        Auction[] response = restTemplate.getForObject(API_BASE_URL, Auction[].class);
        return response;
    }

    public Auction getAuction(int id) {
        // call api here
        Auction response = restTemplate.getForObject((API_BASE_URL+id), Auction.class);
        return response;
    }

    public Auction[] getAuctionsMatchingTitle(String title) {
        // call api here
        Auction[] response = restTemplate.getForObject((API_BASE_URL+ "?title_like=" + title), Auction[].class);
        return response;
    }

    public Auction[] getAuctionsAtOrBelowPrice(double price) {
        // call api here
        Auction[] response = restTemplate.getForObject((API_BASE_URL+ "?currentBid_lte=" + price), Auction[].class);

        return response;
    }

}
