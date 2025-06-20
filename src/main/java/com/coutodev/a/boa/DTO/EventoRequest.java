package com.coutodev.a.boa.DTO;

import com.coutodev.a.boa.domin.TipoDoEvento;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record EventoRequest(
       @NotBlank String nome ,
     TipoDoEvento tipo,
       @NotNull LocalDateTime dateInitial,
         @NotNull LocalDateTime dateEnd,
      @NotBlank  String local,
       @NotBlank String descrição,
       @NotBlank String organizador
) {

}
