package com.mtga.model.mongo;

import com.github.jmkgreen.morphia.annotations.Embedded;
import com.github.jmkgreen.morphia.annotations.Property;
import com.mtga.model.mtg.CastingCost;

@Embedded
public class MongoCastingCost implements CastingCost {

    @Property("str")
    private String string;

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }
    
}
