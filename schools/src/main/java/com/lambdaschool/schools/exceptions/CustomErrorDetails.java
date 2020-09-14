package com.lambdaschool.schools.exceptions;

import com.lambdaschool.schools.models.ErrorDetail;
import com.lambdaschool.schools.services.HelperFunctions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

@Component
public class CustomErrorDetails extends DefaultErrorAttributes
{
    @Autowired
    HelperFunctions helperFunctions;

    @Override
    public Map<String, Object> getErrorAttributes(
        WebRequest webRequest,
        boolean includeStackTrace)
    {
        Map<String, Object> errorAttributes = super.getErrorAttributes(webRequest, includeStackTrace);

        Map<String, Object> errorDetails = new LinkedHashMap<>();

        /*
        Title - The title of the exception
        Status - Http Status Code
        detail - Detailed message for the client
        timestamp - date and time of the exception
        developer - message for developers about this error message, things like class and code causing the error
        List of Validation Errors - If data validation errors caused this error, the list of them will appear here
        */

        errorDetails.put("title", errorAttributes.get("error"));
        errorDetails.put("status", errorAttributes.get("status"));
        errorDetails.put("details", errorAttributes.get("message"));
        errorDetails.put("timestamp", errorAttributes.get("timestamp"));
        errorDetails.put("developermessage", "path: " + errorAttributes.get("path"));

        errorDetails.put("errors", helperFunctions.getConstraintViolations(this.getError(webRequest)));
        return errorDetails;
    }
}
