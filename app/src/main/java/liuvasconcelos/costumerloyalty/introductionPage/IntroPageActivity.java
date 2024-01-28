package liuvasconcelos.costumerloyalty.introductionPage;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

import liuvasconcelos.costumerloyalty.ActivityUtils;
import liuvasconcelos.costumerloyalty.R;
import liuvasconcelos.costumerloyalty.login.LoginFragment;

public class IntroPageActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.AppTheme);
        setContentView(R.layout.introduction_page_act);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        IntroPageFragment introPageFragment = (IntroPageFragment) getSupportFragmentManager().findFragmentById(R.id.introduction_page_content_frame);

        if (introPageFragment == null){
            introPageFragment = IntroPageFragment.newInstance();
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), introPageFragment, R.id.introduction_page_content_frame);
        }

        new IntroPagePresenter(introPageFragment);
    }


}
