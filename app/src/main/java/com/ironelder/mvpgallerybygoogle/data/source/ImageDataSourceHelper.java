package com.ironelder.mvpgallerybygoogle.data.source;

import android.content.Context;

import com.ironelder.mvpgallerybygoogle.data.local.LocalImageDataSource;


public class ImageDataSourceHelper implements IImageDataSource {

    private static ImageDataSourceHelper mImageDataSourceHelper;

    public static ImageDataSourceHelper getInstance() {
        if (mImageDataSourceHelper == null) {
            mImageDataSourceHelper = new ImageDataSourceHelper();
        }
        return mImageDataSourceHelper;
    }

    private LocalImageDataSource mLocalImageDataSource;

    private ImageDataSourceHelper() {
        mLocalImageDataSource = new LocalImageDataSource();
    }

    @Override
    public void getImages(Context context, int size, final LoadImageComplete loadImageComplete) {
        mLocalImageDataSource.getImages(context, size, list -> {
            if (loadImageComplete != null) {
                loadImageComplete.onLoadImageDataComplete(list);
            }
        });
    }
}
