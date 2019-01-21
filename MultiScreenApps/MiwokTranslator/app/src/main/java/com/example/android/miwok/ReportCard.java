package com.example.android.miwok;

import java.lang.reflect.Array;

//This class it's just a test for the goodle course it does not relate to the miwok app

public class ReportCard {

    //fist we need to create the array Array that is going to contain the grades
    // there is no need of an ArrayList because the number of grades will be fixed
    private Double[] mGrades;
    private String[] mSubjects;
    private String mName;
    private int mLength;

    //Now we need to define the constructor which will have to input parameters,
    // the grades and the subjects

    public ReportCard(String name,int length){
        this.mGrades = new Double[length];
        this.mSubjects = new String[length];
        this.mName = name;
        this.mLength = length;
    }

    public String[] getSubjects() {
            return mSubjects;
    }

    public void setSubjects(String[] subjects) {
            this.mSubjects = subjects;
    }

    public Double[] getGrades() {
        return mGrades;
    }

    public void setGrades(Double[] grades) {
        this.mGrades = grades;
    }

    //it would be easier to convert the array to a list or simply used a list instead
    // of an array, this this just tu just the array as we've done on the course
    public Double getMarkBySubject(String subject)
    {
        double expectedMark = 0.0;
        int index ;

        for (int i=0; i<mLength;i++){
            if(mSubjects[i] == subject)
            {
                index = i;
            }
            else {
                index = 0;
            }

            expectedMark = mGrades[index];
        }

        return expectedMark;
    }

}
