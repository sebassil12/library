package com.querys.query.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.querys.query.model.Genre;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Long> {
}
