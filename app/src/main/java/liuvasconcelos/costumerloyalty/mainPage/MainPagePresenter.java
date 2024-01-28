package liuvasconcelos.costumerloyalty.mainPage;


import android.content.SharedPreferences;

public class MainPagePresenter implements MainPageContract.Presenter{

    private final MainPageContract.View mMainPageView;
    private SharedPreferences mSharedPreferences;

    public MainPagePresenter(MainPageContract.View mainPageView,
                             SharedPreferences sharedPreferences) {

        this.mSharedPreferences = sharedPreferences;
        mMainPageView = mainPageView;
        mMainPageView.setPresenter(this);
    }

    @Override
    public String getUserName() {
        return mSharedPreferences.getString("userName", "stranger");
    }
}
