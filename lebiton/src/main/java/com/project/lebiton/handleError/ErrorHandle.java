package com.project.lebiton.handleError;

import com.project.lebiton.exceptions.CampoInvalidoException;
import com.project.lebiton.utils.RequestField;
import javafx.scene.control.Alert;

import java.util.List;

public class ErrorHandle {

    public static void checkFields(final List<RequestField> fields) throws Exception {

        for (final RequestField field : fields) {
            if (field.getValue() == null || field.getValue().isEmpty()) {
                showMessage(field);
                throw new CampoInvalidoException("Campo ".concat(field.getKey()).concat(" é Obrigatório"));
            }
        }
    }

    private static void showMessage(final RequestField field) {
        final Alert alert = new Alert(Alert.AlertType.ERROR);

        alert.setHeaderText("Campo ".concat(field.getKey()).concat(" obrigatório"));
        alert.setTitle("Campo Invalido!");
        alert.setContentText("Preencha todos os campos obrigatórios");
        alert.show();
    }
}
