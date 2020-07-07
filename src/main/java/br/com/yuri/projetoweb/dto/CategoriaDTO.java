package br.com.yuri.projetoweb.dto;

import br.com.yuri.projetoweb.domain.Categoria;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoriaDTO {

    private Integer id;
    private String nome;

    public CategoriaDTO(Categoria obj){
        id = obj.getId();
        nome = obj.getNome();
    }


}
