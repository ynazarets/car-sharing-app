package app.start.model;

import app.start.model.enums.RentalStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "rentals")
public class Rental {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // СВЯЗЬ 1: Кто арендовал (МНОГИЕ аренды к ОДНОМУ пользователю)
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    // СВЯЗЬ 2: Какую машину арендовали (МНОГИЕ аренды к ОДНОЙ машине)
    @ManyToOne
    @JoinColumn(name = "car_id", nullable = false)
    private Car car;

    @Column(name = "start_time", nullable = false)
    private LocalDateTime startTime;

    @Column(name = "end_time")
    private LocalDateTime endTime; // Может быть null, пока аренда активна

    @Column(name = "total_cost")
    private Double totalCost;

    // Статус самой аренды (ACTIVE, COMPLETED, CANCELLED)
    @Enumerated(EnumType.STRING)
    @Column(name = "rental_status", nullable = false)
    private RentalStatus rentalStatus;
}
