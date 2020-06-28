package br.com.yuri.projetoweb.domain;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Categoria {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private String nome;

    @ManyToMany(mappedBy = "cat")
    private List<Produto> produtos = new ArrayList<>();


    public Categoria(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }



}
