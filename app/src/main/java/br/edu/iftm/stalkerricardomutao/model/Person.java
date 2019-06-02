package br.edu.iftm.stalkerricardomutao.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Person implements Parcelable {
    private String firstName;
    private String lastName;
    private String age;
    private  String job;
    private String birth;
    private  String phone;
    private String description;



    public Person(String firstName, String lastName, String age, String job, String birth, String phone, String description) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.job = job;
        this.birth = birth;
        this.phone = phone;
        this.description = description;

    }

    protected Person(Parcel in) {
        firstName = in.readString();
        lastName = in.readString();
        age = in.readString();
        job = in.readString();
        birth = in.readString();
        phone = in.readString();
        description = in.readString();

    }

    public static final Creator<Person> CREATOR = new Creator<Person>() {
        @Override
        public Person createFromParcel(Parcel in) {
            return new Person(in);
        }

        @Override
        public Person[] newArray(int size) {
            return new Person[size];
        }
    };

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAge() {
        return age;
    }

    public String getJob() {
        return job;
    }

    public String getBirth() {
        return birth;
    }

    public String getPhone() {
        return phone;
    }

    public String getDescription() {
        return description;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(firstName);
        dest.writeString(lastName);
        dest.writeString(age);
        dest.writeString(job);
        dest.writeString(birth);
        dest.writeString(phone);
        dest.writeString(description);

    }
}
