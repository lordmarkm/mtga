package com.mtga.model;

public interface Sellable extends MtgaEntity {

    enum SellableType {
        CARD,
        BOOSTER,
        BOX
    }
    
}
