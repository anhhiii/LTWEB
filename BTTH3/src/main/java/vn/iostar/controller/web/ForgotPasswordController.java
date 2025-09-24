package vn.iostar.controller.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import vn.iostar.model.User;
import vn.iostar.service.UserService;
import vn.iostar.service.impl.UserServiceImpl;
import jakarta.mail.*;
import jakarta.mail.internet.*;
import java.io.IOException;
import java.util.Properties;
import java.util.UUID;

@WebServlet(urlPatterns = { "/forgotPassword", "/resetPassword" })
public class ForgotPasswordController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getServletPath();
        if (path.equals("/forgotPassword")) {
            req.getRequestDispatcher("/views/forgotPassword.jsp").forward(req, resp);
        } else if (path.equals("/resetPassword")) {
            String token = req.getParameter("token");
            if (userService.isValidResetToken(token)) {
                req.setAttribute("token", token);
                req.getRequestDispatcher("/views/resetPassword.jsp").forward(req, resp);
            } else {
                req.setAttribute("message", "Token không hợp lệ hoặc đã hết hạn!");
                req.getRequestDispatcher("/views/forgotPassword.jsp").forward(req, resp);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getServletPath();
        if (path.equals("/forgotPassword")) {
            String email = req.getParameter("email");
            User user = userService.findByEmail(email);

            if (user != null) {
                String token = UUID.randomUUID().toString();
                userService.saveResetToken(email, token, 60);
                String resetLink = req.getScheme() + "://" + req.getServerName() + ":" + req.getServerPort()
                        + req.getContextPath() + "/resetPassword?token=" + token;
                System.out.println("Reset link generated: " + resetLink);
                try {
                    sendResetEmail(email, resetLink);
                    req.setAttribute("message", "Liên kết đặt lại mật khẩu đã được gửi đến email của bạn!");
                } catch (MessagingException e) {
                    e.printStackTrace();
                    System.out.println("Failed to send email to: " + email + ". Error: " + e.getMessage());
                    req.setAttribute("message", "Lỗi khi gửi email: " + e.getMessage() + ". Vui lòng thử lại sau!");
                }
            } else {
                req.setAttribute("message", "Email không tồn tại trong hệ thống!");
            }
            req.getRequestDispatcher("/views/forgotPassword.jsp").forward(req, resp);
        } else if (path.equals("/resetPassword")) {
            String token = req.getParameter("token");
            String newPassword = req.getParameter("password");

            if (userService.isValidResetToken(token)) {
                String email = userService.getEmailByToken(token);
                userService.updatePassword(email, newPassword);
                req.setAttribute("message", "Đặt lại mật khẩu thành công!");
            } else {
                req.setAttribute("message", "Token không hợp lệ hoặc đã hết hạn!");
            }
            req.getRequestDispatcher("/views/resetPassword.jsp").forward(req, resp);
        }
    }

    private void sendResetEmail(String email, String resetLink) throws MessagingException {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.debug", "true"); // Bật debug để xem chi tiết

        // Thay bằng email và App Password thực tế
        final String username = "your-email@gmail.com"; // Ví dụ: myapp@gmail.com
        final String password = "your-app-password";    // App Password từ Google

        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
            message.setSubject("Đặt lại mật khẩu - Ứng dụng của bạn");
            String htmlContent = "<h3>Đặt lại mật khẩu</h3>"
                    + "<p>Nhấn vào liên kết dưới đây để đặt lại mật khẩu:</p>"
                    + "<a href=\"" + resetLink + "\">Đặt lại mật khẩu</a>"
                    + "<p>Liên kết này sẽ hết hạn sau 60 phút.</p>";
            message.setContent(htmlContent, "text/html; charset=UTF-8");
            System.out.println("Preparing to send email to: " + email + " with link: " + resetLink);
            Transport.send(message);
            System.out.println("Email sent successfully to: " + email);
        } catch (MessagingException e) {
            System.out.println("Failed to send email to: " + email + ". Error: " + e.getMessage());
            throw e;
        }
    }
}