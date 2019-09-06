package com.ironelder.mvpgallerybygoogle.ImageViewList;

import android.content.Context;

import com.ironelder.mvpgallerybygoogle.component.ImageViewAdapterContract;
import com.ironelder.mvpgallerybygoogle.data.ImageData;
import com.ironelder.mvpgallerybygoogle.data.source.ImageDataSourceHelper;


public class ImageViewListPresenter implements ImageViewListContract.Presenter, ImageViewAdapterContract.ItemOnClickListener {

    private ImageViewListContract.View mImageViewListContractView;

    private ImageViewAdapterContract.Model mAdapterModel;
    private ImageViewAdapterContract.View mAdapterView;

    private ImageDataSourceHelper mImageDataSource;

    @Override
    public void attachView(ImageViewListContract.View view) {
        this.mImageViewListContractView = view;
    }

    @Override
    public void detachView() {
        mImageViewListContractView = null;
    }

    @Override
    public void setSampleImageData(ImageDataSourceHelper imageDataSource) {
        this.mImageDataSource = imageDataSource;
    }

    @Override
    public void loadItems(Context context, final boolean isClear) {
        mImageDataSource.getImages(context, 10, list -> {
            if (list != null) {
                if (isClear) {
                    mAdapterModel.clearItem();
                }
                mAdapterModel.addItems(list);
                mAdapterView.notifyAdapter();
            }
        });
    }

    @Override
    public void setImageAdapterModel(ImageViewAdapterContract.Model adapterModel) {
        this.mAdapterModel = adapterModel;
    }

    @Override
    public void setImageAdapterView(ImageViewAdapterContract.View adapterView) {
        this.mAdapterView = adapterView;
        this.mAdapterView.setOnClickListener(this);
    }

    @Override
    public void onItemClick(int position) {
        ImageData imageItem = mAdapterModel.getItem(position);
        mImageViewListContractView.showImageTitle(imageItem.getTitle());
    }
}
