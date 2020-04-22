package com.android.retorfitdemo.http.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by zcc on 2019/7/16.
 * 创建订单
 */

public class OrderBean {

    /**
     * weChatOrder : {"package":"","appid":"","sign":"","partnerid":"","prepayid":"","noncestr":"","timestamp":"","orderId":""}
     * alipayOrder : {"goodsTitle":"","goodsDetail":"","goodsAmount":"","orderId":"","orderNum":"","sign":""}
     */

    private WeChatOrderBean weChatOrder;
    private AlipayOrderBean alipayOrder;

    public WeChatOrderBean getWeChatOrder() {
        return weChatOrder;
    }

    public void setWeChatOrder(WeChatOrderBean weChatOrder) {
        this.weChatOrder = weChatOrder;
    }

    public AlipayOrderBean getAlipayOrder() {
        return alipayOrder;
    }

    public void setAlipayOrder(AlipayOrderBean alipayOrder) {
        this.alipayOrder = alipayOrder;
    }

    public static class WeChatOrderBean {
        /**
         * package :包
         * appid :应用id
         * sign :签名
         * partnerid :商户id
         * prepayid :微信订单id
         * noncestr :随机字符
         * timestamp :订单创建时间
         * orderId :商家订单id
         * codeUrl :二维码链接
         * mch_id :
         */

        @SerializedName("package")
        private String packageX;
        private String appid;
        private String sign;
        private String partnerid;
        private String prepayid;
        private String noncestr;
        private String timestamp;
        private String orderId;
        private String codeUrl;
        private String mch_id;

        public String getPackageX() {
            return packageX;
        }

        public void setPackageX(String packageX) {
            this.packageX = packageX;
        }

        public String getAppid() {
            return appid;
        }

        public void setAppid(String appid) {
            this.appid = appid;
        }

        public String getSign() {
            return sign;
        }

        public void setSign(String sign) {
            this.sign = sign;
        }

        public String getPartnerid() {
            return partnerid;
        }

        public void setPartnerid(String partnerid) {
            this.partnerid = partnerid;
        }

        public String getPrepayid() {
            return prepayid;
        }

        public void setPrepayid(String prepayid) {
            this.prepayid = prepayid;
        }

        public String getNoncestr() {
            return noncestr;
        }

        public void setNoncestr(String noncestr) {
            this.noncestr = noncestr;
        }

        public String getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(String timestamp) {
            this.timestamp = timestamp;
        }

        public String getOrderId() {
            return orderId;
        }

        public void setOrderId(String orderId) {
            this.orderId = orderId;
        }

        public String getCodeUrl() {
            return codeUrl;
        }

        public void setCodeUrl(String codeUrl) {
            this.codeUrl = codeUrl;
        }

        public String getMch_id() {
            return mch_id;
        }

        public void setMch_id(String mch_id) {
            this.mch_id = mch_id;
        }

        @Override
        public String toString() {
            return "WeChatOrderBean{" +
                    "packageX='" + packageX + '\'' +
                    ", appid='" + appid + '\'' +
                    ", sign='" + sign + '\'' +
                    ", partnerid='" + partnerid + '\'' +
                    ", prepayid='" + prepayid + '\'' +
                    ", noncestr='" + noncestr + '\'' +
                    ", timestamp='" + timestamp + '\'' +
                    ", orderId='" + orderId + '\'' +
                    ", codeUrl='" + codeUrl + '\'' +
                    ", mch_id='" + mch_id + '\'' +
                    '}';
        }
    }

    public static class AlipayOrderBean {
        /**
         * goodsTitle :商品标题
         * goodsDetail :商品叙述
         * goodsAmount :商品价格
         * orderId :订单id
         * orderNum :订单号
         * sign :订单加签结果
         */
        private String orderId;
        private String orderNum;
        private String tradeNum;
        private String receiptAmount;
        private String sign;
        private String orderStatus;
        private String gmtCreate;
        private String gmtPayment;
        private String fundBillList;
        private String buyerPayAmount;
        private String gmtCreateSecond;
        private String gmtPaymentSecond;
        private String gmtRefundSecond;
        private String goodsTitle;
        private String goodsDetail;
        private String goodsAmount;
        private String sellerId;
        private String sellerAccount;
        private String buyerId;
        private String buyerAccount;
        private String refundStatus;
        private String gmtRefund;
        private String refundFee;
        private String codeUrl;

        public String getOrderId() {
            return orderId;
        }

        public void setOrderId(String orderId) {
            this.orderId = orderId;
        }

        public String getOrderNum() {
            return orderNum;
        }

        public void setOrderNum(String orderNum) {
            this.orderNum = orderNum;
        }

        public String getTradeNum() {
            return tradeNum;
        }

        public void setTradeNum(String tradeNum) {
            this.tradeNum = tradeNum;
        }

        public String getReceiptAmount() {
            return receiptAmount;
        }

        public void setReceiptAmount(String receiptAmount) {
            this.receiptAmount = receiptAmount;
        }

        public String getSign() {
            return sign;
        }

        public void setSign(String sign) {
            this.sign = sign;
        }

        public String getOrderStatus() {
            return orderStatus;
        }

