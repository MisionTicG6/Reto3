package com.usa.misiontic.reto3.service;

import com.usa.misiontic.reto3.entities.Reservation;
import com.usa.misiontic.reto3.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation> getAll(){
        return reservationRepository.getAll();
    }

    public Optional<Reservation> getCar(int id) {return reservationRepository.getBooking(id); }

    public Reservation save(Reservation c){
        if(c.getIdReservation()==null){
            return reservationRepository.save(c);
        }else{
            Optional<Reservation> e= reservationRepository.getBooking(c.getIdReservation());
            if (e.isPresent()){
                return c;
            }else{
                return reservationRepository.save(c);
            }
        }
    }

    public Reservation update(Reservation c){
        if(c.getIdReservation()!=null){
            Optional<Reservation> q= reservationRepository.getBooking(c.getIdReservation());
            if (q.isPresent()){
                if(c.getClient()!=null){
                    q.get().setClient(c.getClient());
                }
                if(c.getCar()!=null){
                    q.get().setCar(c.getCar());
                }

                reservationRepository.save(q.get());
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
        Optional<Reservation> c= reservationRepository.getBooking(id);
        if(c.isPresent()){
            reservationRepository.delete(c.get());
            flag=true;
        }
        return flag;
    }
}
