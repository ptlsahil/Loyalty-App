package liuvasconcelos.costumerloyalty.login;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

import liuvasconcelos.costumerloyalty.ActivityUtils;
import liuvasconcelos.costumerloyalty.R;
import liuvasconcelos.costumerloyalty.introductionPage.IntroPageFragment;
import liuvasconcelos.costumerloyalty.introductionPage.IntroPagePresenter;

public class LoginActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.AppTheme);
        setContentView(R.layout.login_act);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        LoginFragment loginFragment = (LoginFragment) getSupportFragmentManager().findFragmentById(R.id.login_content_frame);

        if (loginFragment == null){
            loginFragment = LoginFragment.newInstance();
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), loginFragment, R.id.login_content_frame);
        }

        SQLiteDatabase database = this.openOrCreateDatabase(
                "costumer-loyalty", Context.MODE_PRIVATE, null
        );

        SharedPreferences.Editor sharedPreferencesEditor =  getSharedPreferences("app", MODE_PRIVATE).edit();

        new LoginPresenter(loginFragment, this, database, sharedPreferencesEditor);
    }
}
