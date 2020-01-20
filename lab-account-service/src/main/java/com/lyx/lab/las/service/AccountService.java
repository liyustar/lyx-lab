package com.lyx.lab.las.service;

import com.lyx.lab.las.model.LasAccount;

/**
 * @Description AccountService
 * @Author liyuxing
 * @Date 2020-01-19
 */
public interface AccountService {

    LasAccount addAccount(String accCode, double amt);

    void adjustAmt(String accCode, double deltaAmt);

    void transAccountAmt(String fromAcc, String toAcc, double amt);

    LasAccount getAccount(String accCode);
}
