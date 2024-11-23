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
public class TarefaResponseDto {

    private Long id;
    private String nome;
    private String descricao;
    private String dificuldade;
    private String vantagem;

    private static final ModelMapper modelMapper = new ModelMapper();

    public TarefaResponseDto toDto(Tarefa tarefa) {
        return modelMapper.map(tarefa, TarefaResponseDto.class);
    }
}
