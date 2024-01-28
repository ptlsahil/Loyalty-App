package liuvasconcelos.costumerloyalty.login;


import liuvasconcelos.costumerloyalty.BasePresenter;
import liuvasconcelos.costumerloyalty.BaseView;

public interface LoginContract {
    interface View extends BaseView<Presenter> {
        void goToForgetPasswordPage(android.view.View view);
        void goToMainPage(android.view.View view);
    }

    interface Presenter extends BasePresenter {
        Boolean checkCredentials(String email,
                                 String password);
    }
}
