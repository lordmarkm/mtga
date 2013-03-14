package com.mtga.common.service;

import org.springframework.data.domain.Page;

import com.mtga.model.mtg.Card;

public interface CardRepo {
    
    //C
    public Card create(String name);
    
    //R
    public Page<? extends Card> findAll(int page, int count);
    public Page<? extends Card> findByNameLike(String name, int page, int count);
    public byte[] getImage(String exp, String name);

    //U
    public Card update(Card card);
    
    //D
    public void delete(Card card);

}
