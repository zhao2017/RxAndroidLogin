package test.com.zh.rxandroidlogin;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.et_account)
    EditText etAccount;
    @BindView(R.id.et_password)
    EditText etPassword;

    private static final String LOGIN_PRO = "http://api.family.jzexueyun.com/family/user/register/login";
    private static final String LOGIN_TEST = "http://test.family.juziwl.cn/family/user/register/login";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    public void onLoginClick(View view) {

    }
}
