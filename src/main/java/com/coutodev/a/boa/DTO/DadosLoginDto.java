package com.coutodev.a.boa.DTO;

import com.coutodev.a.boa.domin.Roles;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DadosLoginDto {

    private String email;
   private String password;


}
