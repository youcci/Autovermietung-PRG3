package org.turing.controller;

import org.turing.model.Employee;
import org.turing.service.EmployeeService;
import org.turing.util.DialogUtil;
import org.turing.util.i18n.I18nComponentsUtil;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import javax.persistence.RollbackException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

/**
 * Controller for EmployeeTableView.
 *
 * @author Lukas Raubuch, Jens Thewes
 */
public class EmployeeTableViewController extends GenericTableViewController<Employee> implements Initializable {
    @FXML
    private TableView<Employee> employeeTableView;

    @FXML
    private TableColumn<Employee, Integer> id;
    @FXML
    private TableColumn<Employee, String> firstName;
    @FXML
    private TableColumn<Employee, String> lastName;
    @FXML
    private TableColumn<Employee, String> position;

    public EmployeeTableViewController() {
        service = new EmployeeService();
        entities = FXCollections.observableArrayList(service.findAll());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        id.setCellValueFactory(new PropertyValueFactory<>("Id"));
        firstName.setCellValueFactory(new PropertyValueFactory<>("FirstName"));
        lastName.setCellValueFactory(new PropertyValueFactory<>("LastName"));
        position.setCellValueFactory(new PropertyValueFactory<>("Position"));

        employeeTableView.setItems(entities);
    }

    @Override
    public void handleNewButtonClicked() {
        Employee employee = new Employee();

        boolean applyClicked = app.showEmployeeEditView(employee);
        if (applyClicked) {
            service.persist(employee);
            entities.setAll(service.findAll());
        }
    }

    @Override
    public void handleEditButtonClicked() {
        Employee employee = employeeTableView.getSelectionModel().getSelectedItem();

        if (employee != null) {
            boolean applyClicked = app.showEmployeeEditView(employee);
            if (applyClicked) {
                service.update(employee);
                entities.setAll(service.findAll());
            }
        }
    }

    @Override
    public void handleDeleteButtonClicked() {
        Employee employee = employeeTableView.getSelectionModel().getSelectedItem();

        if (null == employee) {
            Alert info = DialogUtil.createInformationDialog(I18nComponentsUtil.getDialogDeleteNoSelectionText());
            info.show();
            return;
        }

        Alert confirmation = DialogUtil.createConfirmationDialog(I18nComponentsUtil.getDialogDeleteConfirmationText());
        Optional<ButtonType> result = confirmation.showAndWait();

        if (result.orElse(null) == ButtonType.OK) {
            try {
                service.delete(employee);
                entities.setAll(service.findAll());
            } catch (RollbackException e) {
                // TODO i18n
                Alert alert = DialogUtil.createErrorDialog("Invalid Action", "Can't delete this employee",
                        "You must first delete the rental");
                alert.showAndWait();
            }
        }
    }
}
