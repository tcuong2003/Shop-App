package org.tc.backend.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.tc.backend.models.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
