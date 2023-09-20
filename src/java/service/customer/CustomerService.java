/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.customer;

import connection.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import model.Customer;

/**
 *
 * @author tuana
 */
public class CustomerService implements ICustomerService {

    private final Connection connection = DBContext.getConnection();

    private static final String INSERT_CUSTOMER = "INSERT INTO [dbo].[Customer]\n"
            + "           ([user_id]\n"
            + "           ,[region]\n"
            + "           ,[country])\n"
            + "     VALUES\n"
            + "           (?"
            + "           ,?"
            + "           ,?)";

    @Override
    public void add(Customer customer) {
        try {
            PreparedStatement pre = connection.prepareStatement(INSERT_CUSTOMER);
            pre.setInt(1, customer.getUserID());
            pre.setString(2, customer.getRegion());
            pre.setString(3, customer.getCountry());

            pre.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Customer> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Customer findById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(int id, Customer t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
