package com.bridgelabz.iplanalyser.exception;

public class IPLAnalyserException extends Exception {

    public enum ExceptionType {
        NO_DATA, INVALID_TYPE
    }
    public ExceptionType type;

    public IPLAnalyserException(String message, ExceptionType type) {
        super(message);
        this.type = type;
    }
}

