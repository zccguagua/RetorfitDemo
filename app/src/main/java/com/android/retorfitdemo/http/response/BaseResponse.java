package com.android.retorfitdemo.http.response;

/**
 * 类名:BaseResponse
 * 描述:网络请求基类
 * {
 * "msg": "success",
 * "body": {
 * "data": {
 * "sipAccountId": null,//老人的sip账号主键
 * "sipAccount": null,//老人的sip账号
 * "sipPassword": null,//老人的sip账号密码
 * "contactsList":
 * [{
 * //老人的联系人信息
 * "contactsId": "1",//联系人主键
 * "name": "王三",//联系人名字
 * "relationDesc": "弟弟",//联系人关系
 * "photo": null,//联系人的头像相对路径
 * "phoneNum": "18133678656",//联系人手机号码
 * "sipAccount": null,//联系人sip账号
 * "sipPassword": null//联系人sip账号密码
 * }]
 * }
 * },
 * "status": "200"
 * }
 */

public class BaseResponse<T> {
    public int status;
    public String msg;
    public T body;

    public boolean isSuccess() {
        return status == 200;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"body\":")
                .append(body);
        sb.append('}');
        return sb.toString();
    }
}
