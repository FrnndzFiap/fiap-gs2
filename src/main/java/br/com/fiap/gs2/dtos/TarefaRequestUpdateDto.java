package br.com.fiap.gs2.dtos;

import br.com.fiap.gs2.model.Tarefa;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.modelmapper.ModelMapper;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TarefaRequestUpdateDto {

    private String nome;
    private String descricao;
    private String dificuldade;
    private String vantagem;

    private static final ModelMapper modelMapper = new ModelMapper();

    public Tarefa toModel(Long id) {
        Tarefa result = modelMapper.map(this, Tarefa.class);
        result.setId(id);
        return result;
    }

}
