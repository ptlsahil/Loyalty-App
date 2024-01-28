package liuvasconcelos.costumerloyalty.introductionPage;


import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import liuvasconcelos.costumerloyalty.R;
import liuvasconcelos.costumerloyalty.databinding.IntroductionPageFragBinding;
import liuvasconcelos.costumerloyalty.login.LoginActivity;
import liuvasconcelos.costumerloyalty.registrationPage.RegistrationPageActivity;

public class IntroPageFragment extends Fragment implements IntroPageContract.View{

    private IntroPageContract.Presenter mPresenter;
    private IntroductionPageFragBinding mIntroductionPageFragBinding;

    public IntroPageFragment() {}

    public static IntroPageFragment newInstance() {
        return new IntroPageFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mIntroductionPageFragBinding = DataBindingUtil.inflate(inflater, R.layout.introduction_page_frag,container,false);
        mIntroductionPageFragBinding.setHandler(this);

        return mIntroductionPageFragBinding.getRoot();
    }

    @Override
    public void setPresenter(IntroPageContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void goToLoginPage(android.view.View view) {
        Intent intent = new Intent(getContext(), LoginActivity.class);
        startActivity(intent);
    }

    @Override
    public void goToRegistrationPage(android.view.View view) {
        Intent intent = new Intent(getContext(), RegistrationPageActivity.class);
        startActivity(intent);
    }

    @Override
    public void showLocalLoader() {
    }

    @Override
    public void hideLocalLoader() {
    }


}

