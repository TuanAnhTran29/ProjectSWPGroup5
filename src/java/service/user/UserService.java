/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.user;

import connection.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import model.Account;
import model.User;

/**
 *
 * @author tuana
 */
public class UserService implements IUserService {

    private final Connection connection = DBContext.getConnection();

    private static final String INSERT_USER = "INSERT INTO [dbo].[Users]\n"
            + "           ([full_name]\n"
            + "           ,[address]\n"
            + "           ,[date_of_birth]\n"
            + "           ,[phone]\n"
            + "           ,[gmail]\n"
            + "           ,[gender]\n"
            + "           ,[avartar_link]\n"
            + "           ,[account_id]\n"
            + "           ,[role_id]\n"
            + "           ,[salary])\n"
            + "     VALUES\n"
            + "           (?"
            + "           ,?"
            + "           ,?"
            + "           ,?"
            + "           ,?"
            + "           ,?"
            + "           ,?"
            + "           ,?"
            + "           ,?"
            + "           ,?)";
    private static final String FIND_USER_BY_EMAIL = "SELECT * FROM USERS WHERE gmail= ?";

    private static final String FIND_USER_BY_PHONE = "SELECT * FROM USERS WHERE phone= ?";

    @Override
    public void add(User user) {
        try {
            PreparedStatement pre = connection.prepareStatement(INSERT_USER);
            pre.setString(1, user.getFullName());
            pre.setString(2, user.getAddress());
            pre.setString(3, user.getDob());
            pre.setString(4, user.getPhone());
            pre.setString(5, user.getEmail());
            pre.setInt(6, user.getGender());
            pre.setString(7, user.getAvartar());
            pre.setInt(8, user.getAccountID());
            pre.setInt(9, user.getRoleID());
            pre.setFloat(10, user.getSalary());

            pre.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public User findById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(int id, User t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public User findByEmail(String email) {
        User user = null;
        try {
            PreparedStatement pre = connection.prepareStatement(FIND_USER_BY_EMAIL);
            pre.setString(1, email);

            ResultSet rs = pre.executeQuery();

            while (rs.next()) {
                int user_id = rs.getInt(1);
                String fullName = rs.getString(2);
                String address = rs.getString(3);
                String dob = rs.getString(4);
                String phone = rs.getString(5);
                String user_email = rs.getString(6);
                int gender = rs.getInt(7);
                String avartar = rs.getString(8);
                int account_id = rs.getInt(9);
                int role_id = rs.getInt(10);
                float salary = rs.getFloat(11);

                user = new User(user_id, fullName, address, dob, phone, user_email, gender, avartar, salary, account_id, role_id);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public User findByPhone(String phone) {
        User user = null;
        try {
            PreparedStatement pre = connection.prepareStatement(FIND_USER_BY_PHONE);
            pre.setString(1, phone);

            ResultSet rs = pre.executeQuery();

            while (rs.next()) {
                int user_id = rs.getInt(1);
                String fullName = rs.getString(2);
                String address = rs.getString(3);
                String dob = rs.getString(4);
                String phone_number = rs.getString(5);
                String user_email = rs.getString(6);
                int gender = rs.getInt(7);
                String avartar = rs.getString(8);
                int account_id = rs.getInt(9);
                int role_id = rs.getInt(10);
                float salary = rs.getFloat(11);

                user = new User(user_id, fullName, address, dob, phone_number, user_email, gender, avartar, salary, account_id, role_id);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

}
