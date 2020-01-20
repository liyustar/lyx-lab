package com.lyx.lab.las.service.impl;

import com.google.common.base.Preconditions;
import com.lyx.lab.las.mapper.LasAccountMapper;
import com.lyx.lab.las.model.LasAccount;
import com.lyx.lab.las.model.LasAccountExample;
import com.lyx.lab.las.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * @Description AccountServiceImpl
 * @Author liyuxing
 * @Date 2020-01-19
 */
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private LasAccountMapper accountMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public LasAccount addAccount(String accCode, double amt) {
        Optional<LasAccount> accountOpt = Optional.ofNullable(accountMapper.selectByPrimaryKey(accCode));

        LasAccount account = accountOpt.orElse(new LasAccount());
        account.setAccCode(accCode);
        account.setAmt(amt);

        if (accountOpt.isPresent()) {
            int ret = updateByPrimeKeyWithVersionLock(account);
            Preconditions.checkState(1 == ret, "事务提交失败，回滚");
        } else {
            accountMapper.insertSelective(account);
        }
        return account;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void adjustAmt(String accCode, double deltaAmt) {
        LasAccount account = getAccount(accCode);
        account.setAmt(account.getAmt() + deltaAmt);

        int ret = updateByPrimeKeyWithVersionLock(account);
        Preconditions.checkState(1 == ret, "事务提交失败，回滚");
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public void transAccountAmt(String fromAccCode, String toAccCode, double amt) {
        LasAccount fromAcct = getAccount(fromAccCode);
        LasAccount toAcct = getAccount(toAccCode);

        fromAcct.setAmt(fromAcct.getAmt() - amt);
        toAcct.setAmt(toAcct.getAmt() + amt);

        int retFrom = updateByPrimeKeyWithVersionLock(fromAcct);
        int retTo = updateByPrimeKeyWithVersionLock(toAcct);
        Preconditions.checkState(2 == retFrom + retTo, "事务提交失败，回滚");
    }

    @Override
    public LasAccount getAccount(String accCode) {
        return Optional.ofNullable(accountMapper.selectByPrimaryKey(accCode))
                .orElseThrow(() -> new IllegalArgumentException("无此账号:" + accCode));
    }

    private int updateByPrimeKeyWithVersionLock(LasAccount account) {
        LasAccountExample example = new LasAccountExample();
        LasAccountExample.Criteria criteria = example.createCriteria();
        criteria.andAccCodeEqualTo(account.getAccCode())
                .andVersionEqualTo(account.getVersion());
        account.setVersion(account.getVersion() + 1);
        return accountMapper.updateByExampleSelective(account, example);
    }
}
