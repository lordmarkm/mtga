package com.mtga.model;

import java.util.List;

import com.mtga.model.mtg.Card;

public interface CardCollection {

    void setPage(BinderPage page);
    BinderPage getPage();
    void setCards(List<? extends Card> cards);
    List<? extends Card> getCards();

}
