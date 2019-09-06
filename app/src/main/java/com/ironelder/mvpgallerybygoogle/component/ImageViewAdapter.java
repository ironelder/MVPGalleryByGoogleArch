package com.ironelder.mvpgallerybygoogle.component;

import android.content.Context;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.ironelder.mvpgallerybygoogle.data.ImageData;

import java.util.ArrayList;

public class ImageViewAdapter extends RecyclerView.Adapter<ImageViewHolder> implements ImageViewAdapterContract.Model, ImageViewAdapterContract.View {

    private Context context;
    private ImageViewAdapterContract.ItemOnClickListener mItemOnClickListener;

    private ArrayList<ImageData> mImageItems;

    public ImageViewAdapter(Context context) {
        this.context = context;
    }

    @Override
    public void addItems(ArrayList<ImageData> imageItems) {
        this.mImageItems = imageItems;
    }

    @Override
    public void clearItem() {
        if (mImageItems != null) {
            mImageItems.clear();
        }
    }

    @Override
    public void notifyAdapter() {
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return mImageItems != null ? mImageItems.size() : 0;
    }

    @Override
    public ImageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ImageViewHolder(context, parent, mItemOnClickListener);
    }

    @Override
    public void setOnClickListener(ImageViewAdapterContract.ItemOnClickListener clickListener) {
        this.mItemOnClickListener = clickListener;
    }

    @Override
    public ImageData getItem(int position) {
        return mImageItems.get(position);
    }

    @Override
    public void onBindViewHolder(final ImageViewHolder holder, int position) {
        if (holder == null) return;
        holder.onBind(getItem(position), position);
    }
}
