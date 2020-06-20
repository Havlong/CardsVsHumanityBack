package ru.havlong.cards.store.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.havlong.cards.api.dto.SampleDTO;

import javax.persistence.*;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "sample")
public class Sample {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    public static void fromDTO(SampleDTO dto, Sample ent) {

        ent.setId(dto.getId());
    }
}