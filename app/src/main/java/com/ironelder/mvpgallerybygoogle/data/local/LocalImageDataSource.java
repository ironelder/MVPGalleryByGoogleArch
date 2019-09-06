package com.ironelder.mvpgallerybygoogle.data.local;

import android.content.Context;

import com.ironelder.mvpgallerybygoogle.data.ImageData;
import com.ironelder.mvpgallerybygoogle.data.source.IImageDataSource;

import java.util.ArrayList;

public class LocalImageDataSource implements IImageDataSource {

    @Override
    public void getImages(Context context, int size, LoadImageComplete loadImageComplete) {
        ArrayList<ImageData> items = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            final int random = (int) (Math.random() * 13);
            final String name = String.format("ironelder%02d", random);
            final int resource = context.getResources().getIdentifier(name, "drawable", context.getApplicationContext().getPackageName());
            items.add(new ImageData(resource, name));
        }

        if (loadImageComplete != null) {
            loadImageComplete.onLoadImageDataComplete(items);
        }
    }
}
