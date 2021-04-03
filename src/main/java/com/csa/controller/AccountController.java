package com.csa.controller;

import com.csa.domain.Account;
import com.csa.domain.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author yufeng1900
 * @create 2021-04-03 19:15
 */
public class AccountController {
    @Autowired
    private AccountService accountService;

    // 不用Rest风格
    //查询所有
    @RequestMapping("/account/all")
    public List<Account> findAll() {
        return accountService.findAll();
    }

    //保存account对象
    @RequestMapping("/account/save")
    public void saveAccount(@RequestBody Account account) {
    }

    @RequestMapping("/account/transfer")
    public void transfer(@RequestParam("remitterId") String remitterId,
                         @RequestParam("remitteeId") String remitteeId,
                         @RequestParam("money") int money) {

    }
}
