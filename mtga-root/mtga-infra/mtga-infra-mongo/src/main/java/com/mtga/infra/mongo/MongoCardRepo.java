package com.mtga.infra.mongo;

import java.io.Serializable;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.mtga.model.mtg.Card;

/**
 * No need for @Profile here since that should be controlled by MongoCardServiceImpl
 * @author mbmartinez
 */
public interface MongoCardRepo extends PagingAndSortingRepository<Card, Serializable> {

}