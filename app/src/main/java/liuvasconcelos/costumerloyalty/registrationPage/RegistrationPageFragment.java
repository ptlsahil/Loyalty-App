package liuvasconcelos.costumerloyalty.registrationPage;


import android.content.Intent;
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
import liuvasconcelos.costumerloyalty.databinding.RegistrationPageFragBinding;
import liuvasconcelos.costumerloyalty.mainPage.MainPageActivity;

public class RegistrationPageFragment extends Fragment implements RegistrationPageContract.View{

    private RegistrationPageContract.Presenter mPresenter;
    private RegistrationPageFragBinding mRegistrationPageFragBinding;

    public RegistrationPageFragment() {}

    public static RegistrationPageFragment newInstance() {
        return new RegistrationPageFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRegistrationPageFragBinding = DataBindingUtil.inflate(inflater, R.layout.registration_page_frag,container,false);
        mRegistrationPageFragBinding.setHandler(this);

        return mRegistrationPageFragBinding.getRoot();
    }

    @Override
    public void setPresenter(RegistrationPageContract.Presenter presenter) {
        mPresenter = presenter;
    }

    private void goToMainPage() {
        Intent intent = new Intent(getContext(), MainPageActivity.class);
        startActivity(intent);
    }

    @Override
    public void registerUser(android.view.View view) {
        String name = mRegistrationPageFragBinding.name.getText().toString();
        String cpf = mRegistrationPageFragBinding.cpf.getText().toString();
        String phoneNumber =mRegistrationPageFragBinding.phone.getText().toString();
        String email = mRegistrationPageFragBinding.email.getText().toString();
        String password = mRegistrationPageFragBinding.password.getText().toString();

        if(mPresenter.registerUser(name, cpf, phoneNumber, email, password)) {
            goToMainPage();
        }else {
            showToast();
        }
    }

    private void showToast() {
        Toast.makeText(getContext(), R.string.impossible_to_register_toast, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLocalLoader() {

    }

    @Override
    public void hideLocalLoader() {

    }

}

