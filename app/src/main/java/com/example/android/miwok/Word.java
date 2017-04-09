package com.example.android.miwok;

/**
 * Created by Dell on 2/5/2017.
 */


public class Word {
    //default translation of word
    private String mDefaultTranslation;
    //miwok translation of word
    private String mMiwokTranslation;
    //image resoutrce id for the word
    private int mImageResourceId = NO_IMAGE_PROVIDED;
    //constant value that represents no image was provided for this word
    private static final int NO_IMAGE_PROVIDED = -1;
    //Audio resource ID for the word
    private int mAudioResourceId;

    public Word(String defaultTranslation, String miwokTranslation, int audioResourceId) {
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mAudioResourceId = audioResourceId;
    }

    public Word(String defaultTranslation, String miwokTranslation,int imageResourceId, int audioResourceId) {
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mImageResourceId = imageResourceId;
        mAudioResourceId = audioResourceId;
    }

    //get default translation of word
    public String getDefaultTranslation() {
                return mDefaultTranslation;
    }

    //get miwok translation of word
    public String getMiwokTranslation() {
                return mMiwokTranslation;
    }

    public int getmImageResourceId() {
        return mImageResourceId;
    }

    //return whether or not there is an image for this word
    public boolean hasImage(){
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }

    //return the audio resource id of the word
    public int getmAudioResourceId() {
        return mAudioResourceId;
    }

    @Override
    public String toString() {
        return "Word{" +
                "mDefaultTranslation='" + mDefaultTranslation + '\'' +
                ", mMiwokTranslation='" + mMiwokTranslation + '\'' +
                ", mImageResourceId=" + mImageResourceId +
                ", mAudioResourceId=" + mAudioResourceId +
                '}';
    }
}
