package com.mtga.model.jpa;

import javax.persistence.Embeddable;

import org.springframework.core.style.ToStringCreator;

import com.mtga.model.mtg.CastingCost;

@Embeddable
public class JpaCastingCost implements CastingCost {

    private String string;
    
    @Override
    public String toString() {
        return new ToStringCreator(this)
            .append("cc", string)
            .toString();
    }
    
    @Override
    public String getString() {
        return string;
    }

    @Override
    public void setString(String string) {
        this.string = string;
    }

}
