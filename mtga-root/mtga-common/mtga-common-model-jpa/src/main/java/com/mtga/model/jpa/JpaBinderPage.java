package com.mtga.model.jpa;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.mtga.model.Binder;
import com.mtga.model.BinderPage;
import com.mtga.model.CardCollection;

public class JpaBinderPage implements BinderPage {

    @Id
    @GeneratedValue
    private long id;
    
    @ManyToOne
    @JoinColumn(name="binderId")
    private JpaBinder binder;

    @OneToMany(mappedBy="page", fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    private List<JpaCardCollection> collections;
    
    @Override
    public void addCards(int index, CardCollection cards) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public CardCollection getCards(int index) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<CardCollection> getCards() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Binder getBinder() {
        return (Binder) binder;
    }

    @Override
    public void setBinder(Binder binder) {
        this.binder = (JpaBinder) binder;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

}
