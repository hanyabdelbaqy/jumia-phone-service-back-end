/**
 *
 */
package com.jumia.exception;

import java.util.Date;

public class ErrorDetails {
    private Date timestamp;
    private int responseCode;
    private String message;
    private String details;

    public ErrorDetails(Date timestamp, int responseCode, String message, String details) {
        super();
        this.timestamp = timestamp;
        this.responseCode = responseCode;
        this.message = message;
        this.details = details;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    public String getDetails() {
        return details;
    }

    public int getResponseCode() { return responseCode; }
}