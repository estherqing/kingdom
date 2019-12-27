package com.vivo.jovi.scene.common.activity.action;


import java.util.HashMap;
import java.util.Map;

/**
 * @author Tian Guangxin
 * @date 2018/11/21
 * @since 1.0
 */
public class ActionTypeRepository {
    /**
     * type一旦确定后就不可更改，因为type会保存在数据库中
     */
    public static final Map<Class<? extends Action>,String> TYPE_MAP  = new HashMap<>();

    public static String getType(Class<? extends Action> clazz){
        return TYPE_MAP.get(clazz);
    }

    public static void register(Class<? extends Action> clazz,String type){
        TYPE_MAP.put(clazz,type);
    }



}
