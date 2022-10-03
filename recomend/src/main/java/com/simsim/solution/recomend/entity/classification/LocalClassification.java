package com.simsim.solution.recomend.entity.classification;

import com.simsim.solution.recomend.entity.base.DetailBaseEntity;
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
@Table(name = "LOCAL_CLASSIFICATION")
public class LocalClassification extends DetailBaseEntity {

    @EmbeddedId
    private Pk pk;

    @Embeddable
    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Pk implements Serializable {
        @Column(name = "city")
        private String city;

        @Column(name = "gu")
        private String gu;

        @Column(name = "load")
        private String load;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pk pk = (Pk) o;
            return this.city.equals(pk.city) &&
                    this.gu.equals(pk.gu) &&
                    this.load.equals(pk.load);

        }

        @Override
        public int hashCode() {
            return Objects.hash(city,gu,load);
        }
    }
}
