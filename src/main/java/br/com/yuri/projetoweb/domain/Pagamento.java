package br.com.yuri.projetoweb.domain;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;


@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Inheritance (strategy = InheritanceType.JOINED) //mapear herança
public abstract class Pagamento {
    @Getter
    @Setter
    @Id
    private Integer id;

    private Integer estado;

    @JsonIgnore
    @Getter
    @Setter
    @OneToOne
    @JoinColumn(name = "pedido_id")
    @MapsId
    private Pedido pedido;




    public Pagamento(Integer id, EstadoPagamento estado, Pedido pedido) {
        this.id = id;
        this.estado = estado.getCod();
        this.pedido = pedido;

    }
//    public EstadoPagamento getEstado(){
//        return EstadoPagamento.toEnum(estado);
//    }
//
//    public void setEstado (EstadoPagamento estado){
//        this.estado = estado.getCod();
//    }


}
