package br.com.yuri.projetoweb.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
@NoArgsConstructor
@Entity
@Audited
public class Produto {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private  String nome;
    private Double preco;


    @JsonBackReference //Para tratar serialização do outro lado ja esta trazendo as objjetos
    @ManyToMany
    @JoinTable(name= "PRODUTO_CATEGORIA",
            joinColumns = @JoinColumn(name = "produto_id"),
            inverseJoinColumns = @JoinColumn(name= "categoria_id")
    )
    private List<Categoria> cat = new ArrayList<>();

    public Produto(Integer id, String nome, Double preco) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
    }
}
