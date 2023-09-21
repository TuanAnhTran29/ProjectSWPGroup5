/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import sender.EmailUtility;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.Base64;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Session;
import model.Account;
import model.Customer;
import model.Role;
import model.User;
import service.account.AccountService;
import service.account.IAccountService;
import service.customer.CustomerService;
import service.customer.ICustomerService;
import service.user.IUserService;
import service.user.UserService;

/**
 *
 * @author tuana
 */
@WebServlet(name = "AccountController", urlPatterns = {"/AccountController"})
public class AccountController extends HttpServlet {

    private static IAccountService accountService = new AccountService();
    private static IUserService userService = new UserService();
    private static ICustomerService customerService = new CustomerService();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AccountController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AccountController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        switch (action) {
            case "registerPage":
                showRegisterPage(request, response);
                break;
            case "verifyPage":
                showVerifyEmailPage(request, response);
                break;
            case "loginPage":
                showLoginPage(request, response);
                break;
            case "sendCodeAgain":
                sendCodeAgain(request, response);
                break;
            case "sendCodeForgotAgain":
                sendCodeForgotAgain(request, response);
                break;
            case "forgotPage":
                showForgotPage(request, response);
                break;
            default:
                throw new AssertionError();
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action) {
            case "register":
                register(request, response);
                break;
            case "verifyEmail":
                verifyEmail(request, response);
                break;
            case "createAccount":
                createAccount(request, response);
                break;
            case "forgotPassword":
                forgotPassword(request, response);
                break;
            case "login":
                login(request, response);
                break;
            case "verifyForgotPassword":
                verifyForgotPassword(request, response);
                break;
            case "updateNewPassword":
                updateNewPassword(request, response);
                break;
            default:
                throw new AssertionError();
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void showRegisterPage(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher rd = request.getRequestDispatcher("account/register.jsp");
        try {
            rd.forward(request, response);
        } catch (ServletException ex) {
            Logger.getLogger(AccountController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AccountController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void showVerifyEmailPage(HttpServletRequest request, HttpServletResponse response) {
        getRequestDispatch(request, response, "account/verify.jsp");
    }

    private void showLoginPage(HttpServletRequest request, HttpServletResponse response) {
        getRequestDispatch(request, response, "account/login.jsp");
    }

    private void showForgotPage(HttpServletRequest request, HttpServletResponse response) {
        getRequestDispatch(request, response, "account/forgot_password.jsp");
    }

    private void sendCodeAgain(HttpServletRequest request, HttpServletResponse response) {
        request.getSession().removeAttribute("code");
        HttpSession session = request.getSession();
        String email = (String) session.getAttribute("email");

        String code = EmailUtility.getRandomCode();
        EmailUtility.sendEmail(email, code);

        session.setAttribute("code", code);

        getRequestDispatch(request, response, "account/verify_email.jsp");
    }

    private void sendCodeForgotAgain(HttpServletRequest request, HttpServletResponse response) {
        request.getSession().removeAttribute("code");
        HttpSession session = request.getSession();
        String email = (String) session.getAttribute("email");

        String code = EmailUtility.getRandomCode();
        EmailUtility.sendEmail(email, code);

        session.setAttribute("code", code);

        getRequestDispatch(request, response, "account/verify_forgot_password.jsp");
    }

    private void register(HttpServletRequest request, HttpServletResponse response) {
        String email = request.getParameter("email");
        if (!email.matches("^[a-z][a-z0-9_]{5,32}@[a-z0-9]{2,}(\\.[a-z0-9]{2,4}){1,2}$")) {
            request.setAttribute("message", "Wrong email format!");
            getRequestDispatch(request, response, "account/register.jsp");
        } else {
            if (userService.findByEmail(email) != null) {
                request.setAttribute("message", "Email used!");
                getRequestDispatch(request, response, "account/register.jsp");
            } else {

                String code = EmailUtility.getRandomCode();
                EmailUtility.sendEmail(email, code);

                HttpSession session = request.getSession();
                session.setAttribute("code", code);
                session.setAttribute("email", email);

                getRequestDispatch(request, response, "account/verify_email.jsp");

            }
        }

    }

    private void verifyEmail(HttpServletRequest request, HttpServletResponse response) {
        String code = request.getParameter("code");

        String verify_code = (String) request.getSession().getAttribute("code");
        request.getSession().removeAttribute("code");
        
        if (code.equals(verify_code)) {
            getRequestDispatch(request, response, "account/create_account.jsp");
        } else {
            request.setAttribute("message", "Verification failed!");
            getRequestDispatch(request, response, "account/register.jsp");
        }
    }

    public void getRequestDispatch(HttpServletRequest request, HttpServletResponse response, String view) {
        try {
            RequestDispatcher rd = request.getRequestDispatcher(view);
            rd.forward(request, response);
        } catch (ServletException ex) {
            Logger.getLogger(AccountController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AccountController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void createAccount(HttpServletRequest request, HttpServletResponse response) {
        String firstName = request.getParameter("fname");
        String lastName = request.getParameter("lname");
        String username = request.getParameter("username");

        request.setAttribute("fname", firstName);
        request.setAttribute("lname", lastName);
        request.setAttribute("username", username);

        if (accountService.findByUsername(username) != null) {
            request.setAttribute("message", "Username existed!");
            getRequestDispatch(request, response, "account/create_account.jsp");
        } else {
            String phone = request.getParameter("phone");
            if (!phone.matches("(84|0[3|5|7|8|9])+([0-9]{8})")) {
                request.setAttribute("message", "Wrong phone format!");
                getRequestDispatch(request, response, "account/create_account.jsp");
            } else {
                if (userService.findByPhone(phone) != null) {
                    request.setAttribute("message", "Phone used!");
                    getRequestDispatch(request, response, "account/create_account.jsp");
                } else {
                    String password = request.getParameter("password");
                    String confirm = request.getParameter("cpassword");
                    if (!password.equals(confirm)) {
                        request.setAttribute("message", "Password and confirm password must be matched!");
                        getRequestDispatch(request, response, "account/create_account.jsp");
                    } else if (!password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$")) {
                        request.setAttribute("message", "Password must be longer than 8 characters and contain ai least uppercase, lowercase and number");
                        getRequestDispatch(request, response, "account/create_account.jsp");
                    } else {
                        String fullName = firstName + " " + lastName;

                        byte[] encrypt = password.getBytes();

                        Account account = new Account(username, Base64.getEncoder().encodeToString(encrypt), true);
                        accountService.add(account);

                        account = accountService.findByUsername(username);

                        HttpSession session = request.getSession();
                        String email = (String) session.getAttribute("email");

                        User user = new User(fullName, "", "", phone, email, 1, "C:\\Users\\tuana\\OneDrive\\Máy tính\\ProjectSWP\\ProjectSWP\\image\\defaultavatar.png", 0, account.getAccountID(), 7);
                        userService.add(user);
                        user = userService.findByEmail(email);

                        Customer customer = new Customer(user.getUserID(), "", "");
                        customerService.add(customer);

                        request.setAttribute("message", "Register success!");
                        getRequestDispatch(request, response, "account/login.jsp");
                    }
                }
            }
        }
    }

    private void forgotPassword(HttpServletRequest request, HttpServletResponse response) {
        String email = request.getParameter("email");
        String code = EmailUtility.getRandomCode();

        HttpSession session = request.getSession();
        session.setAttribute("code", code);
        session.setAttribute("email", email);

        EmailUtility.sendEmail(email, code);

        getRequestDispatch(request, response, "account/verify_forgot_password.jsp");
    }

    private void login(HttpServletRequest request, HttpServletResponse response) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        request.setAttribute("username", username);

        if (accountService.findByUsername(username) != null) {
            if (accountService.findByUsername(username).getPassword().equals(Base64.getEncoder().encodeToString(password.getBytes()))) {
                request.setAttribute("message", "Login successfully!");
                request.getSession().setAttribute("account", accountService.findByUsername(username));
                getRequestDispatch(request, response, "account/login.jsp");
            } else {
                request.setAttribute("message", "Username or password is incorrect!");
                getRequestDispatch(request, response, "account/login.jsp");
            }
        } else {
            request.setAttribute("message", "Account is not exist!");
            getRequestDispatch(request, response, "account/login.jsp");
        }
    }

    private void verifyForgotPassword(HttpServletRequest request, HttpServletResponse response) {
        String code = request.getParameter("code");

        String verify_code = (String) request.getSession().getAttribute("code");
        request.getSession().removeAttribute("code");
        request.getSession().removeAttribute("email");

        if (code.equals(verify_code)) {
            getRequestDispatch(request, response, "account/new_password.jsp");
        } else {
            request.setAttribute("message", "Verification failed!");
            getRequestDispatch(request, response, "account/forgot_password.jsp");
        }
    }

    private void updateNewPassword(HttpServletRequest request, HttpServletResponse response) {
        String password = request.getParameter("password");
        String confirm = request.getParameter("cpassword");
        if (!password.equals(confirm)) {
            request.setAttribute("message", "Password and confirm password must be matched!");
            getRequestDispatch(request, response, "account/new_password.jsp");
        } else if (!password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$")) {
            request.setAttribute("message", "Password must be longer than 8 characters and contain ai least uppercase, lowercase and number");
            getRequestDispatch(request, response, "account/new_password.jsp");
        } else {
            request.setAttribute("message", "Update password successfully!");
            getRequestDispatch(request, response, "account/login.jsp");
        }
    }

}
