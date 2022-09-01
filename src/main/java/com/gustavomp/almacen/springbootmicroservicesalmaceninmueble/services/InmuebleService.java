package com.gustavomp.almacen.springbootmicroservicesalmaceninmueble.services;

import com.gustavomp.almacen.springbootmicroservicesalmaceninmueble.models.Inmueble;

import java.util.List;

public interface InmuebleService {

    Inmueble saveInmueble(Inmueble inmueble);

    void deleteInmueble(Long id);

    List<Inmueble> findAllInmuebles();
}
