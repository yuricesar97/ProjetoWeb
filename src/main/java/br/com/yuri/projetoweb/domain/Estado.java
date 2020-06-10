package br.com.yuri.projetoweb.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@Entity
public class Estado {


  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String nome;

  @JsonManagedReference
  @OneToMany(mappedBy = "estado")
  private List<Cidade> cidades = new ArrayList<>();


    public Estado(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }
}
