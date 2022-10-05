package com.usa.misiontic.reto3.service;

import com.usa.misiontic.reto3.entities.Booking;
import com.usa.misiontic.reto3.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    public List<Booking> getAll(){
        return bookingRepository.getAll();
    }

    public Optional<Booking> getCar(int id) {return bookingRepository.getBooking(id); }

    public Booking save(Booking c){
        if(c.getId()==null){
            return bookingRepository.save(c);
        }else{
            Optional<Booking> e=bookingRepository.getBooking(c.getId());
            if (e.isPresent()){
                return c;
            }else{
                return bookingRepository.save(c);
            }
        }
    }

    public Booking update(Booking c){
        if(c.getId()!=null){
            Optional<Booking> q=bookingRepository.getBooking(c.getId());
            if (q.isPresent()){
                if(c.getClient()!=null){
                    q.get().setClient(c.getClient());
                }
                if(c.getCreateDate()!=null){
                    q.get().setCreateDate(c.getCreateDate());
                }
                if(c.getFinish_date()!=null){
                    q.get().setFinish_date(c.getFinish_date());
                }
                if(c.getStart_date()!=null){
                    q.get().setStart_date(c.getStart_date());
                }
                if(c.getStatus()!=null){
                    q.get().setStatus(c.getStatus());
                }
                if(c.getCar()!=null){
                    q.get().setCar(c.getCar());
                }
                bookingRepository.save(q.get());
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
        Optional<Booking> c=bookingRepository.getBooking(id);
        if(c.isPresent()){
            bookingRepository.delete(c.get());
            flag=true;
        }
        return flag;
    }
}