        public void setOrderStatus(String orderStatus) {
            this.orderStatus = orderStatus;
        }

        public String getGmtCreate() {
            return gmtCreate;
        }

        public void setGmtCreate(String gmtCreate) {
            this.gmtCreate = gmtCreate;
        }

        public String getGmtPayment() {
            return gmtPayment;
        }

        public void setGmtPayment(String gmtPayment) {
            this.gmtPayment = gmtPayment;
        }

        public String getFundBillList() {
            return fundBillList;
        }

        public void setFundBillList(String fundBillList) {
            this.fundBillList = fundBillList;
        }

        public String getBuyerPayAmount() {
            return buyerPayAmount;
        }

        public void setBuyerPayAmount(String buyerPayAmount) {
            this.buyerPayAmount = buyerPayAmount;
        }

        public String getGmtCreateSecond() {
            return gmtCreateSecond;
        }

        public void setGmtCreateSecond(String gmtCreateSecond) {
            this.gmtCreateSecond = gmtCreateSecond;
        }

        public String getGmtPaymentSecond() {
            return gmtPaymentSecond;
        }

        public void setGmtPaymentSecond(String gmtPaymentSecond) {
            this.gmtPaymentSecond = gmtPaymentSecond;
        }

        public String getGmtRefundSecond() {
            return gmtRefundSecond;
        }

        public void setGmtRefundSecond(String gmtRefundSecond) {
            this.gmtRefundSecond = gmtRefundSecond;
        }

        public String getGoodsTitle() {
            return goodsTitle;
        }

        public void setGoodsTitle(String goodsTitle) {
            this.goodsTitle = goodsTitle;
        }

        public String getGoodsDetail() {
            return goodsDetail;
        }

        public void setGoodsDetail(String goodsDetail) {
            this.goodsDetail = goodsDetail;
        }

        public String getGoodsAmount() {
            return goodsAmount;
        }

        public void setGoodsAmount(String goodsAmount) {
            this.goodsAmount = goodsAmount;
        }

        public String getSellerId() {
            return sellerId;
        }

        public void setSellerId(String sellerId) {
            this.sellerId = sellerId;
        }

        public String getSellerAccount() {
            return sellerAccount;
        }

        public void setSellerAccount(String sellerAccount) {
            this.sellerAccount = sellerAccount;
        }

        public String getBuyerId() {
            return buyerId;
        }

        public void setBuyerId(String buyerId) {
            this.buyerId = buyerId;
        }

        public String getBuyerAccount() {
            return buyerAccount;
        }

        public void setBuyerAccount(String buyerAccount) {
            this.buyerAccount = buyerAccount;
        }

        public String getRefundStatus() {
            return refundStatus;
        }

        public void setRefundStatus(String refundStatus) {
            this.refundStatus = refundStatus;
        }

        public String getGmtRefund() {
            return gmtRefund;
        }

        public void setGmtRefund(String gmtRefund) {
            this.gmtRefund = gmtRefund;
        }

        public String getRefundFee() {
            return refundFee;
        }

        public void setRefundFee(String refundFee) {
            this.refundFee = refundFee;
        }

        public String getCodeUrl() {
            return codeUrl;
        }

        public void setCodeUrl(String codeUrl) {
            this.codeUrl = codeUrl;
        }

        @Override
        public String toString() {
            return "AlipayOrderBean{" +
                    "orderId='" + orderId + '\'' +
                    ", orderNum='" + orderNum + '\'' +
                    ", tradeNum='" + tradeNum + '\'' +
                    ", receiptAmount='" + receiptAmount + '\'' +
                    ", sign='" + sign + '\'' +
                    ", orderStatus='" + orderStatus + '\'' +
                    ", gmtCreate='" + gmtCreate + '\'' +
                    ", gmtPayment='" + gmtPayment + '\'' +
                    ", fundBillList='" + fundBillList + '\'' +
                    ", buyerPayAmount='" + buyerPayAmount + '\'' +
                    ", gmtCreateSecond='" + gmtCreateSecond + '\'' +
                    ", gmtPaymentSecond='" + gmtPaymentSecond + '\'' +
                    ", gmtRefundSecond='" + gmtRefundSecond + '\'' +
                    ", goodsTitle='" + goodsTitle + '\'' +
                    ", goodsDetail='" + goodsDetail + '\'' +
                    ", goodsAmount='" + goodsAmount + '\'' +
                    ", sellerId='" + sellerId + '\'' +
                    ", sellerAccount='" + sellerAccount + '\'' +
                    ", buyerId='" + buyerId + '\'' +
                    ", buyerAccount='" + buyerAccount + '\'' +
                    ", refundStatus='" + refundStatus + '\'' +
                    ", gmtRefund='" + gmtRefund + '\'' +
                    ", refundFee='" + refundFee + '\'' +
                    ", codeUrl='" + codeUrl + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "OrderBean{" +
                "weChatOrder=" + (null == weChatOrder ? "null" : weChatOrder.toString()) +
                ", alipayOrder=" + (null == alipayOrder ? "null" : alipayOrder.toString()) +
                '}';
    }
}
