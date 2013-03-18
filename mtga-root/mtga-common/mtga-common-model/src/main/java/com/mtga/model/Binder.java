package com.mtga.model;

import java.util.List;

import com.mtga.model.mtg.MtgaPlayer;

public interface Binder {

    public void setOwner(MtgaPlayer owner);
    public MtgaPlayer getOwner();
    public void addPage(BinderPage binderPage);
    public List<? extends BinderPage> getPages();
    
}
