package com.yatsenko.bootcampspring.repository;

import com.yatsenko.bootcampspring.entity.Cat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CatRepository extends JpaRepository<Cat,Long> {
}
