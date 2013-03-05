package com.mtga.model;

import org.joda.time.DateTime;

public interface AuctionItem {

    public void setItems(SellableGroup items);
    public SellableGroup getItems();
    public void addBid(double bid);
    public double getCurrentBid();
    public void setBuyout(double buyout);
    public double getBuyout();
    public void setSeller(MtgaEntity seller);
    public MtgaEntity getSeller();
    public void setEndDate(DateTime endDate);
    public DateTime getEndDate();
    
}