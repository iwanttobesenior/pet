package org.example.admin.security;

import org.apache.shiro.mgt.RealmSecurityManager;
import org.apache.shiro.web.env.EnvironmentLoaderListener;
import org.apache.shiro.web.env.WebEnvironment;
import org.example.service.service.person.IUserService;

import javax.inject.Inject;
import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;

@WebListener
public class CdiEnvironmentLoaderListener extends EnvironmentLoaderListener {

    @Inject
    private IUserService userService;

    @Override
    protected WebEnvironment createEnvironment(final ServletContext servletContext) {
        WebEnvironment webEnvironment = super.createEnvironment(servletContext);
        RealmSecurityManager realmSecurityManager = (RealmSecurityManager) webEnvironment.getSecurityManager();
        realmSecurityManager.setRealm(new CDIRealm(userService));
        return webEnvironment;
    }
}
