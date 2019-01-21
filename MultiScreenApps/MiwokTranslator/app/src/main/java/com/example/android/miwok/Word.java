package com.example.android.miwok;

public class Word {

    //We only need string values for this object

    private String mDefaultText;
    private String mMiwokText;

    //Constructor
    public Word(String mdefaultText, String mmiwokText) {
        this.mDefaultText = mdefaultText;
        this.mMiwokText = mmiwokText;
    }

    /**
     * gets the miwok translation
     * @return
     */
    public String getMiwokTranslation(){
        return mMiwokText;
    }

    /**
     * gets the default translation
     * @return
     */
    public String getDefaultTranslation(){
        return mDefaultText;
    }


}
