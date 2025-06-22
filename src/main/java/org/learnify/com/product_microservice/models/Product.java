package org.learnify.com.product_microservice.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "product")
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private String title;
    private BigDecimal unitPrice;
    private boolean active;
    private String imageUrl;
    private int unitsInStock;
    @CreationTimestamp
    private LocalDate dateCreated;
    @UpdateTimestamp
    private LocalDate lastUpdated;

    //relationship between product and category
    // 1 C => M P and 1P => 1C
    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false) // nullable = false mean foreign key can't be null
    private Category category;

}
