package com.esther.code.schema.service.proxy.dynamicProxy.cglib;

import net.sf.cglib.beans.BeanGenerator;
import net.sf.cglib.beans.BeanMap;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author esther
 * 2018-04-27 15:09
 * 通过指定一组属性名和属性值的类型，我们可以使用Cglib的BeanGenerator和BeanMap来动态生成Bean。
 */

public class CGLIBBean {
    //Bean实体Object
    public Object object = null;
    //属性map
    public BeanMap beanMap = null;

    public CGLIBBean() {
        super();
    }

    @SuppressWarnings("unchecked")
    public CGLIBBean(Map<String, Class> propertyMap) {
        //用一组属性生成实体Bean
        this.object = generateBean(propertyMap);
        //用实体Bean创建BeanMap，以便可以设置和获取Bean属性的值
        this.beanMap = BeanMap.create(this.object);
    }

    /**
     * 给bean中的属性赋值
     *
     * @param property 属性名
     * @param value 值
     */
    public void setValue(String property, Object value) {
        beanMap.put(property, value);
    }

    /**
     * 获取bean中属性的值
     *
     * @param property 属性名
     * @return 值
     */
    public Object getValue(String property) {
        return beanMap.get(property);
    }

    /**
     * 得到该实体bean对象
     *
     * @return
     */
    public Object getObject() {
        return this.object;
    }

    @SuppressWarnings("unchecked")
    private Object generateBean(Map<String, Class> propertyMap) {
        //根据一组属性名和属性值的类型，动态创建Bean对象
        BeanGenerator generator = new BeanGenerator();
        Set keySet = propertyMap.keySet();
        for (Iterator i = keySet.iterator(); i.hasNext();) {
            String key = (String) i.next();
            generator.addProperty(key, (Class) propertyMap.get(key));
        }
        return generator.create();  //创建Bean
    }
}
