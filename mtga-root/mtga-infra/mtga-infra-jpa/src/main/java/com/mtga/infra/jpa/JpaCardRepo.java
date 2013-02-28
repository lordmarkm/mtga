package com.mtga.infra.jpa;

import java.io.Serializable;

import org.springframework.context.annotation.Profile;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.mtga.common.utils.Profiles;
import com.mtga.model.mtg.Card;

@Profile(Profiles.JPA)
public interface JpaCardRepo extends PagingAndSortingRepository<Card, Serializable> {

}
