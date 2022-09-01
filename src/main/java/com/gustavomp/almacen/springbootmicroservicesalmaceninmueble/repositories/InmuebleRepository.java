package com.gustavomp.almacen.springbootmicroservicesalmaceninmueble.repositories;

import com.gustavomp.almacen.springbootmicroservicesalmaceninmueble.models.Inmueble;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InmuebleRepository extends JpaRepository<Inmueble, Long> {

}
