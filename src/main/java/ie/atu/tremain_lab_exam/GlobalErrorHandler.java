package ie.atu.tremain_lab_exam;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.InvalidObjectException;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalErrorHandler extends RuntimeException {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> display(MethodArgumentNotValidException ex)
    {
        Map<String, String> errorList = new HashMap<>();
        for (FieldError error : ex.getBindingResult().getFieldErrors())
        {
            String errorName = error.getField();
            String errorMsg = error.getDefaultMessage();
            errorList.put(errorName, errorMsg);
        }
        return ResponseEntity.status(400).body(errorList);
    }

   /* @ExceptionHandler(InvalidObjectException.class)
    public ResponseEntity<Map<String, String>> display(InvalidObjectException ioe)
    {
        Map<String, String> invObjError = new HashMap<>();
        for (FieldError err : ioe.getStackTrace())
        {
            String errName = err.getField();
            String errMsg = err.getDefaultMessage();
            invObjError.put(errName, errMsg);
        }
        return ResponseEntity.status(400).body(invObjError);
    }*/
}
