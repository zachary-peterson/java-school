package com.lambdaschool.schools.handlers;

import com.lambdaschool.schools.exceptions.LambdaException;
import com.lambdaschool.schools.exceptions.LambdaNFException;
import com.lambdaschool.schools.models.ErrorDetail;
import com.lambdaschool.schools.services.HelperFunctions;
import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.validation.BindException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.context.request.async.AsyncRequestTimeoutException;
import org.springframework.web.multipart.support.MissingServletRequestPartException;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@Order(Ordered.HIGHEST_PRECEDENCE)
@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler
{
    @Autowired
    HelperFunctions helperFunctions;

    public RestExceptionHandler()
    {
        super();
    }

    @ExceptionHandler(LambdaNFException.class)
    public ResponseEntity<?> handleLambdaNFException(LambdaNFException gen)
    {
        ErrorDetail errorDets = new ErrorDetail();
        errorDets.setTimestamp(new Date());
        errorDets.setStatus(404);
        errorDets.setTitle("Lambda Resource Could Not Be Found");
        errorDets.setDetails(gen.getMessage());
        errorDets.setDevmsg(gen.getClass()
            .getName());
        errorDets.setErrs(helperFunctions.getConstraintViolations(gen));

        return new ResponseEntity<>(errorDets,
            null,
            HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(LambdaException.class)
    public ResponseEntity<?> handleLambdaException(LambdaNFException gen)
    {
        ErrorDetail errorDets = new ErrorDetail();
        errorDets.setTimestamp(new Date());
        errorDets.setStatus(404);
        errorDets.setTitle("Lambda Resource Could Not Be Found");
        errorDets.setDetails(gen.getMessage());
        errorDets.setDevmsg(gen.getClass()
            .getName());
        errorDets.setErrs(helperFunctions.getConstraintViolations(gen));

        return new ResponseEntity<>(errorDets,
            null,
            HttpStatus.NOT_FOUND);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotWritable(
        HttpMessageNotWritableException ex,
        HttpHeaders headers,
        HttpStatus status,
        WebRequest request)
    {
        ErrorDetail errorDets = new ErrorDetail();
        errorDets.setTimestamp(new Date());
        errorDets.setTitle("Rest Internal Exception");
        errorDets.setStatus(HttpStatus.NOT_FOUND.value());
        errorDets.setDetails(ex.getMessage());
        errorDets.setDevmsg(ex.getClass()
            .getName());
        errorDets.setErrs(helperFunctions.getConstraintViolations(ex));

        return new ResponseEntity<>(errorDets,
            null,
            HttpStatus.NOT_FOUND);
    }

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(
        Exception ex,
        Object body,
        HttpHeaders headers,
        HttpStatus status,
        WebRequest request)
    {
        ErrorDetail errorDets = new ErrorDetail();
        errorDets.setTimestamp(new Date());
        errorDets.setTitle("Rest Internal Exception");
        errorDets.setStatus(HttpStatus.NOT_FOUND.value());
        errorDets.setDetails(ex.getMessage());
        errorDets.setDevmsg(ex.getClass()
            .getName());
        errorDets.setErrs(helperFunctions.getConstraintViolations(ex));

        return new ResponseEntity<>(errorDets,
            null,
            HttpStatus.NOT_FOUND);
    }

    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(
        HttpRequestMethodNotSupportedException ex,
        HttpHeaders headers,
        HttpStatus status,
        WebRequest request)
    {
        ErrorDetail errorDets = new ErrorDetail();
        errorDets.setTimestamp(new Date());
        errorDets.setTitle("Rest Internal Exception");
        errorDets.setStatus(HttpStatus.NOT_FOUND.value());
        errorDets.setDetails(ex.getMessage());
        errorDets.setDevmsg(ex.getClass()
            .getName());
        errorDets.setErrs(helperFunctions.getConstraintViolations(ex));

        return new ResponseEntity<>(errorDets,
            null,
            HttpStatus.NOT_FOUND);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(
        HttpMediaTypeNotSupportedException ex,
        HttpHeaders headers,
        HttpStatus status,
        WebRequest request)
    {
        ErrorDetail errorDets = new ErrorDetail();
        errorDets.setTimestamp(new Date());
        errorDets.setTitle("Rest Internal Exception");
        errorDets.setStatus(HttpStatus.NOT_FOUND.value());
        errorDets.setDetails(ex.getMessage());
        errorDets.setDevmsg(ex.getClass()
            .getName());
        errorDets.setErrs(helperFunctions.getConstraintViolations(ex));

        return new ResponseEntity<>(errorDets,
            null,
            HttpStatus.NOT_FOUND);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMediaTypeNotAcceptable(
        HttpMediaTypeNotAcceptableException ex,
        HttpHeaders headers,
        HttpStatus status,
        WebRequest request)
    {
        ErrorDetail errorDets = new ErrorDetail();
        errorDets.setTimestamp(new Date());
        errorDets.setTitle("Rest Internal Exception");
        errorDets.setStatus(HttpStatus.NOT_FOUND.value());
        errorDets.setDetails(ex.getMessage());
        errorDets.setDevmsg(ex.getClass()
            .getName());
        errorDets.setErrs(helperFunctions.getConstraintViolations(ex));

        return new ResponseEntity<>(errorDets,
            null,
            HttpStatus.NOT_FOUND);
    }

    @Override
    protected ResponseEntity<Object> handleMissingPathVariable(
        MissingPathVariableException ex,
        HttpHeaders headers,
        HttpStatus status,
        WebRequest request)
    {
        ErrorDetail errorDets = new ErrorDetail();
        errorDets.setTimestamp(new Date());
        errorDets.setTitle("Rest Internal Exception");
        errorDets.setStatus(HttpStatus.NOT_FOUND.value());
        errorDets.setDetails(ex.getMessage());
        errorDets.setDevmsg(ex.getClass()
            .getName());
        errorDets.setErrs(helperFunctions.getConstraintViolations(ex));

        return new ResponseEntity<>(errorDets,
            null,
            HttpStatus.NOT_FOUND);
    }

    @Override
    protected ResponseEntity<Object> handleMissingServletRequestParameter(
        MissingServletRequestParameterException ex,
        HttpHeaders headers,
        HttpStatus status,
        WebRequest request)
    {
        ErrorDetail errorDets = new ErrorDetail();
        errorDets.setTimestamp(new Date());
        errorDets.setTitle("Rest Internal Exception");
        errorDets.setStatus(HttpStatus.NOT_FOUND.value());
        errorDets.setDetails(ex.getMessage());
        errorDets.setDevmsg(ex.getClass()
            .getName());
        errorDets.setErrs(helperFunctions.getConstraintViolations(ex));

        return new ResponseEntity<>(errorDets,
            null,
            HttpStatus.NOT_FOUND);
    }

    @Override
    protected ResponseEntity<Object> handleServletRequestBindingException(
        ServletRequestBindingException ex,
        HttpHeaders headers,
        HttpStatus status,
        WebRequest request)
    {
        ErrorDetail errorDets = new ErrorDetail();
        errorDets.setTimestamp(new Date());
        errorDets.setTitle("Rest Internal Exception");
        errorDets.setStatus(HttpStatus.NOT_FOUND.value());
        errorDets.setDetails(ex.getMessage());
        errorDets.setDevmsg(ex.getClass()
            .getName());
        errorDets.setErrs(helperFunctions.getConstraintViolations(ex));

        return new ResponseEntity<>(errorDets,
            null,
            HttpStatus.NOT_FOUND);
    }

    @Override
    protected ResponseEntity<Object> handleConversionNotSupported(
        ConversionNotSupportedException ex,
        HttpHeaders headers,
        HttpStatus status,
        WebRequest request)
    {
        ErrorDetail errorDets = new ErrorDetail();
        errorDets.setTimestamp(new Date());
        errorDets.setTitle("Rest Internal Exception");
        errorDets.setStatus(HttpStatus.NOT_FOUND.value());
        errorDets.setDetails(ex.getMessage());
        errorDets.setDevmsg(ex.getClass()
            .getName());
        errorDets.setErrs(helperFunctions.getConstraintViolations(ex));

        return new ResponseEntity<>(errorDets,
            null,
            HttpStatus.NOT_FOUND);
    }

    @Override
    protected ResponseEntity<Object> handleTypeMismatch(
        TypeMismatchException ex,
        HttpHeaders headers,
        HttpStatus status,
        WebRequest request)
    {
        ErrorDetail errorDets = new ErrorDetail();
        errorDets.setTimestamp(new Date());
        errorDets.setTitle("Rest Internal Exception");
        errorDets.setStatus(400);
        errorDets.setDetails("Found an issue with School: " + ex.getMessage());
        errorDets.setDevmsg(ex.getClass()
            .getName());
        errorDets.setErrs(helperFunctions.getConstraintViolations(ex));

        return new ResponseEntity<>(errorDets,
            null,
            HttpStatus.NOT_FOUND);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(
        HttpMessageNotReadableException ex,
        HttpHeaders headers,
        HttpStatus status,
        WebRequest request)
    {
        ErrorDetail errorDets = new ErrorDetail();
        errorDets.setTimestamp(new Date());
        errorDets.setTitle("Rest Internal Exception");
        errorDets.setStatus(HttpStatus.NOT_FOUND.value());
        errorDets.setDetails("Found an issue with School: " + ex.getMessage());
        errorDets.setDevmsg(ex.getClass()
            .getName());
        errorDets.setErrs(helperFunctions.getConstraintViolations(ex));

        return new ResponseEntity<>(errorDets,
            null,
            HttpStatus.NOT_FOUND);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
        MethodArgumentNotValidException ex,
        HttpHeaders headers,
        HttpStatus status,
        WebRequest request)
    {
        ErrorDetail errorDets = new ErrorDetail();
        errorDets.setTimestamp(new Date());
        errorDets.setTitle("Rest Internal Exception");
        errorDets.setStatus(HttpStatus.NOT_FOUND.value());
        errorDets.setDetails("Found an issue with School: " + ex.getMessage());
        errorDets.setDevmsg(ex.getClass()
            .getName());
        errorDets.setErrs(helperFunctions.getConstraintViolations(ex));

        return new ResponseEntity<>(errorDets,
            null,
            HttpStatus.NOT_FOUND);
    }

    @Override
    protected ResponseEntity<Object> handleMissingServletRequestPart(
        MissingServletRequestPartException ex,
        HttpHeaders headers,
        HttpStatus status,
        WebRequest request)
    {
        ErrorDetail errorDets = new ErrorDetail();
        errorDets.setTimestamp(new Date());
        errorDets.setTitle("Rest Internal Exception");
        errorDets.setStatus(HttpStatus.NOT_FOUND.value());
        errorDets.setDetails("Found an issue with School: " + ex.getMessage());
        errorDets.setDevmsg(ex.getClass()
            .getName());
        errorDets.setErrs(helperFunctions.getConstraintViolations(ex));

        return new ResponseEntity<>(errorDets,
            null,
            HttpStatus.NOT_FOUND);
    }

    @Override
    protected ResponseEntity<Object> handleBindException(
        BindException ex,
        HttpHeaders headers,
        HttpStatus status,
        WebRequest request)
    {
        ErrorDetail errorDets = new ErrorDetail();
        errorDets.setTimestamp(new Date());
        errorDets.setTitle("Rest Internal Exception");
        errorDets.setStatus(HttpStatus.NOT_FOUND.value());
        errorDets.setDetails("Found an issue with School: " + ex.getMessage());
        errorDets.setDevmsg(ex.getClass()
            .getName());
        errorDets.setErrs(helperFunctions.getConstraintViolations(ex));

        return new ResponseEntity<>(errorDets,
            null,
            HttpStatus.NOT_FOUND);
    }

    @Override
    protected ResponseEntity<Object> handleNoHandlerFoundException(
        NoHandlerFoundException ex,
        HttpHeaders headers,
        HttpStatus status,
        WebRequest request)
    {
        ErrorDetail errorDets = new ErrorDetail();
        errorDets.setTimestamp(new Date());
        errorDets.setTitle("Rest Internal Exception");
        errorDets.setStatus(HttpStatus.NOT_FOUND.value());
        errorDets.setDetails("Found an issue with School: " + ex.getMessage());
        errorDets.setDevmsg(ex.getClass()
            .getName());
        errorDets.setErrs(helperFunctions.getConstraintViolations(ex));

        return new ResponseEntity<>(errorDets,
            null,
            HttpStatus.NOT_FOUND);
    }

    @Override
    protected ResponseEntity<Object> handleAsyncRequestTimeoutException(
        AsyncRequestTimeoutException ex,
        HttpHeaders headers,
        HttpStatus status,
        WebRequest webRequest)
    {
        ErrorDetail errorDets = new ErrorDetail();
        errorDets.setTimestamp(new Date());
        errorDets.setTitle("Rest Internal Exception");
        errorDets.setStatus(HttpStatus.NOT_FOUND.value());
        errorDets.setDetails("Found an issue with School: " + ex.getMessage());
        errorDets.setDevmsg(ex.getClass()
            .getName());
        errorDets.setErrs(helperFunctions.getConstraintViolations(ex));

        return new ResponseEntity<>(errorDets,
            null,
            HttpStatus.NOT_FOUND);
    }
}