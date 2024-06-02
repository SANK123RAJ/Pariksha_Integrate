package com.example.Pariksha_integrate;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "impressions")
public class Impression {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long impressionId;

    private String eventtype;
    private String togglename;
    private Boolean togglestate;
    private String context;
    private String identifier;

    @Column(name = "createdat", insertable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createdat;


}
