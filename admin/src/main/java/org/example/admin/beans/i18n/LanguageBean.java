package org.example.admin.beans.i18n;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Locale;

/**
 * Keeps selected language for the current user
 *
 * @author Kul'baka Alex
 */
@Named(value = "language")
@SessionScoped
public class LanguageBean implements Serializable {

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
