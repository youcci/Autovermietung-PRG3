package org.turing.controller;

import org.turing.App;
import org.turing.model.BaseEntity;
import org.turing.service.GenericService;
import org.turing.util.DialogUtil;
import org.turing.util.i18n.I18nComponentsUtil;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import lombok.Setter;
import org.turing.model.*;

/**
 * Super Controller für alle anderen TableView Controller
 *
 * @author Youcef Wippert
 */
public abstract class GenericTableViewController<T extends BaseEntity> {
    GenericService<T> service;
    ObservableList<T> entities;

    @Setter
    App app;

    @FXML
    public ComboBox<String> searchComboBoxField;

    @FXML
    public ComboBox<String> searchComboBoxComparator;

    @FXML
    public TextField searchTextField;

    /**
     * Funktion für Tastaturbefehle in einer TableView
     *
     * @param event Das eingetretene Ereignis, das auch die gedrückte Taste enthält.
     */
    public void handleKeyEvent(KeyEvent event) {
        if (event.getCode() == KeyCode.DELETE) {
            handleDeleteButtonClicked();
        }
    }

    /**
     * Schaltet Szene für {@link Car Car}.
     */
    public void handleCarMenuItemClicked() {
        app.showCarTableView();
    }

    /**
     * Schaltet Szene für {@link Customer Customer}.
     */
    public void handleCustomerMenuItemClicked() {
        app.showCustomerTableView();
    }

    /**
     * Schaltet Szene für {@link Employee Employee}.
     */
    public void handleEmployeeMenuItemClicked() {
        app.showEmployeeTableView();
    }

    /**
     * Schaltet Szene für {@link Rental Rental}.
     */
    public void handleRentalMenuItemClicked() {
        app.showRentalTableView();
    }

    /**
     * Schließt das Programm.
     *
     * @see App#stop()
     */
    public void handleCloseMenuItemClicked() {
        Platform.exit();
    }

    /**
     * Zeigt ein Dialogfeld mit Informationen zu diesem Softwareprojekt an.
     */
    public void handleAboutMenuItemClicked() {
        Alert aboutDialog = DialogUtil.createInformationDialog(I18nComponentsUtil.getDialogAboutText());
        aboutDialog.show();
    }

    /**
     * Wendet ausgewählte Filter an
     */
    public void handleApplyCurrentFilterButtonClicked() {
        setSearchComboBoxAndTextFieldBordersIfEmpty();

        String field = searchComboBoxField.getValue();
        String comparator = searchComboBoxComparator.getValue();
        String value = searchTextField.getText();

        if (field != null && comparator != null && !value.isEmpty()) {
            entities.setAll(service.filter(field, comparator, value));
        }
    }

    /**
     * Entfernt ausgewählte Filter
     */
    public void handleRemoveCurrentFilterButtonClicked() {
        clearSearchComboBoxAndTextFieldBorders();
        clearSearchComboBoxAndTextFieldValues();

        entities.setAll(service.findAll());
    }

    /**
     * Funktion für den "Neu..." Button
     */
    public abstract void handleNewButtonClicked();

    /**
     * Funktion für den "Bearbeiten..." Button
     */
    public abstract void handleEditButtonClicked();

    /**
     * Funktion für den "Löschen..." Button
     */
    public abstract void handleDeleteButtonClicked();

    /**
     * Löscht die beiden obersten Werte der ComboBox und des TextFields für die Suche.
     *
     */
    private void clearSearchComboBoxAndTextFieldValues() {
        searchComboBoxField.getSelectionModel().clearSelection();
        searchComboBoxComparator.getSelectionModel().clearSelection();
        searchTextField.clear();
    }

    /**
     * Löscht die oberen beiden Such-Combobox- und Textfeld-Ränder.
     *
     */
    private void clearSearchComboBoxAndTextFieldBorders() {
        searchComboBoxField.setBorder(null);
        searchComboBoxComparator.setBorder(null);
        searchTextField.setBorder(null);
    }

    /**
     * Legt die oberen beiden Ränder der ComboBox und des TextFields fest, wenn sie leer sind.
     */
    private void setSearchComboBoxAndTextFieldBordersIfEmpty() {
        // Border radii taken from modena.css
        Border border = new Border(new BorderStroke(
                Color.RED,
                BorderStrokeStyle.SOLID,
                new CornerRadii(3.0, 3.0, 2.0, 1.0, false),
                BorderWidths.DEFAULT
        ));

        if (searchComboBoxField.getSelectionModel().isEmpty()) {
            searchComboBoxField.setBorder(border);
        } else {
            searchComboBoxField.setBorder(null);
        }

        if (searchComboBoxComparator.getSelectionModel().isEmpty()) {
            searchComboBoxComparator.setBorder(border);
        } else {
            searchComboBoxComparator.setBorder(null);
        }

        if (searchTextField.getText().isEmpty()) {
            searchTextField.setBorder(border);
        } else {
            searchTextField.setBorder(null);
        }
    }
}
