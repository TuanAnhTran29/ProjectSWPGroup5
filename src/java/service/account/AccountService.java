/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.account;

import connection.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import model.Account;

/**
 *
 * @author tuana
 */
public class AccountService implements IAccountService{
    private final Connection connection= DBContext.getConnection();
    
    private final String INSERT_ACCOUNT= "INSERT INTO [dbo].[Account]\n" +
"           ([username]\n" +
"           ,[password]\n" +
"           ,[status])\n" +
"     VALUES\n" +
"           (?" +
"           ,?" +
"           ,?)";
    
    private final String UPDATE_STATUS= "update Account set status= ?";
    

    @Override
    public void add(Account account) {
        try {
            PreparedStatement pre= connection.prepareStatement(INSERT_ACCOUNT);
            pre.setString(1, account.getUsername());
            pre.setString(2, account.getPassword());
            pre.setBoolean(3, account.getStatus());
            
            pre.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Account> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Account findById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(int id, Account t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void updateAccountStatus(boolean status) {
        try {
            PreparedStatement pre= connection.prepareStatement(UPDATE_STATUS);
            if (status==true) {
                pre.setInt(1, 1);
            }else{
                pre.setInt(1, 0);
            }
            
            pre.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    
}
