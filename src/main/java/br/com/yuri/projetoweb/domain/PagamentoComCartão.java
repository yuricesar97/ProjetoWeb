package br.com.yuri.projetoweb.domain;


import lombok.*;

import javax.persistence.Entity;

@Getter
@Setter
@Data
@ToString
@NoArgsConstructor
@Entity
public class PagamentoComCartão extends Pagamento{

    private  Integer numeroDeParcelas;

    public PagamentoComCartão(Integer numeroDeParcelas) {
        this.numeroDeParcelas = numeroDeParcelas;
    }

    public PagamentoComCartão(Integer id, EstadoPagamento estado, Pedido pedido, Integer numeroDeParcelas) {
        super(id, estado, pedido);
        this.numeroDeParcelas = numeroDeParcelas;
    }
}
