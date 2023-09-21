/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.account;

import connection.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import model.Account;
import model.Role;
import model.User;

/**
 *
 * @author tuana
 */
public class AccountService implements IAccountService {

    private static final Connection connection = DBContext.getConnection();

    private final String INSERT_ACCOUNT = "INSERT INTO [dbo].[Account]\n"
            + "           ([username]\n"
            + "           ,[password]\n"
            + "           ,[status])\n"
            + "     VALUES\n"
            + "           (?\n"
            + "           ,?\n"
            + "           ,?)";

    private final String UPDATE_STATUS = "update Account set status= ?";

    private final String FIND_ACCOUNT_BY_USERNAME = "select * from Account where username=?";

//    private final String FIND_ACCOUNT_BY_EMAIL = "SELECT * FROM ACCOUNT a join USERS b"
//            + "ON a.account_id= b.account_id WHERE b.gmail= ?";
//    private final String FIND_ACCOUNT_BY_PHONE = "SELECT * FROM ACCOUNT a join USERS b"
//            + "ON a.account_id= b.account_id WHERE a.phone= ?";
    @Override
    public void add(Account account) {
        try {
            PreparedStatement pre = connection.prepareStatement(INSERT_ACCOUNT);
            
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
            PreparedStatement pre = connection.prepareStatement(UPDATE_STATUS);
            if (status == true) {
                pre.setInt(1, 1);
            } else {
                pre.setInt(1, 0);
            }

            pre.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Account findByUsername(String username) {
        Account account = null;
        try {
            PreparedStatement pre = connection.prepareStatement(FIND_ACCOUNT_BY_USERNAME);
            pre.setString(1, username);

            ResultSet rs = pre.executeQuery();

            while (rs.next()) {
                int accountID = rs.getInt(1);
                String user_name = rs.getString(2);
                String password = rs.getString(3);
                boolean status= rs.getBoolean(4);
                
                account = new Account(accountID, user_name, password, status);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return account;
    }

//    @Override
//    public Account findByEmail(String email) {
//        Account account = null;
//        try {
//            PreparedStatement pre = connection.prepareStatement(FIND_ACCOUNT_BY_EMAIL);
//            pre.setString(1, email);
//
//            ResultSet rs = pre.executeQuery();
//
//            while (rs.next()) {
//                int accountID = rs.getInt(1);
//                String user_name = rs.getString(2);
//                String password = rs.getString(3);
//                int status = rs.getInt(4);
//
//                account = new Account(accountID, user_name, password, status);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return account;
//    }
//    @Override
//    public Account findByPhone(String phone) {
//        Account account = null;
//        try {
//            PreparedStatement pre = connection.prepareStatement(FIND_ACCOUNT_BY_PHONE);
//            pre.setString(1, phone);
//
//            ResultSet rs = pre.executeQuery();
//
//            while (rs.next()) {
//                int accountID = rs.getInt(1);
//                String user_name = rs.getString(2);
//                String password = rs.getString(3);
//                int status = rs.getInt(4);
//
//                account = new Account(accountID, user_name, password, status);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return account;
//    }
}
