package com.techelevator.controller;

import com.techelevator.dao.CatCardDao;
import com.techelevator.model.CatCard;
import com.techelevator.model.CatCardNotFoundException;
import com.techelevator.services.CatFactService;
import com.techelevator.services.CatPicService;
import org.springframework.http.HttpStatus;
import org.springframework.http.StreamingHttpOutputMessage;
import org.springframework.web.bind.annotation.*;

import javax.annotation.processing.Generated;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/cards")
public class CatController {

    private CatCardDao catCardDao;
    private CatFactService catFactService;
    private CatPicService catPicService;

    public CatController(CatCardDao catCardDao, CatFactService catFactService, CatPicService catPicService) {
        this.catCardDao = catCardDao;
        this.catFactService = catFactService;
        this.catPicService = catPicService;
    }

    @GetMapping
    public List<CatCard> list(){
        return catCardDao.list();
    }

    @GetMapping(path = "/{id}")
    public CatCard getCatCard(@Valid @PathVariable long id){
        return catCardDao.get(id);
    }

    @GetMapping(path = "/random")
    public CatCard random(){
        CatCard randomCard = new CatCard();
        String catFact = catFactService.getFact().getText();
        randomCard.setCatFact(catFact);
        String url = catPicService.getPic().getFile();
        randomCard.setImgUrl(url);

        return randomCard;
    }

    @PostMapping
    public boolean save(@RequestBody  CatCard cardToSave){
        return catCardDao.save(cardToSave);
    }

    @PutMapping(path = "/{id}")
    public boolean update(@PathVariable long id, @RequestBody CatCard catCard) throws CatCardNotFoundException{
        return catCardDao.update(id, catCard);
    }

    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @DeleteMapping(path = "/{id}")
    public boolean delete(@Valid @PathVariable long id) throws CatCardNotFoundException {
        return catCardDao.delete(id);
    }

}
