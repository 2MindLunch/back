package com.simsim.solution.recomend.entity;

import com.simsim.solution.recomend.entity.base.DetailBaseEntity;
import com.simsim.solution.recomend.entity.classification.FoodClassification;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "AD_REVENUE")
public class adRevenue extends DetailBaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "seq")
    private Long seq;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "nation", referencedColumnName = "nation"),
            @JoinColumn(name = "major_classification", referencedColumnName = "major_classification"),
            @JoinColumn(name = "food", referencedColumnName = "food")})
    private FoodClassification foodClassification;

    @Column(name = "amount")
    private BigDecimal amount;
}
