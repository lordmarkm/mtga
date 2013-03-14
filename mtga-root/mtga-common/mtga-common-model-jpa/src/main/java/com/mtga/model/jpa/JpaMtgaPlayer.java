package com.mtga.model.jpa;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.mtga.model.AuctionItem;
import com.mtga.model.Binder;
import com.mtga.model.SellableGroup;
import com.mtga.model.mtg.MtgaPlayer;

@Entity
@Table(name="players")
public class JpaMtgaPlayer implements MtgaPlayer {

    @OneToOne(mappedBy="owner")
    private JpaBinder binder;
    
    @Override
    public Binder getBinder() {
        return (Binder) binder;
    }

    @Override
    public void setBinder(Binder binder) {
        this.binder = (JpaBinder) binder;
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

}
