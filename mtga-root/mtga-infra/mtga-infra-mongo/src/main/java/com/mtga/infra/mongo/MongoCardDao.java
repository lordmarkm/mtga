package com.mtga.infra.mongo;

import java.io.Serializable;
import java.util.Collection;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.mtga.model.mongo.MongoCard;

/**
 * No need for @Profile here since that should be controlled by MongoCardServiceImpl
 * @author mbmartinez
 */
public interface MongoCardDao extends PagingAndSortingRepository<MongoCard, Serializable> {
    public Collection<MongoCard> findByNameLike(String name);

    @Query("{'expansion.abbreviation':?0, name:?1}, {'image.image': 1}")
    public MongoCard getImage(String exp, String name);
    
}