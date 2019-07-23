package com.miqt.wand;


import com.miqt.wand.anno.ParentalEntrustmentLevel;
import com.miqt.wand.utils.L;

import java.util.Map;

public class ObjectProvider implements Provider {

    @Override
    public Object make(Object object, String classname, ParentalEntrustmentLevel level) {
        L.i("ObjectProvider.make .......  object: " + object + "-----classname-----" + classname + "----level---" + level);
        Map<String, Object[]> map = (Map<String, Object[]>) object;
        if (map == null || map.get(classname) == null) {
            L.i("ObjectProvider.make .......  1111...... ");
            return ObjectFactory.make(classname, level);
        }
        L.i("ObjectProvider.make .......  map: " + map.toString());
        return ObjectFactory.make(classname, level, map.get(classname));
    }
}
