package br.com.yuri.projetoweb.resource.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErroPadrao {

    private Integer status;
    private String msg;
    private Long milessegundos;

    public ErroPadrao(Integer status, String msg, Long milessegundos) {
        this.status = status;
        this.msg = msg;
        this.milessegundos = milessegundos;
    }
}
