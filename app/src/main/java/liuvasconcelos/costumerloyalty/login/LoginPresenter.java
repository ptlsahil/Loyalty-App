package liuvasconcelos.costumerloyalty.login;


import android.content.Context;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;

import liuvasconcelos.costumerloyalty.registrationPage.DAO.UserDAO;

public class LoginPresenter implements LoginContract.Presenter{

    private final LoginContract.View mLoginView;
    private Context mContext;
    private SQLiteDatabase mDatabase;
    private UserDAO userDAO;
    private SharedPreferences.Editor mEditor;

    public LoginPresenter (LoginContract.View loginView,
                           Context context, SQLiteDatabase database,
                           SharedPreferences.Editor editor) {
        this.mContext = context;
        this.mDatabase = database;
        this.mEditor = editor;
        mLoginView = loginView;
        mLoginView.setPresenter(this);
        userDAO = new UserDAO(mContext, mDatabase);
    }

    @Override
    public Boolean checkCredentials(String email,
                                    String password) {
        Boolean userFound = userDAO.hasUser(email, password);
        String userName = userDAO.getUserName();
        if (userFound) {
            mEditor.putString("userName", userName);
            mEditor.apply();
        }
        return userFound;
    }

}
