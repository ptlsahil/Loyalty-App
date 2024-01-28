package liuvasconcelos.costumerloyalty.mainPage;


import liuvasconcelos.costumerloyalty.BasePresenter;
import liuvasconcelos.costumerloyalty.BaseView;

public interface MainPageContract {
    interface View extends BaseView<Presenter> {
    }

    interface Presenter extends BasePresenter {
        String getUserName();
    }
}
