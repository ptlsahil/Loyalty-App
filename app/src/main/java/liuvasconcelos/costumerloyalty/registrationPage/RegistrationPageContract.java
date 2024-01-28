package liuvasconcelos.costumerloyalty.registrationPage;


import liuvasconcelos.costumerloyalty.BasePresenter;
import liuvasconcelos.costumerloyalty.BaseView;

public interface RegistrationPageContract {
    interface View extends BaseView<Presenter> {
        void registerUser(android.view.View view);
    }
    interface Presenter extends BasePresenter {
        Boolean registerUser(String name, String cpf,
                             String phoneNumber, String email,
                             String password);
    }
}
