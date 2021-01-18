package com.educandoweb.course.services.exceptions;

import java.io.Serializable;

public class DatabaseException extends RuntimeException implements Serializable {

    public DatabaseException(String msg){super(msg);}
}
