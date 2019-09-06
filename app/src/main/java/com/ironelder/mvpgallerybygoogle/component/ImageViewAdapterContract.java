package com.ironelder.mvpgallerybygoogle.component;

import com.ironelder.mvpgallerybygoogle.data.ImageData;

import java.util.ArrayList;

public interface ImageViewAdapterContract {
    interface View {
        void setOnClickListener(ItemOnClickListener clickListener);
        void notifyAdapter();
    }

    interface Model {
        void addItems(ArrayList<ImageData> imageItems);
        void clearItem();
        ImageData getItem(int position);
    }

    interface ItemOnClickListener {
        void onItemClick(int position);
    }
}
