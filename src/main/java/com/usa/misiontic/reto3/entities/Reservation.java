package com.usa.misiontic.reto3.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "reservations")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "client_id")
    @JsonIgnoreProperties("reservations")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "car_id")
    @JsonIgnoreProperties("reservations")
    private Car car;

//    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "reservations")
//    @JsonIgnoreProperties("reservations")
//    private List<Booking_rating> bookings_rating;

    private Date startDate;
    private Date devolutionDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getDevolutionDate() {
        return devolutionDate;
    }

    public void setDevolutionDate(Date devolutionDate) {
        this.devolutionDate = devolutionDate;
    }

//    public List<Booking_rating> getBookings_rating() {
//        return bookings_rating;
//    }
//
//    public void setBookings_rating(List<Booking_rating> bookings_rating) {
//        this.bookings_rating = bookings_rating;
//    }


}
