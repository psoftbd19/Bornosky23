package com.bornosky.sample;

import com.bornosky.model.StudentInfo;

import java.util.ArrayList;
import java.util.List;

public class SampleDataProvider {

    public static List<StudentInfo> dataItemList;

    static {
        dataItemList = new ArrayList<>();

        addItem(new StudentInfo("CEO", "1", "01818306782"));
        addItem(new StudentInfo("Manager", "2", "01778299530"));
        addItem(new StudentInfo("Ahamid", "3", "01971308099"));
        addItem(new StudentInfo("Nahid", "4", "01914467257"));
        addItem(new StudentInfo("P Soft", "5", "01997647130"));
      /*  addItem(new StudentInfo("Anisur Islam", "3", "0817712732712"));
        addItem(new StudentInfo("Nayon Islam", "4", "0917712732712"));
        addItem(new StudentInfo("Nahid Islam", "5", "0317712732712"));
        addItem(new StudentInfo("Shogir Islam", "6", "0517712732712"));
        addItem(new StudentInfo("Mustafiz Islam", "7", "0217712732712"));
        addItem(new StudentInfo("Moin Islam", "8", "0117712732712"));

        addItem(new StudentInfo("Azhar Islam", "9", "0717712732712"));
        addItem(new StudentInfo("Anwar Islam", "10", "0417712732712"));
        addItem(new StudentInfo("Anis Islam", "11", "0817712732712"));
        addItem(new StudentInfo("Nay Islam", "12", "0917712732712"));
        addItem(new StudentInfo("Nahi Islam", "13", "0317712732712"));
        addItem(new StudentInfo("Shogi Islam", "14", "0517712732712"));
        addItem(new StudentInfo("Musta Islam", "15", "0217712732712"));
        addItem(new StudentInfo("Moi Islam", "16", "0117712732712"));*/

    }

    private static void addItem(StudentInfo dataItem) {
        dataItemList.add(dataItem);
    }
}