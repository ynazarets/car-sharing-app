package app.start.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "parkings")
public class Parking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "names", unique = true, nullable = false)
    private String name;

    @Column(name = "free_parkings_spaces", nullable = false)
    private int freeParkingSpace;

    @Column(name = "is_deleted")
    private boolean isDeleted = false;
}
