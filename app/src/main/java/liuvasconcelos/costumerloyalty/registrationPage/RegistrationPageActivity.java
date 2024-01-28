package liuvasconcelos.costumerloyalty.registrationPage;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

import liuvasconcelos.costumerloyalty.ActivityUtils;
import liuvasconcelos.costumerloyalty.R;

public class RegistrationPageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.AppTheme);
        setContentView(R.layout.registration_page_act);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        RegistrationPageFragment registrationPageFragment = (RegistrationPageFragment) getSupportFragmentManager().findFragmentById(R.id.registration_page_content_frame);

        if (registrationPageFragment == null){
            registrationPageFragment = RegistrationPageFragment.newInstance();
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), registrationPageFragment, R.id.registration_page_content_frame);
        }

        SQLiteDatabase database = this.openOrCreateDatabase(
                "costumer-loyalty", Context.MODE_PRIVATE, null
        );
        new RegistrationPagePresenter(registrationPageFragment, this, database);
    }
}
