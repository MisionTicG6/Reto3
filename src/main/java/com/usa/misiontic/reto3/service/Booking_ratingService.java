package com.usa.misiontic.reto3.service;

import com.usa.misiontic.reto3.entities.Booking_rating;
import com.usa.misiontic.reto3.repository.Booking_ratingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Booking_ratingService {

    @Autowired
    private Booking_ratingRepository booking_ratingRepository;

    public List<Booking_rating> getAll(){
        return booking_ratingRepository.getAll();
    }

    public Optional<Booking_rating> getBooking(int id) {return booking_ratingRepository.getBooking(id); }

    public Booking_rating save(Booking_rating c){
        if(c.getId()==null){
            return booking_ratingRepository.save(c);
        }else{
            Optional<Booking_rating> e=booking_ratingRepository.getBooking(c.getId());
            if (e.isPresent()){
                return c;
            }else{
                return booking_ratingRepository.save(c);
            }
        }
    }

    public Booking_rating update(Booking_rating c){
        if(c.getId()!=null){
            Optional<Booking_rating> q=booking_ratingRepository.getBooking(c.getId());
            if (q.isPresent()){
                if(c.getValue()!=null){
                    q.get().setValue(c.getValue());
                }
                if(c.getText()!=null){
                    q.get().setText(c.getText());
                }
                booking_ratingRepository.save(q.get());
                return q.get();
            }else{
                return c;
            }
        }else{
            return c;
        }
    }

    public boolean delete(int id){
        boolean flag=false;
        Optional<Booking_rating> c=booking_ratingRepository.getBooking(id);
        if(c.isPresent()){
            booking_ratingRepository.delete(c.get());
            flag=true;
        }
        return flag;
    }
}
