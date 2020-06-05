package br.com.yuri.projetoweb.resource.exception;

import br.com.yuri.projetoweb.services.exception.ObjectException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;


@ControllerAdvice// permite manipular exceções em todo o aplicativo.Interceptador de exceções geradas por métodos anotados @RequestMappinge similares.
public class ExceptionResource {

    @ExceptionHandler(ObjectException.class)
    public ResponseEntity<ErroPadrao> objectNot(ObjectException e, HttpServletRequest request){
        ErroPadrao erro = new ErroPadrao(HttpStatus.NOT_FOUND.value(),e.getMessage(),System.currentTimeMillis());
        return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
    }
}
