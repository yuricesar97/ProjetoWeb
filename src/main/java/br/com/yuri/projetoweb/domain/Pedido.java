package br.com.yuri.projetoweb.domain;


import lombok.*;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
@Data
@ToString
@EqualsAndHashCode
@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Date Instante;

    @OneToOne(cascade = CascadeType.ALL,mappedBy = "pedido")
    private Pagamento pagamento;


    @ManyToOne
    @JoinColumn(name="cliente_id")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name="endereco_de_entrega_id")
    private Endereco enderecoDeEntrega;

    public Pedido(Integer id, Date instante, Cliente cliente, Endereco enderecoDeEntrega) {
        this.id = id;
        Instante = instante;
        this.cliente = cliente;
        this.enderecoDeEntrega = enderecoDeEntrega;
    }
}
