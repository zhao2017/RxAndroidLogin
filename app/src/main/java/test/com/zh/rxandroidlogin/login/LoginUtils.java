package test.com.zh.rxandroidlogin.login;

import java.util.Map;
import java.util.Set;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import rx.Observable;
import rx.Subscriber;

/**
 * 创建日期：2019/3/28
 * 描述: 登录的 utils
 *
 * @author: zhaoh
 */
public class LoginUtils {

    private OkHttpClient okHttpClient;
    public LoginUtils(){
        okHttpClient = new OkHttpClient();
    }

    public Observable<String> doLogin(Map<String,String> parms){
        return Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                if(!subscriber.isUnsubscribed()){
                    FormBody.Builder formBody = new FormBody.Builder();
                    if(parms!=null&&!parms.isEmpty()){
                        Set<Map.Entry<String, String>> entries = parms.entrySet();
                        parms.keySet();

                    }

                }

            }
        });
    }



}
