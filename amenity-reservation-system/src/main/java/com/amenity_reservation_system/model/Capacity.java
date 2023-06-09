package com.amenity_reservation_system.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Capacity {
    public Capacity(AmenityType amenityType, int capacity){
        this.amenityType=amenityType;
        this.capacity=capacity;
    }

    @Id
    @Column(nullable = false,updatable = false)
    @SequenceGenerator(
            name="primary_sequence",
            sequenceName="primary_sequence",
            allocationSize = 1,
            initialValue=10000
    )
    @GeneratedValue(
            strategy=GenerationType.SEQUENCE,
            generator="primary_squence"
    )
    private Long id;

    @Column(nullable=false,unique=true)
    @Enumerated(EnumType.STRING)
    private AmenityType amenityType;

    @Column(nullable = false)
    private int capacity;
}
