package com.esther.code.util;

import org.apache.commons.beanutils.DynaBean;
import org.apache.commons.beanutils.DynaProperty;
import org.apache.commons.beanutils.PropertyUtils;

import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by Administrator on 2016/1/13.
 */
public class BeanPropertyUtils extends PropertyUtils {

    public static void copyProperties(Object dest, Object orig) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        if (dest == null) {
            throw new IllegalArgumentException
                    ("No destination bean specified");
        }
        if (orig == null) {
            return;
        }

        if (orig instanceof DynaBean) {
            DynaProperty origDescriptors[] =
                    ((DynaBean) orig).getDynaClass().getDynaProperties();
            for (DynaProperty origDescriptor : origDescriptors) {
                String name = origDescriptor.getName();
                if (dest instanceof DynaBean) {
                    if (isWriteable(dest, name)) {
                        Object value = ((DynaBean) orig).get(name);
                        ((DynaBean) dest).set(name, value);
                    }
                } else /* if (dest is a standard JavaBean) */ {
                    if (isWriteable(dest, name)) {
                        Object value = ((DynaBean) orig).get(name);
                        setSimpleProperty(dest, name, value);
                    }
                }
            }
        } else if (orig instanceof Map) {
            Iterator names = ((Map) orig).keySet().iterator();
            while (names.hasNext()) {
                String name = (String) names.next();
                if (dest instanceof DynaBean) {
                    if (isWriteable(dest, name)) {
                        Object value = ((Map) orig).get(name);
                        ((DynaBean) dest).set(name, value);
                    }
                } else /* if (dest is a standard JavaBean) */ {
                    if (isWriteable(dest, name)) {
                        Object value = ((Map) orig).get(name);
                        setSimpleProperty(dest, name, value);
                    }
                }
            }
        } else /* if (orig is a standard JavaBean) */ {
            PropertyDescriptor origDescriptors[] =
                    getPropertyDescriptors(orig);
            for (int i = 0; i < origDescriptors.length; i++) {
                String name = origDescriptors[i].getName();
                if (isReadable(orig, name)) {
                    if (dest instanceof DynaBean) {
                        if (isWriteable(dest, name)) {
                            Object value = getSimpleProperty(orig, name);
                            if (value != null) {
                                ((DynaBean) dest).set(name, value);
                            }
                        }
                    } else /* if (dest is a standard JavaBean) */ {
                        if (isWriteable(dest, name)) {
                            Object value = getSimpleProperty(orig, name);
                            if (value != null) {
                                setSimpleProperty(dest, name, value);
                            }
                        }
                    }
                }
            }
        }
    }
}

