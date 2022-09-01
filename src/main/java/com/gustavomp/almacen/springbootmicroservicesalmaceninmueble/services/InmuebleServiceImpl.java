package com.gustavomp.almacen.springbootmicroservicesalmaceninmueble.services;

import com.gustavomp.almacen.springbootmicroservicesalmaceninmueble.models.Inmueble;
import com.gustavomp.almacen.springbootmicroservicesalmaceninmueble.repositories.InmuebleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InmuebleServiceImpl implements InmuebleService {

    @Autowired
    private InmuebleRepository inmuebleRepository;

    @Override
    public Inmueble saveInmueble(Inmueble inmueble) {
        return this.inmuebleRepository.save(inmueble);
    }

    @Override
    public void deleteInmueble(Long id) {
        this.inmuebleRepository.deleteById(id);
    }

    @Override
    public List<Inmueble> findAllInmuebles(){
        return this.inmuebleRepository.findAll();
    }
}
