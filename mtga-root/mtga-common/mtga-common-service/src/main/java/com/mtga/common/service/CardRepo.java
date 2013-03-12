package com.mtga.common.service;

import java.util.Collection;

import com.mtga.model.mtg.Card;

public interface CardRepo {
    
    //C
    public Card create(String name);
    
    //R
    public Collection<Card> findAll();
    public Iterable<Card> findByNameLike(String name);
    public byte[] getImage(String exp, String name);

    //U
    public Card update(Card card);
    
    //D
    public void delete(Card card);
    
}
