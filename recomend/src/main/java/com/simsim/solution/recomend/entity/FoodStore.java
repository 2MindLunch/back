package com.simsim.solution.recomend.entity;

import com.simsim.solution.recomend.entity.base.DetailBaseEntity;
import com.simsim.solution.recomend.entity.classification.LocalClassification;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "FOOD_STORE")
public class FoodStore extends DetailBaseEntity {

    @EmbeddedId
    private Pk pk;


    @MapsId("localClassificationFk")
    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "city", referencedColumnName = "city"),
            @JoinColumn(name = "gu", referencedColumnName = "gu"),
            @JoinColumn(name = "load", referencedColumnName = "load")})
    private LocalClassification localClassification;


    @Embeddable
    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Pk implements Serializable {

        private LocalClassification.Pk localClassificationFk;

        @Column(name = "store_name")
        private String storeName;

        @Column(name = "seq", unique = true)
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long seq;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pk pk = (Pk) o;
            return this.localClassificationFk.getCity().equals(pk.localClassificationFk.getCity()) &&
                   this.localClassificationFk.getGu().equals(pk.localClassificationFk.getGu()) &&
                   this.localClassificationFk.getLoad().equals(pk.localClassificationFk.getLoad()) &&
                   this.storeName.equals(pk.storeName) &&
                    this.seq.equals(pk.seq);
        }

        @Override
        public int hashCode() {
            return Objects.hash(localClassificationFk,storeName,seq);
        }
    }



}
