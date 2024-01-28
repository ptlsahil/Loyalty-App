package liuvasconcelos.costumerloyalty.forgetPasswordPage;


public class ForgetPasswordPagePresenter implements ForgetPasswordPageContract.Presenter{

    private final ForgetPasswordPageContract.View mForgetPasswordPageView;

    public ForgetPasswordPagePresenter(ForgetPasswordPageContract.View forgetPasswordPageView) {

        mForgetPasswordPageView = forgetPasswordPageView;
        mForgetPasswordPageView.setPresenter(this);
    }
}
