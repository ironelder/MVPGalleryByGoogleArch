package com.ironelder.mvpgallerybygoogle.component;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;

import com.ironelder.mvpgallerybygoogle.R;
import com.ironelder.mvpgallerybygoogle.data.ImageData;
import com.ironelder.mvpgallerybygoogle.util.ImageLoader;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ImageViewHolder extends RecyclerView.ViewHolder {

    private Context context;

    private ImageViewAdapterContract.ItemOnClickListener mOnItemClickListener;

    @BindView(R.id.image_view)
    ImageView imageView;

    public ImageViewHolder(Context context, ViewGroup parent, ImageViewAdapterContract.ItemOnClickListener onItemClickListener) {
        super(LayoutInflater.from(context).inflate(R.layout.data_image, parent, false));

        this.context = context;
        this.mOnItemClickListener = onItemClickListener;
        ButterKnife.bind(this, itemView);
    }

    public void onBind(ImageData item, final int position) {
        itemView.setOnClickListener(view -> {
            if (mOnItemClickListener != null) {
                mOnItemClickListener.onItemClick(position);
            }
        });
        new ImageLoader(context, imageView).execute(item.getImageResource());
    }
}
