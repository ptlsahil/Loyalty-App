package liuvasconcelos.costumerloyalty.registrationPage;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import liuvasconcelos.costumerloyalty.registrationPage.DAO.UserDAO;

public class RegistrationPagePresenter implements RegistrationPageContract.Presenter{

    private final RegistrationPageContract.View mRegistrationPageView;
    private Context mContext;
    private SQLiteDatabase mDatabase;
    private UserDAO userDAO;

    public RegistrationPagePresenter(RegistrationPageContract.View registrationPageView,
                                     Context context, SQLiteDatabase database) {

        this.mContext = context;
        this.mDatabase = database;
        mRegistrationPageView = registrationPageView;
        mRegistrationPageView.setPresenter(this);
        userDAO = new UserDAO(mContext, mDatabase);
    }

    @Override
    public Boolean registerUser(String name, String cpf,
                                String phoneNumber, String email,
                                String password) {

        return userDAO.insert(name, cpf, phoneNumber, email, password);
    }
}
