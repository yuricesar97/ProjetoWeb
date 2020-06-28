package br.com.yuri.projetoweb.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@EqualsAndHashCode
@ToString
@NoArgsConstructor
@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Integer Id;
    @Getter
    @Setter
    private String nome;
    @Getter
    @Setter
    private String email;
    @Getter
    @Setter
    private String cpfOuCnpj;
    private Integer tipoCliente;

    @Getter
    @Setter
    @OneToMany(mappedBy = "cliente")
    private List<Endereco> enderecos = new ArrayList<>();

    @Getter
    @Setter
     @ElementCollection
     @CollectionTable(name = "TELEFONE")
    private Set<String> telefones = new HashSet<>();

    @JsonIgnore
    @Getter
    @Setter
    @OneToMany(mappedBy = "cliente")
    private List<Pedido> pedidos = new ArrayList<>();

    public Cliente(Integer id, String nome, String email, String cpfOuCnpj, TipoPessoa tipoClinete) {
        Id = id;
        this.nome = nome;
        this.email = email;
        this.cpfOuCnpj = cpfOuCnpj;
        this.tipoCliente = tipoClinete.getCod();
    }

    public TipoPessoa getTipoCliente() {
        return TipoPessoa.toEnum(tipoCliente);
    }

    public void setTipoCliente(TipoPessoa tipoCliente) {
        this.tipoCliente = tipoCliente.getCod();

    }


}
