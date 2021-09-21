package com.project.lebiton.dao.factory;

import com.project.lebiton.dao.LoginDaoInterface;
import com.project.lebiton.dao.impl.LoginDao;

public class FactoryLoginDAO {

    public static LoginDaoInterface criarLogindao() {
        return new LoginDao();
    }
}
