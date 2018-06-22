package com.github.adamflorczak.Controller;

import com.github.adamflorczak.model.Rent;
import com.github.adamflorczak.model.RentCreateDTO;
import com.github.adamflorczak.model.RentDTO;
import com.github.adamflorczak.service.RentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/api/rents")
public class RentController {


    private RentService rentService;

    @Autowired
    public RentController(RentService rentService) {
        this.rentService = rentService;
    }

    @GetMapping("/{id}")
    public RentDTO findById(@PathVariable Long id){
        Rent rent = rentService.findOneById(id);
        return new RentDTO(rent);
    }

    @GetMapping
    public Set<RentDTO> findAll(){
        Set<RentDTO> result = new HashSet<>();
        Set<Rent> rents = rentService.findAll();

        rents.forEach(b->result.add(new RentDTO(b)));
        return result;
    }

    @PostMapping
    public RentDTO rentBook(@RequestBody RentCreateDTO rentDTO){
       return rentService.rentBook(rentDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteRent(@PathVariable Long id){
        rentService.deleteOneById(id);
    }
}
