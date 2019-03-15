package org.example.admin.beans.authentication;

import lombok.Getter;
import lombok.Setter;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.example.application.infrastructure.util.transformation.ReflectionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.io.IOException;

/**
 * User data holder bean
 *
 * @author Kul'baka Alex
 */
@ManagedBean
@ViewScoped
@Getter
@Setter
public final class LoginBean {

    private final static Logger logger = LoggerFactory.getLogger(ReflectionUtil.getCurrentClassName());
    private final static String INDEX_PAGE = "index.xhtml";
    private final static String LOGIN_PAGE = "login.xhtml";

    private String username;
    private String password;

    public final void login() {
        final Subject subject = SecurityUtils.getSubject();
        final var token = new UsernamePasswordToken(getUsername(), getPassword());

        try {
            subject.login(token);
            FacesContext.getCurrentInstance().getExternalContext().redirect(INDEX_PAGE);
        } catch (UnknownAccountException e) {
            error("Unknown account");
            logger.error(e.getMessage(), e);
        } catch (IncorrectCredentialsException e) {
            error("Wrong password");
            logger.error(e.getMessage(), e);
        } catch (LockedAccountException e) {
            error("Locked account");
            logger.error(e.getMessage(), e);
        } catch (AuthenticationException | IOException e) {
            error("Unknown error: " + e.getMessage());
            logger.error(e.getMessage(), e);
        } finally {
            token.clear();
        }
    }

    public void logout() {
        final Subject subject = SecurityUtils.getSubject();
        try {
            subject.logout();
            FacesContext.getCurrentInstance().getExternalContext().redirect(LOGIN_PAGE);
        } catch (IOException e) {
            error("error," + e.getMessage());
            logger.error(e.getMessage(), e);
        }
    }

    private void error(final String msg) {
        FacesContext.getCurrentInstance()
                .addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, null));
    }
}
