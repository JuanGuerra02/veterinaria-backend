package com.Softcaribean.Veterinaria.dto;

import lombok.Data;
import java.sql.Date;

@Data
public class RafPacienteDto {
    private Integer nmid;
    private String dsnombre;
    private String dsraza;
    private Date dtfechanacimiento;
    private Date dtfecharegistro;
    private Integer nmtippaciid;
    private Integer nmduenoid;
}
