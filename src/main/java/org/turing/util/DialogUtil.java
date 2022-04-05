package org.turing.util;

import org.turing.util.i18n.I18nComponentsUtil;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 * Diese Klasse dient der Erstellung von Standarddialogen über statische Zugriffsmethoden.
 *
 * @author Mohammad
 */
public final class DialogUtil {
    private DialogUtil() {
    }

    /**
     * Den Text, der im Informationsdialog angezeigt werden soll
     *
     * @param headerText Den Text, der im Informationsdialog angezeigt werden soll
     * @return Ein Alert-Objekt, das den Dialog darstellt, der angezeigt werden kann
     */
    public static Alert createInformationDialog(String headerText) {
        Alert informationDialog = new Alert(AlertType.INFORMATION);

        informationDialog.setTitle(I18nComponentsUtil.getDialogInformationTitle());
        informationDialog.setHeaderText(headerText);

        return informationDialog;
    }

    /**
     * Erzeugt einen Bestätigungsdialog, der dem Benutzer angezeigt werden kann.
     *
     * @param headerText Der Text, der im Bestätigungsdialog angezeigt werden soll
     * @return Ein Alert-Objekt, das den Dialog darstellt, der angezeigt werden kann
     */
    public static Alert createConfirmationDialog(String headerText) {
        Alert confirmationDialog = new Alert(AlertType.CONFIRMATION);

        confirmationDialog.setTitle(I18nComponentsUtil.getDialogConfirmationTitle());
        confirmationDialog.setHeaderText(headerText);

        return confirmationDialog;
    }

    /**
     * Erzeugt einen Fehlerdialog, der dem Benutzer angezeigt werden kann.
     *
     * @param title        Der Titel, der im Fehlerdialog angezeigt werden soll
     * @param headerText   Der Kopfzeilentext, der im Fehlerdialog angezeigt werden soll
     * @param errorMessage Die Fehlermeldung, die im Fehlerdialog angezeigt wird
     * @return Ein Alert-Objekt, das den Dialog darstellt, der angezeigt werden kann
     */
    public static Alert createErrorDialog(String title, String headerText, String errorMessage) {
        Alert errorDialog = new Alert(AlertType.ERROR);

        errorDialog.setTitle(title);
        errorDialog.setHeaderText(headerText);
        errorDialog.setContentText(errorMessage);

        return errorDialog;
    }
}
