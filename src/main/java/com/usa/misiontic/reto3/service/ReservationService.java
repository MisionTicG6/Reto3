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

    public Optional<Reservation> getCar(int id) {return reservationRepository.getReservation(id); }

    public Reservation save(Reservation c){
        if(c.getIdReservation()==null){
            return reservationRepository.save(c);
        }else{
            Optional<Reservation> e= reservationRepository.getReservation(c.getIdReservation());
            if (e.isPresent()){
                return c;
            }else{
                return reservationRepository.save(c);
            }
        }
    }

    public Reservation update(Reservation c){
        if(c.getIdReservation()!=null){
            Optional<Reservation> q= reservationRepository.getReservation(c.getIdReservation());
            if (q.isPresent()){
                if(c.getStartDate()!=null){
                    q.get().setStartDate(c.getStartDate());
                }
                if(c.getDevolutionDate()!=null){
                    q.get().setDevolutionDate(c.getDevolutionDate());
                }
                if(c.getStatus()!=null){
                    q.get().setStatus(c.getStatus());
                }
                if(c.getClient()!=null){
                    q.get().setClient(c.getClient());
                }
                if(c.getCar()!=null){
                    q.get().setCar(c.getCar());
                }
                if(c.getScore()!=null){
                    q.get().setScore(c.getScore());
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
        Optional<Reservation> c= reservationRepository.getReservation(id);
        if(c.isPresent()){
            reservationRepository.delete(c.get());
            flag=true;
        }
        return flag;
    }
}
