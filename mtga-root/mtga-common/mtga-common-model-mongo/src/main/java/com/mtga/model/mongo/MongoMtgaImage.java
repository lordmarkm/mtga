package com.mtga.model.mongo;

import com.mtga.model.MtgaImage;

public class MongoMtgaImage implements MtgaImage {

    private byte[] image;
    
    @Override
    public byte[] getImage() {
        return image;
    }

    @Override
    public void setImage(byte[] image) {
        this.image = image;
    }

}
