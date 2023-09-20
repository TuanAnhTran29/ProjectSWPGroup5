/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.user;

import connection.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
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

    @Override
    public void add(User user) {
        try {
            PreparedStatement pre= connection.prepareStatement(INSERT_USER);
            pre.setString(1, user.getFullName());
            pre.setString(2, user.getAddress());
            pre.setString(3, user.getDob());
            pre.setString(4, user.getPhone());
            pre.setString(5, user.getEmail());
            pre.setString(6, user.getGender());
            pre.setString(7, "C:\\Users\\tuana\\OneDrive\\Máy tính\\ProjectSWP\\ProjectSWP\\image\\defaultavatar.png");
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

}
