package com.mtga.infra.mongo;

import java.io.Serializable;

import org.springframework.context.annotation.Profile;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.mtga.model.mtg.Card;
import com.mtga.common.utils.Profiles;

//@Profile(Profiles.MONGO)
public interface MongoCardRepo extends PagingAndSortingRepository<Card, Serializable> {

}