package com.barryirvine.shazam.model.local;

import android.os.Parcel;
import android.os.Parcelable;

public class ChartEntry implements Parcelable {

    public static final Parcelable.Creator<ChartEntry> CREATOR = new Parcelable.Creator<ChartEntry>() {
        @Override
        public ChartEntry createFromParcel(final Parcel source) {
            return new ChartEntry(source);
        }

        @Override
        public ChartEntry[] newArray(final int size) {
            return new ChartEntry[size];
        }
    };
    private String mTitle;
    private String mArtist;
    private String mImageUrl;

    public ChartEntry(final Builder builder) {
        mTitle = builder.mTitle;
        mArtist = builder.mArtist;
        mImageUrl = builder.mImageUrl;
    }

    protected ChartEntry(final Parcel in) {
        mTitle = in.readString();
        mArtist = in.readString();
        mImageUrl = in.readString();
    }

    public String getTitle() {
        return mTitle;
    }

    public String getArtist() {
        return mArtist;
    }

    public String getImageUrl() {
        return mImageUrl;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(final Parcel dest, final int flags) {
        dest.writeString(mTitle);
        dest.writeString(mArtist);
        dest.writeString(mImageUrl);
    }

    public static class Builder {

        private String mTitle;
        private String mArtist;
        private String mImageUrl;

        public Builder title(final String title) {
            mTitle = title;
            return this;
        }

        public Builder artist(final String artist) {
            mArtist = artist;
            return this;
        }

        public Builder imageUrl(final String imageUrl) {
            mImageUrl = imageUrl;
            return this;
        }

        public ChartEntry build() {
            return new ChartEntry(this);
        }
    }
}
