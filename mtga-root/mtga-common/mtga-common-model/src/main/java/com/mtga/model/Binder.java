package com.mtga.model;

import java.util.Collection;

public interface Binder {

    public void addPage(BinderPage binderPage);
    public Collection<BinderPage> getPages();
    
}
