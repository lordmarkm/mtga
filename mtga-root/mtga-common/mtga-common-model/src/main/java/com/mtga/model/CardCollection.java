package com.mtga.model;

import java.util.List;

import com.mtga.model.mtg.Card;

public interface CardCollection {

    void setCards(List<? extends Card> cards);
    List<? extends Card> getCards();

}
