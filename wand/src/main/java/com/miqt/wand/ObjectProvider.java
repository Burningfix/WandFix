package com.miqt.wand;


import android.util.Log;

import com.miqt.wand.anno.ParentalEntrustmentLevel;

import java.util.Map;

public class ObjectProvider implements Provider {

    @Override
    public Object make(Object object, String classname, ParentalEntrustmentLevel level) {
        Log.i("sanbo", "ObjectProvider.make .......  object: " + object + "-----classname-----" + classname + "----level---" + level);
        Map<String, Object[]> map = (Map<String, Object[]>) object;
        if (map == null || map.get(classname) == null) {
            Log.i("sanbo", "ObjectProvider.make .......  1111...... ");
            return ObjectFactory.make(classname, level);
        }
        Log.i("sanbo", "ObjectProvider.make .......  map: " + map.toString());
        return ObjectFactory.make(classname, level, map.get(classname));
    }
}
