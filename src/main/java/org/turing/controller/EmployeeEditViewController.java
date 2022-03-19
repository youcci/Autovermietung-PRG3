package org.turing.controller;

import org.turing.model.Employee;
import org.turing.service.EmployeeService;
import org.turing.util.DialogUtil;
import org.turing.util.i18n.I18nComponentsUtil;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

/**
 * This is the Controller for the "Edit Employee View" of the Carrental Application.
 *
 * @author Ahmad Anwar
 */
public class EmployeeEditViewController extends GenericEditViewController<Employee> {
    @FXML
    private TextField firstNameTextField;

    @FXML
    private TextField lastNameTextField;

    @FXML
    private TextField positionTextField;

    public EmployeeEditViewController() {
        service = new EmployeeService();
    }

    @Override
    public void initialize(Employee employee) {
        entity = employee;

        firstNameTextField.setText(entity.getFirstName());
        lastNameTextField.setText(entity.getLastName());
        positionTextField.setText(entity.getPosition());
    }

    @Override
    public void handleApplyButtonClicked() {
        if (isInputValid()) {
            entity.setFirstName(firstNameTextField.getText());
            entity.setLastName(lastNameTextField.getText());
            entity.setPosition(positionTextField.getText());

            applyClicked = true;
            modalStage.close();
        }
    }

    @Override
    boolean isInputValid() {
        StringBuilder sb = new StringBuilder();

        if (firstNameTextField.getText() == null || firstNameTextField.getText().trim().isEmpty()) {
            sb.append(I18nComponentsUtil.getEmployeeNoValidFirstName());
            sb.append(System.lineSeparator());
        }

        if (lastNameTextField.getText() == null || lastNameTextField.getText().trim().isEmpty()) {
            sb.append(I18nComponentsUtil.getEmployeeNoValidLastName());
            sb.append(System.lineSeparator());
        }

        if (positionTextField.getText() == null || positionTextField.getText().trim().isEmpty()) {
            sb.append(I18nComponentsUtil.getEmployeeNoValidPosition());
            sb.append(System.lineSeparator());
        }

        String errorMessage = sb.toString();
        if (!errorMessage.isEmpty()) {
            Alert alert = DialogUtil.createErrorDialog(I18nComponentsUtil.getDialogErrorInvalidFieldsTitle(),
                    I18nComponentsUtil.getDialogErrorInvalidFieldsText(), errorMessage);
            alert.showAndWait();

            return false;
        }

        return true;
    }
}
