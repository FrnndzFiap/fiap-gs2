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
public class TarefaRequestCreateDto {

    private String nome;
    private String descricao;
    private String dificuldade;
    private String vantagem;

    private static final ModelMapper modelMapper = new ModelMapper();


    public Tarefa toModel() {
        return modelMapper.map(this, Tarefa.class);

    }
}
