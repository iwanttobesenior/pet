package org.example.admin.security;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.example.application.domain.entity.person.User;
import org.example.application.infrastructure.util.transformation.ReflectionUtil;
import org.example.service.service.person.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

/**
 * Custom
 *
 * @author Kul'baka Alex
 */
public class CDIRealm extends AuthorizingRealm {

    private static final Logger logger = LoggerFactory.getLogger(ReflectionUtil.getCurrentClassName());
    private final IUserService userService;

    public CDIRealm(final IUserService userService) {
        this.userService = userService;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(final PrincipalCollection principals) {
        return new SimpleAccount();
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(final AuthenticationToken token) throws AuthenticationException {
        final UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
        final String username = usernamePasswordToken.getUsername();

        try {
            String password = Optional.ofNullable(username).flatMap(name -> userService.findByUsername(username)).map(User::getPassword)
                    .orElseThrow(() -> new UnknownAccountException("No user found with name " + username));

            return new SimpleAuthenticationInfo(username, password.toCharArray(), getName());
        } catch (final Exception e) {
            String message = "There was an error while authenticating user " + username;
            logger.error(message, e);
            throw new AuthenticationException(message, e);
        }
    }
}
