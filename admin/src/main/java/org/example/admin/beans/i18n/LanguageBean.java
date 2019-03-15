package org.example.admin.beans.i18n;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.util.Locale;

/**
 * Keeps selected language for the current user
 *
 * @author Kul'baka Alex
 */
@ManagedBean(name = "language")
@SessionScoped
public class LanguageBean {

    private Locale locale;

    /**
     * Get default user locale
     */
    @PostConstruct
    public void init() {
        locale = FacesContext.getCurrentInstance().getExternalContext().getRequestLocale();
    }

    public Locale getLocale() {
        return locale;
    }

    public void setLanguage(final String language) {
        locale = new Locale(language);
    }
}
