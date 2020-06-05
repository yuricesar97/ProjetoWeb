package br.com.yuri.projetoweb.domain;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@EqualsAndHashCode
@Entity
public class Cidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;

   @JsonBackReference
   @ManyToOne
   @JoinColumn( name = "estado_id")
    private Estado estado;

    public Cidade(){}

    public Cidade(Integer id, String nome ,Estado estado) {
        this.id = id;
        this.nome = nome;
        this.estado =estado;
    }
}
