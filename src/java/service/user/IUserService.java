/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service.user;

import model.User;
import service.IGeneralService;

/**
 *
 * @author tuana
 */
public interface IUserService extends IGeneralService<User> {

    User findByEmail(String email);

    User findByPhone(String phone);
}
