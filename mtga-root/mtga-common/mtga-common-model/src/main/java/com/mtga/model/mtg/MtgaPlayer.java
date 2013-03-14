package com.mtga.model.mtg;

import java.util.List;

import com.mtga.model.AuctionItem;
import com.mtga.model.Binder;
import com.mtga.model.MtgaEntity;
import com.mtga.model.SellableGroup;

public interface MtgaPlayer extends MtgaEntity {

    public Binder getBinder();
    public void setBinder(Binder binder);
    
    /**
     * Involved only with non-card items I guess
     * @param items
     */
    public void addToCollection(SellableGroup items);
    public List<SellableGroup> getCollection();

    public void addToAuctions(AuctionItem auction);
    public List<AuctionItem> getActiveAuctions();
    
    public void addToOwnAuctions(AuctionItem auction);
    public List<AuctionItem> getOwnAuctions();
    
}
