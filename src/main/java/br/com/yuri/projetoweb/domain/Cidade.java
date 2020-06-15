package br.com.yuri.projetoweb.domain;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@Entity
public class Cidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn( name = "estado_id")
    private Estado estado;


    public Cidade(Integer id, String nome ,Estado estado) {
        this.id = id;
        this.nome = nome;
        this.estado =estado;
    }
}
