package hu.nmovie.main.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandlerMovie {
	
	@ExceptionHandler(NMovieNotFoundException.class)
	public ResponseEntity<Object> handleNMovieNotFound(NMovieNotFoundException ex){
		Map<String, Object> body = new HashMap<>();
		body.put("timestamp", LocalDateTime.now());
	    body.put("message", ex.getMessage());
	    body.put("status", HttpStatus.NOT_FOUND.value());

	    return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleGeneric(Exception ex) {
        Map<String, Object> body = new HashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("message", "Váratlan hiba történt: " + ex.getMessage());
        body.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());

        return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
