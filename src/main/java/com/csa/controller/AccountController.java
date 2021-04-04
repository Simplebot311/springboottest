package com.csa.controller;

import com.csa.dao.AccountDao;
import com.csa.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Date;
import java.util.List;

/**
 * @author yufeng1900
 * @create 2021-04-03 19:15
 */
@Controller
public class AccountController {

    @Autowired
    private AccountDao account;


    @RequestMapping("/quick")
    @ResponseBody
    public String quick(){
        return "SpringBoot 访问成功！";
    }

    //不用Rest风格
    //查询所有
    @RequestMapping("/account/all")
    @ResponseBody
    public List<Account> findAll() {
        return account.findAll();
    }

    //保存account对象
    @RequestMapping("/account/save")
    public void saveAccount(@RequestBody Account account) {
        this.account.insert(account);
    }

    @RequestMapping("/account/transfer")
    public void transfer(@RequestParam("remitterId") String remitterId,
                         @RequestParam("remitteeId") String remitteeId,
                         @RequestParam("money") int money) {
        Account remitterAccount = account.selectByPrimaryKey(remitterId);
        Account remitteeAccount = account.selectByPrimaryKey(remitteeId);

        remitterAccount.setMoney(remitterAccount.getMoney()-money);
        remitteeAccount.setMoney(remitteeAccount.getMoney()+money);

        remitteeAccount.setUpdateTime(new Date(System.currentTimeMillis()));
        remitteeAccount.setUpdateTime(new Date(System.currentTimeMillis()));

        account.updateByPrimaryKey(remitterAccount);
        account.updateByPrimaryKey(remitteeAccount);

    }
}
