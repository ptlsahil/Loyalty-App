package liuvasconcelos.costumerloyalty.mainPage;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.WindowManager;

import liuvasconcelos.costumerloyalty.ActivityUtils;
import liuvasconcelos.costumerloyalty.R;

public class MainPageActivity extends AppCompatActivity {
    private ActionBarDrawerToggle mDrawer;
    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.AppTheme);
        setContentView(R.layout.main_page_act);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        MainPageFragment mainPageFragment = (MainPageFragment) getSupportFragmentManager().findFragmentById(R.id.main_page_content_frame);

        if (mainPageFragment == null){
            mainPageFragment = MainPageFragment.newInstance();
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), mainPageFragment, R.id.main_page_content_frame);
        }

        SharedPreferences preferences = getSharedPreferences("app", MODE_PRIVATE);

        new MainPagePresenter(mainPageFragment, preferences);

        if (mToolbar != null){
            setSupportActionBar(mToolbar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }



//        mDrawer = new ActionBarDrawerToggle(this, mDrawer, mToolbar, R.string.open, R.string.close);
//        mDrawer.setDrawerListener(mActionBarDrawerToggle);
//
//        mFragmentTransaction = getSupportFragmentManager().beginTransaction();
//        mFragmentTransaction.add(R.id.main_container, new HomeFragment());
//        mFragmentTransaction.commit();
//        getSupportActionBar().setTitle("Home");

    }
}
