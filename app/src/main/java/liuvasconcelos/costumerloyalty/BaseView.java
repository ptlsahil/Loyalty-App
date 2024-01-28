package liuvasconcelos.costumerloyalty;

public interface BaseView<T extends BasePresenter> {
    void showLocalLoader();
    void hideLocalLoader();
    void setPresenter(T presenter);
}
