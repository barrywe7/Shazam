package com.barryirvine.shazam.model.local;

public class ChartEntry {

    private String mTitle;
    private String mArtist;
    private String mImageUrl;

    public ChartEntry(final Builder builder) {
        mTitle = builder.mTitle;
        mArtist = builder.mArtist;
        mImageUrl = builder.mImageUrl;
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
