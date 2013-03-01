package com.mtga.infra.mongo;

import java.io.Serializable;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.mtga.model.mongo.MongoExpansion;

public interface MongoExpansionDao extends PagingAndSortingRepository<MongoExpansion, Serializable> {

}
