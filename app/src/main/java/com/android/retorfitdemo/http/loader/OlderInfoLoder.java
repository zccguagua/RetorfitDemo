package com.android.retorfitdemo.http.loader;


import com.android.retorfitdemo.http.config.ApiConfig;
import com.android.retorfitdemo.http.manager.RetrofitServiceManager;
import com.android.retorfitdemo.http.model.OrderBean;
import com.android.retorfitdemo.http.response.PayLoad;
import com.android.retorfitdemo.http.service.OlderInfoService;

import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;


/**
 * Created by zcc on 2019/1/23.
 * 老人信息请求
 */

public class OlderInfoLoder extends ObjectLoader {
    private OlderInfoService service;

    public OlderInfoLoder() {
        this.service = RetrofitServiceManager.getInstance(ApiConfig.BASE_URL).create(OlderInfoService.class);
    }

    public Observable<Map<String, Object>> Login(int deviceType, String terminalSn, String orgId) {
        return observe(service.login(deviceType, terminalSn, orgId))
                .map(new PayLoad<Map<String, Object>>());
    }

    public Observable<Map<String, Object>> getContactInfo(String token, String url) {
        return observe(service.getContactInfo(token, url));
    }

    public Observable<OrderBean> addOrder(String token, String order, String userType, String terminalSn) {
        return observe(service.addOrder(token, order, userType, terminalSn))
                .map(new PayLoad<OrderBean>());
    }

    public Observable<Map<String, Object>> bindingAllElder(String token, String terminalSn) {
        return observe(service.bindingAllElder(token, terminalSn))
                .map(new Function<Map<String, Object>, Map<String, Object>>() {
                    @Override
                    public Map<String, Object> apply(@NonNull Map<String, Object> stringObjectMap) throws Exception {
                        return stringObjectMap;
                    }
                });
    }
    public Observable<Map<String, Object>> getOrgId(String token) {
        return service.getOrgId(token).map(new PayLoad<Map<String, Object>>());
    }

    public Observable<Map<String, Object>> deviceRegister(String sn, String username
            , String password, String modelName, String platformName, String ip
            , String customModelName, String masterNum, String slaveNum, String softVerison
            , String nkVersion, int scene, int system, int type, String location) {
        return observe(service.deviceRegister(sn, username, password, modelName
                , platformName, ip, customModelName, masterNum, slaveNum, softVerison
                , nkVersion, scene, system, type, location))
                .map(new PayLoad<Map<String, Object>>());
    }


}
