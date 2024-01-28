package liuvasconcelos.costumerloyalty.introductionPage;


public class IntroPagePresenter implements IntroPageContract.Presenter{

    private final IntroPageContract.View mIntroPageView;

    public IntroPagePresenter (IntroPageContract.View introPageView) {

        mIntroPageView = introPageView;
        mIntroPageView.setPresenter(this);
    }
}
