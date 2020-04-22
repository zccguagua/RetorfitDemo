package com.android.retorfitdemo.http.model;

import java.util.List;

/**
 * Created by zcc on 2019/1/23.
 */

public class ContactInfo {

    /**
     * sipAccountId : null
     * sipAccount : null
     * sipPassword : null
     * contactsList : [{"contactsId":"1",
     * "name":"王三",
     * "relationDesc":"弟弟",
     * "photo":null,
     * "phoneNum":"18133678656",
     * "sipAccount":null,
     * "sipPassword":null
     * }]
     */

    private String sipAccountId;//老人的sip账号主键
    private String sipAccount;//老人的sip账号
    private String sipPassword;//老人的sip账号密码
    private List<ContactsListBean> contactsList;//老人的联系人

    public String getSipAccountId() {
        return sipAccountId;
    }

    public void setSipAccountId(String sipAccountId) {
        this.sipAccountId = sipAccountId;
    }

    public String getSipAccount() {
        return sipAccount;
    }

    public void setSipAccount(String sipAccount) {
        this.sipAccount = sipAccount;
    }

    public String getSipPassword() {
        return sipPassword;
    }

    public void setSipPassword(String sipPassword) {
        this.sipPassword = sipPassword;
    }

    public List<ContactsListBean> getContactsList() {
        return contactsList;
    }

    public void setContactsList(List<ContactsListBean> contactsList) {
        this.contactsList = contactsList;
    }

    public static class ContactsListBean {
        /**
         * contactsId : 1
         * name : 王三
         * relationDesc : 弟弟
         * photo : null
         * phoneNum : 18133678656
         * sipAccount : null
         * sipPassword : null
         */

        private String contactsId;//联系人主键
        private String name;//联系人姓名
        private String relationDesc;//联系人关系
        private String photo;//联系人的头像路径
        private String phoneNum;//联系人的手机号码
        private String sipAccount;//联系人的sip账号
        private String sipPassword;//联系人的sip密码

        public String getContactsId() {
            return contactsId;
        }

        public void setContactsId(String contactsId) {
            this.contactsId = contactsId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getRelationDesc() {
            return relationDesc;
        }

        public void setRelationDesc(String relationDesc) {
            this.relationDesc = relationDesc;
        }

        public String getPhoto() {
            return photo;
        }

        public void setPhoto(String photo) {
            this.photo = photo;
        }

        public String getPhoneNum() {
            return phoneNum;
        }

        public void setPhoneNum(String phoneNum) {
            this.phoneNum = phoneNum;
        }

        public String getSipAccount() {
            return sipAccount;
        }

        public void setSipAccount(String sipAccount) {
            this.sipAccount = sipAccount;
        }

        public String getSipPassword() {
            return sipPassword;
        }

        public void setSipPassword(String sipPassword) {
            this.sipPassword = sipPassword;
        }
    }
}
