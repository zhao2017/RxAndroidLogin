package test.com.zh.rxandroidlogin;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import test.com.zh.rxandroidlogin.login.LoginUtils;
import test.com.zh.rxandroidlogin.utils.DeviceUtils;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.et_account)
    EditText etAccount;
    @BindView(R.id.et_password)
    EditText etPassword;

    private static final String LOGIN_PRO = "http://api.family.jzexueyun.com/family/user/register/login";
    private static final String LOGIN_TEST = "http://test.family.juziwl.cn/family/user/register/login";

    private LoginUtils utils = null;

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        utils = new LoginUtils();
    }

    public void onLoginClick(View view) {
        Map<String, String> map = new HashMap<>();
        map.put("username", etAccount.getText().toString().trim());
        map.put("password", etPassword.getText().toString().trim());
        map.put("deviceType", DeviceUtils.getDeviceType());
        utils.doLogin(LOGIN_TEST, map).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<String>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i(TAG, e.toString());
                    }

                    @Override
                    public void onNext(String s) {
                        Log.i(TAG, s);
                    }
                });
    }


    private String createJsonString(){

        JSONObject jsonObject = new JSONObject();

        return "";
    }

}
