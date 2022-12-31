package com.techelevator.auctions.controller;

import com.techelevator.auctions.dao.AuctionDao;
import com.techelevator.auctions.dao.MemoryAuctionDao;
import com.techelevator.auctions.model.Auction;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/auctions")
public class AuctionController {

    private AuctionDao dao;

    public AuctionController() {
        this.dao = new MemoryAuctionDao();
    }


//    @RequestMapping(method = RequestMethod.GET)
//    public List<Auction> list(){
//        return dao.list();
//    }

    //throws does not show
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Auction get(@PathVariable int id) throws ExceptionHandler1 {

        if(dao.list().size()-1 < (id)) {
            throw new ExceptionHandler1(" ");
        }
        return dao.get(id);
    }

    @RequestMapping(path = "", method = RequestMethod.POST)
    public Auction create(@RequestBody Auction auction) throws ExceptionHandler2{

        if (auction !=null) {
            dao.create(auction);
        }
        if(auction.equals(null)){
            throw new ExceptionHandler2();
        }
        return auction;
    }

    @RequestMapping(path = "", method = RequestMethod.GET)
    public List<Auction> list(@RequestParam(defaultValue = "")String title_like,
        @RequestParam(defaultValue = "0")double currentBid_lte){

        if(!title_like.equals("") && currentBid_lte > 0 )
            return dao.searchByTitleAndPrice(title_like, currentBid_lte);

        if(!title_like.equals(""))
            return dao.searchByTitle(title_like);

        if(currentBid_lte > 0)
            return dao.searchByPrice(currentBid_lte);

        return dao.list();

        }





}
