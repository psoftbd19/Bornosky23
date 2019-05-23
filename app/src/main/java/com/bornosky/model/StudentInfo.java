package com.bornosky.model;

import android.os.Parcel;
import android.os.Parcelable;

public class StudentInfo implements Parcelable {

    private int position;
    private boolean isChecked;
    private String name;
    private String roll;
    private String phone;

    public StudentInfo(String name, String roll, String phone) {
        this.name = name;
        this.roll = roll;
        this.phone = phone;
    }

    public StudentInfo() {
    }

    protected StudentInfo(Parcel in) {
        position = in.readInt();
        isChecked = in.readByte() != 0;
        name = in.readString();
        roll = in.readString();
        phone = in.readString();
    }

    public static final Creator<StudentInfo> CREATOR = new Creator<StudentInfo>() {
        @Override
        public StudentInfo createFromParcel(Parcel in) {
            return new StudentInfo(in);
        }

        @Override
        public StudentInfo[] newArray(int size) {
            return new StudentInfo[size];
        }
    };

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public boolean getChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoll() {
        return roll;
    }

    public void setRoll(String roll) {
        this.roll = roll;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(position);
        dest.writeByte((byte) (isChecked ? 1 : 0));
        dest.writeString(name);
        dest.writeString(roll);
        dest.writeString(phone);
    }
}
