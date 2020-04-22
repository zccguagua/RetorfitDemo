package com.android.retorfitdemo.http.response;

import android.util.Log;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;


/**
 * 描述: 返回Response中data给上层
 * 时间: 2018/04/04
 */

public class PayLoad<T> implements Function<BaseResponse<T>, T> {
    private static final String TAG = PayLoad.class.getSimpleName();

    @Override
    public T apply(@NonNull BaseResponse<T> tBaseResponse) throws Exception {

        if (!tBaseResponse.isSuccess()) {
            // TODO: 2018/4/4
        } else {
            throw new Fault(tBaseResponse.status, tBaseResponse.msg);//获取数据失败时，包装一个Fault 抛给上层处理错误

        }
        Log.i(TAG, "call: " + tBaseResponse.toString());
        return tBaseResponse.body;

    }
}
