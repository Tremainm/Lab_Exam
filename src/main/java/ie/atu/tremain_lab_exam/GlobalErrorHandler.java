package ie.atu.tremain_lab_exam;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalErrorHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> display(MethodArgumentNotValidException ex)
    {
        Map<String> errorList = new HashMap<>();
        for (FieldError error : ex.getBindingResult().getFieldErrors())
        {
            String errorName = error.getField();
            String errorMsg = error.getDefaultMessage();
            errorList.put(errorName, errorMsg);
        }
        return ResponseEntity.status(400).body(errorList);
    }
}
