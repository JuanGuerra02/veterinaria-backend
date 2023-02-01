package com.Softcaribean.Veterinaria.controller;

import com.Softcaribean.Veterinaria.dto.Mensaje;
import com.Softcaribean.Veterinaria.dto.RafPacienteDto;
import com.Softcaribean.Veterinaria.exception.ConException;
import com.Softcaribean.Veterinaria.facade.RafPacienteFac;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RafPacienteConImp {

    @Autowired
    private RafPacienteFac rafPacienteFac;

    @CrossOrigin
    @PostMapping("/paciente/save")
    public ResponseEntity<Mensaje> save(@RequestBody RafPacienteDto rafPacienteDto) throws ConException {
        Mensaje mensaje = new Mensaje();
        try {
            rafPacienteFac.save(rafPacienteDto);
            mensaje.setCodigo(0);
            mensaje.setMensaje("El paciente fue guardada");
        } catch (Exception ex) {
            mensaje.setCodigo(1);
            mensaje.setMensaje("Error al guardar el paciente ");
            throw new ConException(ex);
        }
        return ResponseEntity.ok(mensaje);
    }


    /*
    @CrossOrigin
    @PostMapping("/paciente/delete")
    public ResponseEntity<Mensaje> delete(@RequestBody RafPacienteDto rafPacienteDto) throws ConException {
        Mensaje mensaje = new Mensaje();
        try {
            rafPacienteFac.delete(rafPacienteDto);
            mensaje.setCodigo(0);
            mensaje.setMensaje("El paciente fue eliminado");
        } catch (Exception ex) {
            mensaje.setCodigo(1);
            mensaje.setMensaje("Error al borrar");
            throw new ConException(ex);
        }
        return ResponseEntity.ok(mensaje);
    }
     */


    @CrossOrigin
    @GetMapping("/paciente/getall")
    public ResponseEntity<Mensaje> getall() throws ConException {
        Mensaje mensaje = new Mensaje();
        try {
            List<RafPacienteDto> list = rafPacienteFac.getall();
            mensaje.setCodigo(0);
            mensaje.setMensaje("Datos completos ");
            mensaje.setData(list);
        } catch (Exception ex) {
            mensaje.setCodigo(1);
            mensaje.setMensaje("Error al mostrar datos ");
            throw new ConException(ex);
        }
        return ResponseEntity.ok(mensaje);
    }
}
