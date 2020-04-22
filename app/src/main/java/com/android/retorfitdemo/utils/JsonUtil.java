package com.android.retorfitdemo.utils;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.util.ArrayList;
import java.util.List;

/**
 * 时间：2018/4/11
 * 描述：Json 工具类
 */

public class JsonUtil {
    private static Gson gson = new Gson();

    /**
     * 将json字符串转化成实体对象
     * @param json
     * @param clsOfT
     * @return
     */
    public static Object StringToObject(String json, Class clsOfT){
        return gson.fromJson(json,clsOfT);
    }

    /**
     * 将对象转化为json字符串或者把list转化为json
     * @param object
     * @param <T>
     * @return
     */
    public static <T> String objectToString(T object){
        return gson.toJson(object);
    }

    /**
     * 把json 字符串转化成list
     * @param json
     * @param cls
     * @param <T>
     * @return
     */
    public static <T> List<T> stringToList(String json , Class<T> cls  ){
        List<T> list = new ArrayList<T>();
        JsonArray array = new JsonParser().parse(json).getAsJsonArray();
        for(final JsonElement elem : array){
            list.add(gson.fromJson(elem, cls));
        }
        return list ;
    }

}
