package org.example.admin.security;

import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.example.application.domain.entity.person.User;
import org.example.application.infrastructure.util.reflection.ReflectionUtil;
import org.example.service.service.person.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

/**
 * Authorization component that integrates with {@link IUserService} to fetch
 * user by login
 *
 * @author Kul'baka Alex
 */
public final class CDIRealm extends AuthorizingRealm {

    private static final Logger logger = LoggerFactory.getLogger(ReflectionUtil.getCurrentClassName());

    private final IUserService userService;

    public CDIRealm(final IUserService userService) {
        this.userService = userService;

        final HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        hashedCredentialsMatcher.setHashAlgorithmName("SHA-256");
        hashedCredentialsMatcher.setStoredCredentialsHexEncoded(true);
        setCredentialsMatcher(hashedCredentialsMatcher);
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
                    .orElseThrow(() -> new UnknownAccountException("No user found with name :" + username));

            return new SimpleAuthenticationInfo(username, password.toCharArray(), getName());
        } catch (final Exception e) {
            final String message = "There was an error while authenticating user :" + username;
            logger.error(message, e);
            throw new AuthenticationException(message, e);
        }
    }
}
