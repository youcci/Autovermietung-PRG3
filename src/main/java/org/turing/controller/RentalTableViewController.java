package org.turing.controller;

import de.htwsaar.prog3.carrental.model.Rental;
import de.htwsaar.prog3.carrental.service.RentalService;
import de.htwsaar.prog3.carrental.util.DialogUtil;
import de.htwsaar.prog3.carrental.util.i18n.I18nComponentsUtil;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

/**
 * Controller for RentalTableView.
 *
 * @author Youcef Wippert, Ahmad Anwar
 */
public class RentalTableViewController extends GenericTableViewController<Rental> implements Initializable {
    @FXML
    private TableView<Rental> rentalTableView;

    @FXML
    private TableColumn<Rental, Integer> id;
    @FXML
    private TableColumn<Rental, String> begin;
    @FXML
    private TableColumn<Rental, String> car;
    @FXML
    private TableColumn<Rental, String> customer;
    @FXML
    private TableColumn<Rental, String> employee;
    @FXML
    private TableColumn<Rental, String> end;
    @FXML
    private TableColumn<Rental, String> extraCosts;
    @FXML
    private TableColumn<Rental, String> note;

    public RentalTableViewController() {
        service = new RentalService();
        entities = FXCollections.observableArrayList(service.findAll());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        id.setCellValueFactory(new PropertyValueFactory<>("Id"));
        begin.setCellValueFactory(new PropertyValueFactory<>("Begin"));
        car.setCellValueFactory(new PropertyValueFactory<>("Car"));
        customer.setCellValueFactory(new PropertyValueFactory<>("Customer"));
        employee.setCellValueFactory(new PropertyValueFactory<>("Employee"));
        end.setCellValueFactory(new PropertyValueFactory<>("End"));
        extraCosts.setCellValueFactory(new PropertyValueFactory<>("ExtraCosts"));
        note.setCellValueFactory(new PropertyValueFactory<>("Note"));

        rentalTableView.setItems(entities);
    }

    /**
     * Rental view does not use a "New..." button.
     *
     * @see CarTableViewController#handleRentButtonClicked()
     */
    @Override
    public void handleNewButtonClicked() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void handleEditButtonClicked() {
        Rental rental = rentalTableView.getSelectionModel().getSelectedItem();

        if (rental != null) {
            boolean applyClicked = app.showRentalEditView(rental);
            if (applyClicked) {
                service.update(rental);
                entities.setAll(service.findAll());
            }
        }
    }

    @Override
    public void handleDeleteButtonClicked() {
        Rental rental = rentalTableView.getSelectionModel().getSelectedItem();

        if (null == rental) {
            Alert info = DialogUtil.createInformationDialog(I18nComponentsUtil.getDialogDeleteNoSelectionText());
            info.show();
            return;
        }

        Alert confirmation = DialogUtil.createConfirmationDialog(I18nComponentsUtil.getDialogDeleteConfirmationText());
        Optional<ButtonType> result = confirmation.showAndWait();

        if (result.orElse(null) == ButtonType.OK) {
            service.delete(rental);
            entities.setAll(service.findAll());
        }
    }
}
