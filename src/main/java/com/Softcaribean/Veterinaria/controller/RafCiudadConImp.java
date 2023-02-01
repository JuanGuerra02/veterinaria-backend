package com.Softcaribean.Veterinaria.controller;

import com.Softcaribean.Veterinaria.dto.Mensaje;
import com.Softcaribean.Veterinaria.exception.ConException;
import com.Softcaribean.Veterinaria.facade.RafCiudadFac;
import com.Softcaribean.Veterinaria.dto.RafCiudadDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RafCiudadConImp {

    @Autowired
    private RafCiudadFac rafCiudadFac;


    @CrossOrigin
    @GetMapping("/ciudad/getall")
    public ResponseEntity<Mensaje> getall() throws ConException {
        Mensaje mensaje = new Mensaje();
        try {
            List<RafCiudadDto> list = rafCiudadFac.getall();
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
