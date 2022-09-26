package com.netlink.servers.exception;

import com.netlink.servers.model.ErrorMsg;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@ControllerAdvice // handle GE
public class GlobalExceptionHandler {

    @ExceptionHandler(value = EmployeeIdNotFoundException.class)
    public ResponseEntity<String> handleEmployeeNotFoundException(final Exception e,
                                                                  final HttpServletRequest httpServletRequest) {
        ErrorMsg errorMsg = new ErrorMsg();
        errorMsg.setMsg(e.getMessage());
        errorMsg.setUrl(httpServletRequest.getRequestURI());
        errorMsg.setDateTime(LocalDateTime.now());

        return new ResponseEntity(errorMsg, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = EmailAlreadyExistedException.class)
    public ResponseEntity<String> handleEmployeeEmailAlreadyFoundException(final Exception e,
                                                                  final HttpServletRequest httpServletRequest) {
        ErrorMsg errorMsg = new ErrorMsg();
        errorMsg.setMsg(e.getMessage());
        errorMsg.setUrl(httpServletRequest.getRequestURI());
        errorMsg.setDateTime(LocalDateTime.now());
        return new ResponseEntity(errorMsg, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = NullPointerException.class)
    public ResponseEntity<String> handleNullPointerException(final Exception e,
                                                             final HttpServletRequest httpServletRequest) {
        ErrorMsg errorMsg = new ErrorMsg();
        errorMsg.setMsg(e.getMessage());
        errorMsg.setUrl(httpServletRequest.getRequestURI());
        errorMsg.setDateTime(LocalDateTime.now());
        return new ResponseEntity(errorMsg, HttpStatus.BAD_REQUEST);
    }

}
