package br.com.fiap.gs2.mapper;

import br.com.fiap.gs2.dtos.TarefaRequestCreateDto;
import br.com.fiap.gs2.dtos.TarefaRequestUpdateDto;
import br.com.fiap.gs2.dtos.TarefaResponseDto;
import br.com.fiap.gs2.model.Tarefa;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TarefaMapper {

    @Autowired
    private ModelMapper modelMapper;

    public TarefaResponseDto toDto(Tarefa tarefa) {
        return modelMapper.map(tarefa, TarefaResponseDto.class);
    }

    public Tarefa toModel(TarefaRequestCreateDto dto) {
        return modelMapper.map(dto, Tarefa.class);
    }

    public Tarefa toModel(Long id, TarefaRequestUpdateDto dto) {
        Tarefa result = modelMapper.map(dto, Tarefa.class);
        result.setId(id);
        return result;
    }
}
