package rrpay.bug.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@RestControllerAdvice
public class BugExceptionHandler {
    @ExceptionHandler({BugsNotFoundException.class})
    public ResponseEntity<ErrorDetails> handleBugsNotFoundException(BugsNotFoundException ex, WebRequest request) {
        var errorDetails = new ErrorDetails(LocalDateTime.now(), ex.getMessage(), request.getDescription(false), "BUGS_NOT_FOUND");
        return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({Exception.class})
    public ResponseEntity<ErrorDetails> handleBugExceptions(Exception ex, WebRequest request) {
        var errorDetails = new ErrorDetails(LocalDateTime.now(), ex.getMessage(), request.getDescription(false), "GENERIC_ERROR");
        return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.NOT_IMPLEMENTED);
    }
}
