package com.usa.misiontic.reto3.repository;

import com.usa.misiontic.reto3.entities.Booking;
import com.usa.misiontic.reto3.repository.crudRepository.BookingCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class BookingRepository {

    @Autowired
    private BookingCrudRepository bookingCrudRepository;

    public List<Booking> getAll(){
        return (List<Booking>) bookingCrudRepository.findAll();
    }

    public Optional<Booking> getBooking(int id){
        return bookingCrudRepository.findById(id);
    }

    public Booking save(Booking c){
        return bookingCrudRepository.save(c);
    }

    public void delete(Booking c){
        bookingCrudRepository.delete(c);
    }
}
