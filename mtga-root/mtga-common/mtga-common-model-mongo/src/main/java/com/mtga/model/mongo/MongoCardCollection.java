package com.mtga.model.mongo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MongoCardCollection {

    private List<MongoCard> cards;

    public MongoCardCollection(){}
    
    public MongoCardCollection(Collection<MongoCard> cards) {
        this.cards = new ArrayList<MongoCard>(cards);
    }

    public List<MongoCard> getCards() {
        if(null == cards) {
            cards = new ArrayList<MongoCard>();
        }
        return cards;
    }

    public void setCards(List<MongoCard> cards) {
        this.cards = cards;
    }
    
}
