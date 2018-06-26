package com.example.baserecyclerview.demo;



/**
 * Created by Administrator on 2018/5/10 0010.
 */

public class MyApp  {
    private String name;
    private int resId;
    private String purpose;

    public MyApp(String name, int resId, String purpose) {
        this.name = name;
        this.resId = resId;
        this.purpose=purpose;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }
}
