package org.turing.controller;

import org.turing.model.BaseEntity;
import org.turing.service.GenericService;
import org.turing.util.DialogUtil;
import org.turing.util.i18n.I18nComponentsUtil;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import lombok.Getter;
import lombok.Setter;

import java.util.Optional;

/**
 * Super Controller für alle anderen EditView Controller
 *
 * @author Youcef Wippert
 */
public abstract class GenericEditViewController<T extends BaseEntity> {
    GenericService<T> service;
    T entity;

    @Setter
    Stage modalStage;

    @Getter
    boolean applyClicked = false;

    /**
     * Funktion für Tastaturbefehle in einer EditView
     *
     * @param event Das eingetretene Ereignis, das auch die gedrückte Taste enthält.
     */
    public void handleKeyEvent(KeyEvent event) {
        KeyCode key = event.getCode();

        if (key == KeyCode.ESCAPE) {
            handleCancelButtonClicked();
        } else if (key == KeyCode.ENTER) {
            handleApplyButtonClicked();
        }
    }

    /**
     * Funktion vom Cancel Button
     */
    public void handleCancelButtonClicked() {
        Alert confirmationDialog =
                DialogUtil.createConfirmationDialog(I18nComponentsUtil.getDialogCancelConfirmationText());

        Optional<ButtonType> result = confirmationDialog.showAndWait();
        if (result.orElse(null) == ButtonType.OK) {
            modalStage.close();
        }
    }

    /**
     * Füllt alle Textfelder
     *
     * @param entity gegebene Entität des Typs {@link T}
     */
    public abstract void initialize(T entity);

    /**
     * Funktion für den Apply Button
     */
    public abstract void handleApplyButtonClicked();

    /**
     * Überprüft alle Eingabefelder nach richtigen Daten
     *
     * @return true, wenn alle Eingaben gültig sind, sonst false
     */
    abstract boolean isInputValid();
}
