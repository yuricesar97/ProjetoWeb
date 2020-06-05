package br.com.yuri.projetoweb.services.exception;

import net.bytebuddy.implementation.bind.annotation.Super;

public class ObjectException extends RuntimeException {

    public ObjectException(String msg){
      super(msg);
    }

    public ObjectException(String msg, Throwable causa){
        super(msg, causa);
    }
}
