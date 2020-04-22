package com.android.retorfitdemo.http.service;


import com.android.retorfitdemo.http.model.OrderBean;
import com.android.retorfitdemo.http.response.BaseResponse;

import java.util.Map;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

import io.reactivex.Observable;
import retrofit2.http.Url;

/**
 * Created by zcc on 2019/1/23.
 * 老人登陆请求接口
 */

public interface OlderInfoService {
    /**
     * 老人登陆获取token
     *
     * @param deviceType 设备类型
     * @param terminalSn 序列号
     * @param orgId      项目标识
     */
    @FormUrlEncoded
    @POST("api/v1.0/terminal/login")
    Observable<BaseResponse<Map<String, Object>>> login(@Field("deviceType") int deviceType, @Field("terminalSn") String terminalSn, @Field("orgId") String orgId);


    /**
     * 查询指定老人的联系人列表
     * params:{"identity":"150825197310308381","name":"林志玲"}
     */
    @GET
    Observable<Map<String, Object>> getContactInfo(@Header("token") String token, @Url String url);


    /**
     * 缴费-创建订单（新）
     *
     * @param order      order      {
     *                   "amount":"",//金额：单位元
     *                   "payWay":"",//支付方式：：1.支付宝 2微信
     *                   "orderType":""//缴费类型：1.一个月 3 三个月 6 六个月
     *                   }
     * @param userType   用户类型1.子女app 2.终端
     * @param terminalSn 终端序列号 终端必填
     */
    @Headers("Content-Type:application/x-www-form-urlencoded; charset=utf-8")
    @POST("api/v1.0/familyApp/vip/addOrder")
    @FormUrlEncoded
    Observable<BaseResponse<OrderBean>> addOrder(@Header("token") String token, @Field("order") String order
            , @Field("userType") String userType, @Field("terminalSn") String terminalSn);


    @Headers("Content-Type:application/x-www-form-urlencoded")
    @HTTP(method = "DELETE", path = "api/v1.0/terminal/bindingAllElder", hasBody = true)
    Observable<Map<String, Object>> bindingAllElder(@Header("token") String token, @Query("terminalSn") String terminalSn);


    /**
     * 设备注册
     *
     * @param sn              设备序列号
     * @param username        设备用户账号
     * @param password        设备密码
     * @param modelName       设备/产品型号
     * @param platformName    硬件平台名称
     * @param ip              ip
     * @param customModelName 设备/产品型号（定制）
     * @param masterNum       主机号
     * @param slaveNum        分机号
     * @param softVersion     当前软件版本
     * @param nkVersion       当前nk系统版本
     * @param scene           场景 (0公共 1医院 2监狱 3银行 4养老 5监狱和医院),如不传则交互平台自动判断场景
     * @param system          系统模块 (0默认 100住院护理对讲 101门诊排队 102体检排队(包括抽血) 103取药排队 104输液报警 105人体导诊 106地图导航 200监仓对讲 400养老护理对讲)
     * @param type            类型 (0默认 1主机 2门口机 3普通分机 4交互终端(带业务功能的分机) 5家属分机(探视、会见) 6叫号器(排队系统分机) 7显示屏 8签到机 9手持主机)
     * @param location        位置备注
     */
    @FormUrlEncoded
    @POST("/api/v1/subscriber/register")
    Observable<BaseResponse<Map<String, Object>>> deviceRegister(@Field("sn") String sn
            , @Field("username") String username
            , @Field("password") String password
            , @Field("modelName") String modelName
            , @Field("platformName") String platformName
            , @Field("ip") String ip
            , @Field("customModelName") String customModelName
            , @Field("masterNum") String masterNum
            , @Field("slaveNum") String slaveNum
            , @Field("softVersion") String softVersion
            , @Field("nkVersion") String nkVersion
            , @Field("scene") int scene
            , @Field("system") int system
            , @Field("type") int type
            , @Field("location") String location
    );


    /**
     * 获取orgId
     *
     * @param token token
     */
    @GET("/elder/api/v1/deviceManager/getOrgId")
    Observable<BaseResponse<Map<String, Object>>> getOrgId(@Query("token") String token);


}
