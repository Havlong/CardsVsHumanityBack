package ru.havlong.cards.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.havlong.cards.store.entity.Sample;

import java.util.stream.Stream;

public interface SampleRepository extends JpaRepository<Sample, String> {

    @Query("SELECT s FROM Sample s " +
            "ORDER BY s.id DESC")
    Stream<Sample> fetchAllSortedStream();
}