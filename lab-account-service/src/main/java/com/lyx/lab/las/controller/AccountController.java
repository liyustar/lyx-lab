package com.lyx.lab.las.controller;

import com.lyx.lab.core.bean.ResponseObj;
import com.lyx.lab.las.model.LasAccount;
import com.lyx.lab.las.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Description AccountController
 * @Author liyuxing
 * @Date 2020-01-19
 */
@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping
    public ResponseObj<LasAccount> addAccount(@RequestParam String accCode,
                                              @RequestParam Double amt) {
        LasAccount account = accountService.addAccount(accCode, amt);
        return ResponseObj.success(account);
    }

    @PutMapping("/transTo")
    public ResponseObj<LasAccount> addAccount(@RequestParam String fromAccCode,
                                              @RequestParam String toAccCode,
                                              @RequestParam Double amt) {
        accountService.transAccountAmt(fromAccCode, toAccCode, amt);
        return ResponseObj.success();
    }
}
