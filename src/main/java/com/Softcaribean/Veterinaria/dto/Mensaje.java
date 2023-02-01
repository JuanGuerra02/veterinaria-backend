package com.Softcaribean.Veterinaria.dto;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
public class Mensaje {
    private int codigo;
    private String mensaje;
    private Object data;
}
