package com.mtga.model;

import java.util.List;

public interface BinderPage {

    public void addCards(int index, CardCollection cards);
    public CardCollection getCards(int index);
    public List<CardCollection> getCards();
    
    public Binder getBinder();
    public void setBinder(Binder binder);
    
}
