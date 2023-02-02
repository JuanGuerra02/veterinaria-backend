package com.Softcaribean.Veterinaria.controller;

import com.Softcaribean.Veterinaria.dto.Mensaje;
import com.Softcaribean.Veterinaria.dto.RafDuenoDto;
import com.Softcaribean.Veterinaria.exception.ConException;
import com.Softcaribean.Veterinaria.facade.RafDuenoFac;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
public class RafDuenoConImp {

    @Autowired
    private RafDuenoFac rafDuenoFac;

    @CrossOrigin
    @PostMapping("/dueno/save")
    public ResponseEntity<Mensaje> save(@RequestBody RafDuenoDto rafDuenoDto) throws ConException {
        Mensaje mensaje = new Mensaje();
        try {
            rafDuenoFac.save(rafDuenoDto);
            mensaje.setCodigo(0);
            mensaje.setMensaje("El dueño de la mascota fue guardada");
        } catch (Exception ex) {
            mensaje.setCodigo(1);
            mensaje.setMensaje("Error al guardar el paciente ");
            throw new ConException(ex);
        }
        return ResponseEntity.ok(mensaje);
    }

    @CrossOrigin
    @GetMapping("/dueno/getall")
    public ResponseEntity<Mensaje> getall() throws ConException {
        Mensaje mensaje = new Mensaje();
        try {
            List<RafDuenoDto> list = rafDuenoFac.getall();
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
