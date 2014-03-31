
package com.android.mms.transaction;

import java.lang.reflect.Method;
import java.net.InetAddress;

import android.net.ConnectivityManager;
import android.os.Bundle;
import android.telephony.ServiceState;
import android.text.TextUtils;

public class Utils {

    public static String getSystemProp(String key) {
        return Utils.getSystemProp(key, "");
    }

    public static String getSystemProp(String key, String defaultValue) {
        try {
            Class<?> clazz = Class.forName("android.os.SystemProperties");
            Method method = clazz.getDeclaredMethod("get", String.class);
            String prop = (String) method.invoke(null, key);
            if (TextUtils.isEmpty(prop)) {
                return defaultValue;
            }
            return prop;
        } catch (Exception e) {
        }
        return defaultValue;
    }

    public static boolean mobileDataEnabled(ConnectivityManager cm) {
        boolean result = false;
        try {
            Class<?> clazz = Class.forName(cm.getClass().getName());
            Method method = clazz.getDeclaredMethod("getMobileDataEnabled");
            method.setAccessible(true);
            result = (Boolean) method.invoke(cm);
        } catch (Exception e) {
        }
        return result;
    }

    public static boolean requestRouteToHostAddress(ConnectivityManager cm, int networkType,
            InetAddress addr) {
        boolean result = false;
        try {
            Class<?> clazz = Class.forName(cm.getClass().getName());
            Method method = clazz.getDeclaredMethod("requestRouteToHostAddress", int.class,
                    InetAddress.class);
            method.setAccessible(true);
            result = (Boolean) method.invoke(cm, networkType, addr);
        } catch (Exception e) {
        }
        return result;
    }

    public static ServiceState newFromBundle(Bundle data) {
        ServiceState serviceState = new ServiceState();

        try {
            Class<?> clazz = Class.forName(serviceState.getClass().getName());
            Method method = clazz.getDeclaredMethod("setVoiceRegState", int.class);
            method.setAccessible(true);
            method.invoke(serviceState, data.getInt("voiceRegState"));
        } catch (Exception e) {
        }

        try {
            Class<?> clazz = Class.forName(serviceState.getClass().getName());
            Method method = clazz.getDeclaredMethod("setDataRegState", int.class);
            method.setAccessible(true);
            method.invoke(serviceState, data.getInt("dataRegState"));
        } catch (Exception e) {
        }

        serviceState.setRoaming(data.getBoolean("roaming"));
        serviceState.setOperatorName(data.getString("operator-alpha-long"),
                data.getString("operator-alpha-short"), data.getString("operator-numeric"));
        serviceState.setIsManualSelection(data.getBoolean("manual"));

        try {
            Class<?> clazz = Class.forName(serviceState.getClass().getName());
            Method method = clazz.getDeclaredMethod("setRilVoiceRadioTechnology", int.class);
            method.setAccessible(true);
            method.invoke(serviceState, data.getInt("radioTechnology"));
        } catch (Exception e) {
        }

        try {
            Class<?> clazz = Class.forName(serviceState.getClass().getName());
            Method method = clazz.getDeclaredMethod("setRilDataRadioTechnology", int.class);
            method.setAccessible(true);
            method.invoke(serviceState, data.getInt("dataRadioTechnology"));
        } catch (Exception e) {
        }

        try {
            Class<?> clazz = Class.forName(serviceState.getClass().getName());
            Method method = clazz.getDeclaredMethod("setCssIndicator", boolean.class);
            method.setAccessible(true);
            method.invoke(serviceState, data.getBoolean("cssIndicator"));
        } catch (Exception e) {
        }

        try {
            Class<?> clazz = Class.forName(serviceState.getClass().getName());
            Method method = clazz.getDeclaredMethod("setSystemAndNetworkId", int.class, int.class);
            method.setAccessible(true);
            method.invoke(serviceState, data.getInt("networkId"), data.getInt("systemId"));
        } catch (Exception e) {
        }

        try {
            Class<?> clazz = Class.forName(serviceState.getClass().getName());
            Method method = clazz.getDeclaredMethod("setCdmaRoamingIndicator", int.class);
            method.setAccessible(true);
            method.invoke(serviceState, data.getInt("cdmaRoamingIndicator"));
        } catch (Exception e) {
        }

        try {
            Class<?> clazz = Class.forName(serviceState.getClass().getName());
            Method method = clazz.getDeclaredMethod("setCdmaDefaultRoamingIndicator", int.class);
            method.setAccessible(true);
            method.invoke(serviceState, data.getInt("cdmaDefaultRoamingIndicator"));
        } catch (Exception e) {
        }

        try {
            Class<?> clazz = Class.forName(serviceState.getClass().getName());
            Method method = clazz.getDeclaredMethod("setEmergencyOnly", boolean.class);
            method.setAccessible(true);
            method.invoke(serviceState, data.getBoolean("emergencyOnly"));
        } catch (Exception e) {
        }

        return serviceState;
    }
}
