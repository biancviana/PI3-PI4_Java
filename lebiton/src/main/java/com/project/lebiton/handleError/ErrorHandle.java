package com.project.lebiton.handleError;

import com.project.lebiton.exceptions.CampoInvalidoException;
import com.project.lebiton.utils.RequestField;
import javafx.scene.control.Alert;

import java.util.List;

public class ErrorHandle {

    public static void checkFields(final List<RequestField> fields) throws Exception {

        for (final RequestField field : fields) {
            if (field.getValue().isEmpty()) {
                final Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("Campo ".concat(field.getKey()).concat(" é Obrigatório"));
                alert.setTitle("Campo Invalido!");
                alert.setContentText("Preencha todos os campos obrigatórios");
                alert.show();

                throw new CampoInvalidoException("Há campos obrigatório não preenchidos");
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
