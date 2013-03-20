package com.mtga.model;

import java.util.List;

import com.mtga.model.mtg.Card;

public interface CardCollection {

    BinderPage getPage();
    List<? extends Card> getCards();

}
