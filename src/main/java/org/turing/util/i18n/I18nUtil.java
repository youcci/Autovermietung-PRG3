package org.turing.util.i18n;

import lombok.Getter;

import java.util.ResourceBundle;

/**
 * Internationalisierungsdienstleistungsklasse, die verschiedene Ressourcenbündel bereitstellt.
 *
 * @author Youcef Wippert
 */
public final class I18nUtil {
    // Bundle base names
    private static final String I18N_BASENAME_STRINGS = "bundles/strings";
    private static final String I18N_BASENAME_COMPONENTS = "bundles/components";

    private I18nUtil() {
    }

    @Getter
    private static ResourceBundle resourceBundleStrings;

    @Getter
    private static ResourceBundle resourceBundleComponents;

    static {
        resourceBundleStrings = ResourceBundle.getBundle(I18N_BASENAME_STRINGS);
        resourceBundleComponents = ResourceBundle.getBundle(I18N_BASENAME_COMPONENTS);
    }
}
