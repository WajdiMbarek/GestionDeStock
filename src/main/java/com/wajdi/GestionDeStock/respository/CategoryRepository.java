package com.wajdi.GestionDeStock.respository;

import com.wajdi.GestionDeStock.dto.CategoryDto;
import com.wajdi.GestionDeStock.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

    Optional<Category> findCategoryByCode(String code);
}
