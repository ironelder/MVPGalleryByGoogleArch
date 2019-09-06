package com.ironelder.mvpgallerybygoogle.data.source;

import android.content.Context;
import com.ironelder.mvpgallerybygoogle.data.ImageData;
import java.util.ArrayList;

public interface IImageDataSource {
    interface LoadImageComplete {
        void onLoadImageDataComplete(ArrayList<ImageData> list);
    }
    void getImages(Context context, int size, LoadImageComplete loadImageComplete);
}
