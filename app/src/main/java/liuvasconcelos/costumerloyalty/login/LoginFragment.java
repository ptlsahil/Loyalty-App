package liuvasconcelos.costumerloyalty.login;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import liuvasconcelos.costumerloyalty.R;
import liuvasconcelos.costumerloyalty.databinding.LoginFragBinding;
import liuvasconcelos.costumerloyalty.forgetPasswordPage.ForgetPasswordPageActivity;
import liuvasconcelos.costumerloyalty.mainPage.MainPageActivity;
import liuvasconcelos.costumerloyalty.registrationPage.RegistrationPageActivity;
import liuvasconcelos.costumerloyalty.registrationPage.RegistrationPageContract;

public class LoginFragment extends Fragment implements LoginContract.View{

    private LoginContract.Presenter mPresenter;
    private LoginFragBinding mLoginFragBinding;

    public LoginFragment() {}

    public static LoginFragment newInstance() {
        return new LoginFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mLoginFragBinding = DataBindingUtil.inflate(inflater, R.layout.login_frag,container,false);
        mLoginFragBinding.setHandler(this);

        return mLoginFragBinding.getRoot();
    }

    @Override
    public void goToForgetPasswordPage(android.view.View view) {
        Intent intent = new Intent(getContext(), ForgetPasswordPageActivity.class);
        startActivity(intent);
    }

    @Override
    public void goToMainPage(android.view.View view) {
        if(credentialAreCorrect()) {
            Intent intent = new Intent(getContext(), MainPageActivity.class);
            startActivity(intent);
        }else {
            showIncorrectCrendentialToast();
        }

    }

    private Boolean credentialAreCorrect() {
        String email = mLoginFragBinding.loginEmail.getText().toString();
        String password = mLoginFragBinding.loginPassword.getText().toString();

        return mPresenter.checkCredentials(email, password);
    }

    private void showIncorrectCrendentialToast() {
        Toast.makeText(getContext(), R.string.toast, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setPresenter(LoginContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void showLocalLoader() {

    }

    @Override
    public void hideLocalLoader() {

    }

}

