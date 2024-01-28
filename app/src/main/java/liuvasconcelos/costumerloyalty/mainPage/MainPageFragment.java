package liuvasconcelos.costumerloyalty.mainPage;


import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import liuvasconcelos.costumerloyalty.R;
import liuvasconcelos.costumerloyalty.databinding.LoginFragBinding;
import liuvasconcelos.costumerloyalty.databinding.MainPageFragBinding;
import liuvasconcelos.costumerloyalty.forgetPasswordPage.ForgetPasswordPageActivity;

public class MainPageFragment extends Fragment implements MainPageContract.View{

    private MainPageContract.Presenter mPresenter;
    private MainPageFragBinding mMainPageFragBinding;

    public MainPageFragment() {}

    public static MainPageFragment newInstance() {
        return new MainPageFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mMainPageFragBinding = DataBindingUtil.inflate(inflater, R.layout.main_page_frag,container,false);
        mMainPageFragBinding.setHandler(this);

        mMainPageFragBinding.username.setText(mPresenter.getUserName());
        return mMainPageFragBinding.getRoot();
    }

    @Override
    public void setPresenter(MainPageContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void showLocalLoader() {

    }

    @Override
    public void hideLocalLoader() {

    }

}

