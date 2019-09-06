package com.ironelder.mvpgallerybygoogle.ImageViewList;

import android.content.Context;

import com.ironelder.mvpgallerybygoogle.component.ImageViewAdapterContract;
import com.ironelder.mvpgallerybygoogle.data.source.ImageDataSourceHelper;

public interface ImageViewListContract {

    interface View {
        void showImageTitle(String title);
    }

    interface Presenter {
        void attachView(View view);
        void setImageAdapterModel(ImageViewAdapterContract.Model adapterModel);
        void setImageAdapterView(ImageViewAdapterContract.View adapterView);
        void detachView();
        void setSampleImageData(ImageDataSourceHelper imageDataSourceHelper);
        void loadItems(Context context, boolean isClear);
    }
}
