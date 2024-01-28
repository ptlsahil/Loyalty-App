package liuvasconcelos.costumerloyalty.forgetPasswordPage;


import liuvasconcelos.costumerloyalty.BasePresenter;
import liuvasconcelos.costumerloyalty.BaseView;

public interface ForgetPasswordPageContract {
    interface View extends BaseView<Presenter> {
        void sendEmail(android.view.View view);
    }
    interface Presenter extends BasePresenter {
        //presenter methods
    }
}
