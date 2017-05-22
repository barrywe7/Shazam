package com.barryirvine.shazam.ui;

import android.databinding.BindingAdapter;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.barryirvine.shazam.R;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

public class DataBindingUtils {

    @BindingAdapter({"imageUrl", "picasso"})
    public static void loadImage(@NonNull final ImageView view, @NonNull final String imageUrl, @NonNull final Picasso picasso) {
        picasso.load(imageUrl)
                .resizeDimen(R.dimen.thumbnail_size, R.dimen.thumbnail_size)
                .placeholder(R.drawable.ic_image_grey_24dp)
                .centerCrop()
                .into(view);
    }

    @BindingAdapter({"imageUrl", "picasso", "callback"})
    public static void loadImage(@NonNull final ImageView view, @Nullable final String imageUrl, @NonNull final Picasso picasso, @Nullable Callback callback) {
        if (imageUrl == null) {
            picasso.load(R.drawable.ic_image_grey_24dp)
                    .placeholder(R.drawable.ic_image_grey_24dp)
                    .into(view, callback);
        } else {
            picasso.load(imageUrl)
                    .noFade()
                    .into(view, callback);
        }
    }
}
