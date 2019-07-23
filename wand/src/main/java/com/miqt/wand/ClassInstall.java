package com.miqt.wand;


import android.util.Log;

import com.miqt.wand.utils.L;

import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

/**
 * @author https://github.com/miqt/WandFix
 * @time 2018年12月19日17:35:40
 */
public class ClassInstall {
    private static final ObjectProvider activityProvider = new ObjectProvider();
    private static final Map<String, SoftReference<Inject>> injectMap = new HashMap<>();

    public static void inject(Object o) {
        L.v(new Exception("ClassInstall.inject"));
        inject(o, null, activityProvider);
    }

    public static void inject(Object o, Map<String, Object[]> pramHouse) {
        inject(o, pramHouse, activityProvider);
    }

    private static void inject(Object host, Object object, Provider provider) {
        String className = host.getClass().getName();
        Log.i("sanbo", "ClassInstall.inject   className: " + className);
        Log.i("sanbo", "ClassInstall.inject   host: " + host + "----" + object + "----" + provider);

        try {
            SoftReference<Inject> reference = injectMap.get(className);
            Log.i("sanbo", "ClassInstall.inject   injectMap： " + injectMap.toString());
            Inject inject = null;
            if (reference != null) {
                inject = reference.get();
            } else {
                Log.i("sanbo", "ClassInstall.inject   reference is null ");
            }
            if (inject == null) {
                Class<?> aClass = Wand.get().getContext().getClassLoader().loadClass(className + "$$ObjectInject");
                Log.i("sanbo", "ClassInstall.inject aClass: " + aClass.toString());
                inject = (Inject) aClass.newInstance();
                Log.i("sanbo", "ClassInstall.inject " + className + "<--->" + inject);
                injectMap.put(className, new SoftReference<>(inject));
            } else {
                Log.i("sanbo", "ClassInstall.inject inject is not null ");
            }
            inject.inject(host, object, provider);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
