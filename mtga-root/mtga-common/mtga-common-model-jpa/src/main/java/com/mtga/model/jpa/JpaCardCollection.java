package com.mtga.model.jpa;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.mtga.model.CardCollection;
import com.mtga.model.mtg.Card;

public class JpaCardCollection implements CardCollection {

    private List<Card> cards;

    public JpaCardCollection(Collection<JpaCard> cards) {
        this.cards = new ArrayList<Card>(cards);
    }

    @Override
    public List<Card> getCards() {
        if(null == cards) {
            cards = new ArrayList<Card>();
        }
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

}
