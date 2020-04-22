package com.android.retorfitdemo.http.manager;


import com.android.retorfitdemo.R;
import com.android.retorfitdemo.http.config.ApiConfig;
import com.android.retorfitdemo.http.intercepter.HttpCommonInterceptor;
import com.android.retorfitdemo.http.ssl.SslSocketFactory;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 描述: RetrofitServiceManager 管理类,连接基本设置、OkHttpClient 拦截器配置,初始化 Retrofit
 * 时间: 2018/04/04
 */

public class RetrofitServiceManager {
    private static final int DEFAULT_TIME_OUT = 5;//超时时间 5s
    private static final int DEFAULT_READ_TIME_OUT = 10;
    private Retrofit mRetrofit;
    private static RetrofitServiceManager manager;
    public static int[] certificates = new int[]{R.raw.lonbonali};

    /**
     * 获取 RetrofitServiceManager
     *
     * @return
     */
    public static RetrofitServiceManager getInstance(String url) {
        if (manager == null) {
            manager = new RetrofitServiceManager(url);
        }
        return manager;
    }

    /**
     * Constructor
     */
    private RetrofitServiceManager(String url) {
        // 每次实例化都必须指定url,避免出现不同url的情况
        // 创建 OKHttpClient
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(DEFAULT_TIME_OUT, TimeUnit.SECONDS);//连接超时时间
        builder.writeTimeout(DEFAULT_READ_TIME_OUT, TimeUnit.SECONDS);//写操作 超时时间
        builder.readTimeout(DEFAULT_READ_TIME_OUT, TimeUnit.SECONDS);//读操作超时时间
        builder.sslSocketFactory(SslSocketFactory.getSSLSocketFactory(certificates));
        builder.hostnameVerifier(SslSocketFactory.getHostnameVerifier());
        // 添加公共参数拦截器

        HttpCommonInterceptor commonInterceptor = new HttpCommonInterceptor.Builder()
//                .addHeaderParams("token", MyApplication.getInstance().getToken())
                .addHeaderParams("token", "")
                .addHeaderParams("Content-Type", "application/json;charset=utf-8")
//                .addHeaderParams("userToken","1234343434dfdfd3434")
//                .addHeaderParams("userId","123445")
                .build();
        builder.addInterceptor(new Interceptor() {
                                   @Override
                                   public Response intercept(Chain chain) throws IOException {
                                       Request request = chain.request().newBuilder()
                                               .addHeader("Content-Type", "application/json")
                                               .addHeader("token", ApiConfig.TOKEN)
                                               .build();
                                       return chain.proceed(request);
                                   }
                               }
        );

        // 创建Retrofit
        mRetrofit = new Retrofit.Builder()
                .client(builder.build())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(url)
                .build();
    }

    /**
     * 获取对应的Service
     *
     * @param service
     * @param <T>
     * @return
     */
    public <T> T create(Class<T> service) {
        return mRetrofit.create(service);
    }

}
