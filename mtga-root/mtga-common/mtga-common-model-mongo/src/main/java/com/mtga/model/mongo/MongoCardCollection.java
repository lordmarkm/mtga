//package com.mtga.model.mongo;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import com.mtga.model.CardCollection;
//import com.mtga.model.mtg.Card;
//
//public class MongoCardCollection implements CardCollection {
//
//    private List<Card> cards;
//
//    public MongoCardCollection(){}
//
//    public MongoCardCollection(Iterable<MongoCard> cards) {
//        this.cards = new ArrayList<Card>();
//        for(MongoCard mc : cards) {
//            this.cards.add(mc);
//        }
//    }
//
//    @Override
//    public List<Card> getCards() {
//        if(null == cards) {
//            cards = new ArrayList<Card>();
//        }
//        return cards;
//    }
//
//    public void setCards(List<Card> cards) {
//        this.cards = cards;
//    }
//
//}
