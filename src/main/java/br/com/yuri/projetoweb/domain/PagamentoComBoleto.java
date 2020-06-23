package br.com.yuri.projetoweb.domain;


import lombok.*;

import javax.persistence.Entity;
import java.util.Date;

@Getter
@Setter
@Data
@ToString
@NoArgsConstructor
@Entity
public class PagamentoComBoleto extends Pagamento{

    private Date dataVencimento;
    private Date dataPagamento;

    public PagamentoComBoleto(Date dataVencimento, Date dataPagamento) {
        this.dataVencimento = dataVencimento;
        this.dataPagamento = dataPagamento;
    }

    public PagamentoComBoleto(Integer id, EstadoPagamento estado, Pedido pedido, Date dataVencimento, Date dataPagamento) {
        super(id, estado, pedido);
        this.dataVencimento = dataVencimento;
        this.dataPagamento = dataPagamento;
    }
}
