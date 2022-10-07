package com.usa.misiontic.reto3.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "bookings")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "client_id")
    @JsonIgnoreProperties("booking")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "car_id")
    @JsonIgnoreProperties("bookings")
    private Car car;

    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "booking")
    @JsonIgnoreProperties("bookings")
    private List<Booking_rating> bookings_rating;

    private Date start_date;
    private Date finish_date;
    private String status;
    private LocalDateTime createDate;

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

    public List<Booking_rating> getBookings_rating() {
        return bookings_rating;
    }

    public void setBookings_rating(List<Booking_rating> bookings_rating) {
        this.bookings_rating = bookings_rating;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getFinish_date() {
        return finish_date;
    }

    public void setFinish_date(Date finish_date) {
        this.finish_date = finish_date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }
}
