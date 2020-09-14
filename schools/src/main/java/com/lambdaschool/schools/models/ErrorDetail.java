package com.lambdaschool.schools.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ErrorDetail
{
    /*
    Title - The title of the exception
    Status - Http Status Code
    detail - Detailed message for the client
    timestamp - date and time of the exception
    developer - message for developers about this error message, things like class and code causing the error
    List of Validation Errors - If data validation errors caused this error, the list of them will appear here
    */

    private String title;
    private int status;
    private String details;
    private Date timestamp;
    private String devmsg;
    private List<ValidationError> errs = new ArrayList<>();

    public ErrorDetail()
    {
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public int getStatus()
    {
        return status;
    }

    public void setStatus(int status)
    {
        this.status = status;
    }

    public String getDetails()
    {
        return details;
    }

    public void setDetails(String details)
    {
        this.details = details;
    }

    public Date getTimestamp()
    {
        return timestamp;
    }

    public void setTimestamp(Date timestamp)
    {
        this.timestamp = timestamp;
    }

    public String getDevmsg()
    {
        return devmsg;
    }

    public void setDevmsg(String devmsg)
    {
        this.devmsg = devmsg;
    }

    public List<ValidationError> getErrs()
    {
        return errs;
    }

    public void setErrs(List<ValidationError> errs)
    {
        this.errs = errs;
    }
}
