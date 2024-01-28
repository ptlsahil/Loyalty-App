package liuvasconcelos.costumerloyalty.forgetPasswordPage;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

import liuvasconcelos.costumerloyalty.ActivityUtils;
import liuvasconcelos.costumerloyalty.R;

public class ForgetPasswordPageActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.AppTheme);
        setContentView(R.layout.forget_password_act);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        ForgetPasswordPageFragment forgetPasswordPageFragment = (ForgetPasswordPageFragment) getSupportFragmentManager().findFragmentById(R.id.forget_password_content_frame);

        if (forgetPasswordPageFragment == null){
            forgetPasswordPageFragment = ForgetPasswordPageFragment.newInstance();
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), forgetPasswordPageFragment, R.id.forget_password_content_frame);
        }

        new ForgetPasswordPagePresenter(forgetPasswordPageFragment);
    }
}
