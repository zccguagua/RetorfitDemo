package com.android.retorfitdemo;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.android.retorfitdemo.http.loader.OlderInfoLoder;
import com.android.retorfitdemo.http.model.ContactInfo;
import com.android.retorfitdemo.http.model.OrderBean;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;


public class MainActivity extends AppCompatActivity {
    private Button login, askButton, order;
    private OlderInfoLoder loader;
    private static final String TAG = "MainActivity";
    private List<ContactInfo> mContactInfos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loader = new OlderInfoLoder();

        initView();
    }

    private void initView() {
        login = (Button) findViewById(R.id.login);
        askButton = (Button) findViewById(R.id.ask_button);
        order = (Button) findViewById(R.id.order);

        login.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("CheckResult")
            @Override
            public void onClick(View view) {
                loader.Login(4, "", "").subscribe(
                        new Consumer<Map<String, Object>>() {
                            @Override
                            public void accept(Map<String, Object> map) {
                                map.get("token").toString();
                            }
                        },
                        new Consumer<Throwable>() {
                            @Override
                            public void accept(Throwable throwable) {
                                Log.e("SipAccountService", "Login: error " + throwable.getMessage());
                            }
                        });
            }
        });


        askButton.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("CheckResult")
            @Override
            public void onClick(View view) {
                loader.getContactInfo("TOKEN", "URL").subscribe(
                        new Consumer<Map<String, Object>>() {
                            @Override
                            public void accept(Map<String, Object> map) {
                                Log.i(TAG, "CALL:SUCCESS:" + map.toString());

                            }
                        },
                        new Consumer<Throwable>() {
                            @Override
                            public void accept(Throwable throwable) {
                                throwable.printStackTrace();
                            }
                        }
                );
            }
        });
        order.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("CheckResult")
            @Override
            public void onClick(View view) {
                String json = "{\"amount\":\"" + 123 + "\",\"orderType\":\""
                        + 123 + "\",\"payWay\":" + 123 + "}";
                loader.addOrder(""
                        , json, "2", "sn").subscribe(new Consumer<OrderBean>() {
                    @Override
                    public void accept(OrderBean orderBean) throws Exception {
                        orderBean.getWeChatOrder().getCodeUrl();
                        orderBean.getWeChatOrder().getOrderId();
                        orderBean.getAlipayOrder().getCodeUrl();
                        orderBean.getAlipayOrder().getOrderNum();

                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        throwable.printStackTrace();
                    }
                });


            }
        });
    }

    @SuppressLint("CheckResult")
    private void linkRequest() {
        /*链式请求*/
        loader.deviceRegister("sn", "username", "password", "modelName", "platformName"
                , "ip", "customModelName", "masterNum", "slaveNum", "softVersion"
                , "nkVersion", 4, 4, 4, "location")
                .map(new Function<Map<String, Object>, Observable<Map<String, Object>>>() {
                    @Override
                    public Observable<Map<String, Object>> apply(@NonNull Map<String, Object> map) throws Exception {
                        Log.i(TAG, "map-1:" + Thread.currentThread().getName());
                        JSONObject object = new JSONObject(map);
                        String token = object.getString("token");
                        Log.d(TAG, "------token:" + token + ",json:" + object.toString());
                        return loader.getOrgId(token);
                    }
                })
                .observeOn(Schedulers.newThread())
                .subscribe(new Consumer<Observable<Map<String, Object>>>() {
                    @Override
                    public void accept(@NonNull Observable<Map<String, Object>> o) throws Exception {
                        Log.i(TAG, "subscribe:------------" + Thread.currentThread().getName());
                        JSONObject object = new JSONObject(o.blockingFirst());
                        Log.i(TAG, "object:" + object.toString());
                        String getOrgId = "";
                        try {
                            getOrgId = object.getString("orgId");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        Log.i(TAG, "orgId:" + getOrgId);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Log.e(TAG, "deviceRegister:" + throwable.getMessage());
//                            LonbonToast.showToast(getApplicationContext(), throwable.getMessage());
                    }
                });


    }
}
