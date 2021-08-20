package com.mama.union.service;

import org.apache.commons.beanutils.BeanUtilsBean;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.InvocationTargetException;

public abstract class AbstrBaseService<T> {

    private final BeanUtilsBean cloner = new BeanUtilsBean() {
        @Override
        public void copyProperty(Object dest, String name, Object value) throws IllegalAccessException, InvocationTargetException {
            if (value != null)
                super.copyProperty(dest, name, value);
        }
    };

    public <T> void merge(T target, T source) {
        try {
            cloner.copyProperties(target, source);
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    public static Object copy(Object fromBean) {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        XMLEncoder out = new XMLEncoder(bos);
        out.writeObject(fromBean);
        out.close();
        ByteArrayInputStream bis = new
                ByteArrayInputStream(bos.toByteArray());
        XMLDecoder in = new XMLDecoder(bis);
        Object toBean = in.readObject();
        in.close();
        return toBean;
    }

}
