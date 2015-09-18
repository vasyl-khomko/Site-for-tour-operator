package toursite.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import toursite.dao.NotConfirmedUserDAO;
import toursite.dao.UserDAO;
import toursite.model.NotConfirmedUser;
import toursite.model.User;

import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * Created by Vasyl on 31.05.2015.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private NotConfirmedUserDAO notConfirmedUserDAO;

    @Transactional
    public void save(User user) {
        userDAO.save(user);
    }

    @Transactional
    public void update(User user) {
        userDAO.update(user);
    }

    @Transactional
    public void save(NotConfirmedUser user) {
        notConfirmedUserDAO.save(user);
    }

    @Transactional
    public User findByUsername(String username) {
        return userDAO.findByUsername(username);
    }

    @Transactional
    public List<NotConfirmedUser> findAllNotConfirmedUser(int firstResult, int maxResult) {
        return notConfirmedUserDAO.findAll(firstResult, maxResult);
    }

    @Transactional
    public NotConfirmedUser findByEmail(String email) {
        return notConfirmedUserDAO.findByEmail(email);
    }

    @Transactional
    public void register(NotConfirmedUser user) {
        notConfirmedUserDAO.save(user);
        user = notConfirmedUserDAO.findByEmail(user.getEmail());
        System.out.println("user.getEmail()" + user.getEmail());
        System.out.println("user.getActivationCode()" + user.getActivationCode());
        sendEmailMessage(user.getEmail(), user.getActivationCode());
    }

    public void confirm(int userId) {
        NotConfirmedUser notConfirmedUser = notConfirmedUserDAO.findById(userId);
        notConfirmedUserDAO.delete(notConfirmedUser);
        User user = new User();
        user.setUsername(notConfirmedUser.getUsername());
        user.setPassword(notConfirmedUser.getPassword());
        user.setFirstName(notConfirmedUser.getFirstName());
        user.setLastName(notConfirmedUser.getLastName());
        user.setEmail(notConfirmedUser.getEmail());
        user.setPhone(notConfirmedUser.getPhone());
        user.setAddress(notConfirmedUser.getAddress());
        user.setBirthDate(notConfirmedUser.getBirthDate());
        user.setRole(notConfirmedUser.getRole());
        userDAO.save(user);
    }


    @Transactional
    public void activate(String activationCode) {
        NotConfirmedUser notConfirmedUser = notConfirmedUserDAO.findByActivationCode(activationCode);
        if(notConfirmedUser.getRole().getName().equals("Користувач")) {
            User user = new User();
            user.setUsername(notConfirmedUser.getUsername());
            user.setPassword(notConfirmedUser.getPassword());
            user.setFirstName(notConfirmedUser.getFirstName());
            user.setLastName(notConfirmedUser.getLastName());
            user.setEmail(notConfirmedUser.getEmail());
            user.setPhone(notConfirmedUser.getPhone());
            user.setAddress(notConfirmedUser.getAddress());
            user.setBirthDate(notConfirmedUser.getBirthDate());
            user.setRole(notConfirmedUser.getRole());
            userDAO.save(user);
            notConfirmedUserDAO.delete(notConfirmedUser);
        }
        else {
            notConfirmedUser.setActivated(true);
            notConfirmedUserDAO.update(notConfirmedUser);
        }
    }

    public void sendEmailMessage(String email, String activationCode) {
        final String username = "homko.wasyl@gmail.com";
        final String password = "synson1994gmail";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        javax.mail.Session session = javax.mail.Session.getInstance(props,
                new javax.mail.Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("homko.wasyl@gmail.com"));
            message.setRecipient(Message.RecipientType.TO,
                    new InternetAddress(email));
            message.setSubject("Testing Subject");
            message.setText("http://localhost:8081/activate?activation_code="+activationCode);

            Transport.send(message);

            System.out.println("javax.mail: send message to " + email);

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
