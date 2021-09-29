package com.project.lebiton.handleError;

import com.project.lebiton.exceptions.CampoInvalidoException;
import com.project.lebiton.utils.Message;
import com.project.lebiton.utils.RequestField;
import javafx.scene.control.Alert;

import java.util.List;

public class ErrorHandle {

    public static void checkFields(final List<RequestField> fields) throws Exception {

        for (final RequestField field : fields) {
            if (field.getValue().getText() == null || field.getValue().getText().isEmpty()) {

                field.getValue().setStyle("-fx-border-color: red ; -fx-border-width: 2px ;");

                Message.showAlert("Campo Invalido!", "Campo ".concat(field.getKey()).concat(" obrigatório").toUpperCase(),
                        "Preencha todos os campos obrigatórios", Alert.AlertType.ERROR);

                throw new CampoInvalidoException("Campo ".concat(field.getKey()).concat(" obrigatório"));
            } else {
                field.getValue().setStyle("-fx-border-color: black ; -fx-border-width: 1px ;");
            }
        }
    }

}
