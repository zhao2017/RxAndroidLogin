package test.com.zh.rxandroidlogin.login;


import com.alibaba.fastjson.JSONObject;

import java.io.IOException;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import rx.Observable;
import rx.Subscriber;

/**
 * 创建日期：2019/3/28
 * 描述: 登录的 utils
 *
 * @author: zhaoh
 */
public class LoginUtils {

    private static final MediaType JSON
            = MediaType.get("application/json; charset=utf-8");
    private OkHttpClient okHttpClient;

    public LoginUtils() {
        okHttpClient = new OkHttpClient();
    }

    public Observable<String> doLogin(String url, Map<String, String> parms) {

        return Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                if (!subscriber.isUnsubscribed()) {
                    JSONObject jsonObject = new JSONObject();
                    if (parms != null && !parms.isEmpty()) {
                        for (Map.Entry<String, String> entry : parms.entrySet()) {
                            jsonObject.put(entry.getKey(), entry.getValue());
                        }
                        RequestBody requestBody = RequestBody.create(MediaType.get("application/json; charset=utf-8"), jsonObject.toJSONString());
                        Request request = new Request.Builder()
                                .url(url)
                                .post(requestBody)
                                .build();
                        okHttpClient.newCall(request).enqueue(new Callback() {
                            @Override
                            public void onFailure(Call call, IOException e) {
                                subscriber.onError(e);
                            }

                            @Override
                            public void onResponse(Call call, Response response) throws IOException {
                                if (response.isSuccessful()) {
                                    String data = response.body().string();
                                    subscriber.onNext(data);
                                    subscriber.onCompleted();
                                }

                            }
                        });
                    }
                }

            }
        });
    }


}
