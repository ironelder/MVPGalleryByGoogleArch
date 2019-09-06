package com.ironelder.mvpgallerybygoogle.data;

public class ImageData {
    private int mImageResource;
    private String mTitle;

    public ImageData(int imageResource, String title) {
        this.mImageResource = imageResource;
        this.mTitle = title;
    }

    public int getImageResource() {
        return mImageResource;
    }

    public String getTitle() {
        return mTitle;
    }
}
