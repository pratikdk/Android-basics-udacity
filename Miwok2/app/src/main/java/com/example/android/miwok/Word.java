package com.example.android.miwok;

/**
 * Created by Pratik on 11/17/2017.
 */

public class Word {
    private String mMiWokTranslation;
    private String mDefaultTranslation;
    private int mImageResouceId = NO_IMAGE_PROVIDED;
    private int mAudioResourceID;

    private static final int NO_IMAGE_PROVIDED = -1;

    public Word(String miWokTranslation, String defaultTranslation, int audioResourceID) {
        this.mMiWokTranslation = miWokTranslation;
        this.mDefaultTranslation = defaultTranslation;
        this.mAudioResourceID = audioResourceID;
    }

    public Word(String miWokTranslation, String defaultTranslation, int imageResouceId, int audioResourceID) {
        this(miWokTranslation, defaultTranslation, audioResourceID);
        this.mImageResouceId = imageResouceId;
    }

    public String getMiWokTranslation() {
        return mMiWokTranslation;
    }

    public String getDefaultTranslation() {
        return mDefaultTranslation;
    }

    public int getmAudioResourceID() {
        return mAudioResourceID;
    }

    public int getImageResouceId() {
        return mImageResouceId;
    }

    public boolean hasImage() {
        return mImageResouceId != NO_IMAGE_PROVIDED;
    }

    @Override
    public String toString() {
        return "Word{" +
                "mMiWokTranslation='" + mMiWokTranslation + '\'' +
                ", mDefaultTranslation='" + mDefaultTranslation + '\'' +
                ", mImageResouceId=" + mImageResouceId +
                ", mAudioResourceID=" + mAudioResourceID +
                '}';
    }
}
