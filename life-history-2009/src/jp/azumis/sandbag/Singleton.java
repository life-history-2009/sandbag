package jp.azumis.sandbag;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public final class Singleton {
    private static final Singleton instance = new Singleton();

    private ArrayList<String> data;
    private Date updateDate;
    static public final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy.MM.dd_HH-mm-ss.SSS");

    private Singleton() {
        data = new ArrayList<String>();
        this.updateDate = new Date();
    }

    public static Singleton getInstance() {
        return instance;
    }

    public void addData(String strData) {
        this.data.add(strData);
        this.updateDate = new Date();
    }

    public ArrayList<String> getData() {
        ArrayList<String> retData = new ArrayList<String>();
        for (String eachData : this.data) {
            retData.add(eachData);
        }
        return retData;
    }

    public void dispData() {
        String borderLineString = "==================";
        System.out.println(borderLineString);
        for (int index = 0; index < this.data.size(); index++) {
            System.out.println(index + " th data:" + this.data.get(index));
        }
        System.out.println("updateDate:" + DATE_FORMAT.format(this.updateDate));
        System.out.println(borderLineString);
    }
}
