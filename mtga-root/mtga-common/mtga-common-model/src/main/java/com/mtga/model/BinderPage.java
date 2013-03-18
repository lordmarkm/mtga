package com.mtga.model;

import java.util.List;

public interface BinderPage {

    public void addCards(int index, CardCollection cards);
    
    public CardCollection getCollection(int index);
    public List<? extends CardCollection> getCollections();
    public void setCollections(List<? extends CardCollection> collections);
    
    public Binder getBinder();
    public void setBinder(Binder binder);
    
}
