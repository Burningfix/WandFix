package com.miqt.demo.presenter;

/**
 * Created by miqt on 2019/2/18.
 */

public class AppPresenterImpl {
    String name;

    public AppPresenterImpl(CharSequence name) {
        this.name = (String) name + "CharSequence";
    }

    public AppPresenterImpl(String name, int a) {
        this.name = name + "String";
    }

    public AppPresenterImpl(Comparable name) {
        this.name = (String) name + "Comparable";
    }

    public AppPresenterImpl() {
    }

    public String getStr() {
        return name.toLowerCase();
    }
}
