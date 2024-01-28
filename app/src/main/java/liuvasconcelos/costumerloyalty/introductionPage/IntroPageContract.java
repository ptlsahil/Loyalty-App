package liuvasconcelos.costumerloyalty.introductionPage;


import liuvasconcelos.costumerloyalty.BasePresenter;
import liuvasconcelos.costumerloyalty.BaseView;

public interface IntroPageContract {
    interface View extends BaseView<Presenter> {
        //fragment methods
        void goToLoginPage(android.view.View view);
        void goToRegistrationPage(android.view.View view);

    }
    interface Presenter extends BasePresenter {
        //presenter methods
    }
}
