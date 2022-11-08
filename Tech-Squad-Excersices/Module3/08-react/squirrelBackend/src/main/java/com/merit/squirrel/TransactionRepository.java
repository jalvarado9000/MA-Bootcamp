package com.merit.squirrel;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
public interface TransactionRepository  extends PagingAndSortingRepository<Transaction, Long> {

//    List<Transaction> findByDate(@Param("date") String date);
}
