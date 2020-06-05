package br.com.yuri.projetoweb.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Audited
@Entity
public class Categoria {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private String nome;

    @JsonManagedReference  // para trazer as categorias de produtos
    @ManyToMany(mappedBy = "cat")
    private List<Produto> produtos = new ArrayList<>();

   public Categoria(){};

    public Categoria(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }



}
