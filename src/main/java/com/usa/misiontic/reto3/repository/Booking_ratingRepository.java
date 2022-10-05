package com.usa.misiontic.reto3.repository;

import com.usa.misiontic.reto3.entities.Booking_rating;
import com.usa.misiontic.reto3.repository.crudRepository.Booking_ratingCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class Booking_ratingRepository {

    @Autowired
    private Booking_ratingCrudRepository booking_ratingCrudRepository;

    public List<Booking_rating> getAll(){
        return (List<Booking_rating>) booking_ratingCrudRepository.findAll();
    }

    public Optional<Booking_rating> getBooking(int id){
        return booking_ratingCrudRepository.findById(id);
    }

    public Booking_rating save(Booking_rating c){
        return booking_ratingCrudRepository.save(c);
    }

    public void delete(Booking_rating c){
        booking_ratingCrudRepository.delete(c);
    }
}
