package com.example.userdata;

public class Person {

    private String mName, mSurname, mLogin, mDate, mEmail;

    public Person(String mName, String mSurname, String mLogin, String mDate, String mEmail) {
        this.mName = mName;
        this.mSurname = mSurname;
        this.mLogin = mLogin;
        this.mDate = mDate;
        this.mEmail = mEmail;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmSurname() {
        return mSurname;
    }

    public void setmSurname(String mSurname) {
        this.mSurname = mSurname;
    }

    public String getmLogin() {
        return mLogin;
    }

    public void setmLogin(String mLogin) {
        this.mLogin = mLogin;
    }

    public String getmDate() {
        return mDate;
    }

    public void setmDate(String mDate) {
        this.mDate = mDate;
    }

    public String getmEmail() {
        return mEmail;
    }

    public void setmEmail(String mEmail) {
        this.mEmail = mEmail;
    }
}
