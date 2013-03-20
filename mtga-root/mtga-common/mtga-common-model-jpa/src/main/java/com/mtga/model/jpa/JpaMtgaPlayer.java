package com.mtga.model.jpa;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.CascadeType;

import com.mtga.model.AuctionItem;
import com.mtga.model.Binder;
import com.mtga.model.SellableGroup;
import com.mtga.model.mtg.MtgaPlayer;

@Entity
@Table(name="players")
public class JpaMtgaPlayer implements MtgaPlayer {

    @Id
    @GeneratedValue
    private long id;
    
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="userId")
    private User user;
    
    @OneToOne(mappedBy="owner", cascade=CascadeType.ALL)
    private JpaBinder binder;
    
    @Override
    public Binder getBinder() {
        return binder;
    }

    public void setBinder(JpaBinder binder) {
        this.binder = binder;
    }

    @Override
    public void addToCollection(SellableGroup items) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public List<SellableGroup> getCollection() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void addToAuctions(AuctionItem auction) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public List<AuctionItem> getActiveAuctions() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void addToOwnAuctions(AuctionItem auction) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public List<AuctionItem> getOwnAuctions() {
        // TODO Auto-generated method stub
        return null;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
