package liuvasconcelos.costumerloyalty.forgetPasswordPage;


import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import liuvasconcelos.costumerloyalty.R;
import liuvasconcelos.costumerloyalty.databinding.ForgetPasswordFragBinding;
import liuvasconcelos.costumerloyalty.databinding.RegistrationPageFragBinding;
import liuvasconcelos.costumerloyalty.login.LoginActivity;

public class ForgetPasswordPageFragment extends Fragment implements ForgetPasswordPageContract.View{

    private ForgetPasswordPageContract.Presenter mPresenter;
    private ForgetPasswordFragBinding mForgetPasswordPageFragBinding;

    public ForgetPasswordPageFragment() {}

    public static ForgetPasswordPageFragment newInstance() {
        return new ForgetPasswordPageFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mForgetPasswordPageFragBinding = DataBindingUtil.inflate(inflater, R.layout.forget_password_frag,container,false);
        mForgetPasswordPageFragBinding.setHandler(this);

        return mForgetPasswordPageFragBinding.getRoot();
    }

    @Override
    public void setPresenter(ForgetPasswordPageContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void sendEmail(android.view.View view) {
        String emailSubject = getResources().getString(R.string.email_subject);
        String emailBody = getResources().getString(R.string.email_body);
        String clientEmail = mForgetPasswordPageFragBinding.emailToSend.getText().toString();

        try {
            Intent intent = new Intent(Intent.ACTION_SENDTO);
            intent.setType("text/plain");
            intent.putExtra(Intent.EXTRA_SUBJECT, emailSubject);
            intent.putExtra(Intent.EXTRA_TEXT, emailBody);
            intent.setData(Uri.parse(clientEmail));
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);

            showSentEmailToast();
            goToLoginPage();
        } catch (Exception e){
            showImpossivelToSendEmailToast();
        }

    }

    private void goToLoginPage() {
        Intent intent = new Intent(getContext(), LoginActivity.class);
        startActivity(intent);
    }

    private void showSentEmailToast() {
        Toast.makeText(getContext(), R.string.sent_email_toast, Toast.LENGTH_SHORT).show();
    }

    private void showImpossivelToSendEmailToast() {
        Toast.makeText(getContext(), R.string.impossible_to_send_email_toast, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLocalLoader() {

    }

    @Override
    public void hideLocalLoader() {

    }

}

