package com.gustavomp.almacen.springbootmicroservicesalmaceninmueble.controllers;

import com.gustavomp.almacen.springbootmicroservicesalmaceninmueble.models.Inmueble;
import com.gustavomp.almacen.springbootmicroservicesalmaceninmueble.services.InmuebleService;
import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/inmuebles")
public class InmuebleController {

    @Autowired
    private InmuebleService inmuebleService;

    @GetMapping
    public ResponseEntity<List<Inmueble>> findAllInmuebles() {
        return new ResponseEntity<>(this.inmuebleService.findAllInmuebles(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Inmueble> saveInmueble(@RequestBody Inmueble inmueble) {
        return new ResponseEntity<>(this.inmuebleService.saveInmueble(inmueble), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInmueble(@PathVariable Long id) {
        this.inmuebleService.deleteInmueble(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
