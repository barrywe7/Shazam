package com.barryirvine.shazam.ui;

import android.databinding.BindingAdapter;
import android.support.annotation.NonNull;
import android.widget.ImageView;

import com.barryirvine.shazam.R;
import com.squareup.picasso.Picasso;

public class DataBindingUtils {

    @BindingAdapter({"imageUrl"})
    public static void loadImage(@NonNull final ImageView view, @NonNull final String imageUrl) {
        Picasso.with(view.getContext())
                .load(imageUrl)
                .resizeDimen(R.dimen.thumbnail_size, R.dimen.thumbnail_size)
                .placeholder(R.drawable.ic_image_grey_24dp)
                .centerCrop()
                .into(view);
    }
}
