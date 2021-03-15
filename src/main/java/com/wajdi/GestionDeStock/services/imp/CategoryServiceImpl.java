package com.wajdi.GestionDeStock.services.imp;

import com.wajdi.GestionDeStock.dto.ArticleDto;
import com.wajdi.GestionDeStock.dto.CategoryDto;
import com.wajdi.GestionDeStock.exception.EntityNotFoundException;
import com.wajdi.GestionDeStock.exception.ErrorCodes;
import com.wajdi.GestionDeStock.exception.InvalidEntityException;
import com.wajdi.GestionDeStock.model.Category;
import com.wajdi.GestionDeStock.respository.CategoryRepository;
import com.wajdi.GestionDeStock.services.CategoryService;
import com.wajdi.GestionDeStock.validator.CategoryValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }
    @Override
    public CategoryDto save(CategoryDto dto) {
        List<String> errors = CategoryValidator.validate(dto);
        if(!errors.isEmpty()){
            log.error("Category is not valid {}",dto);
            throw new InvalidEntityException("La categorie n'est pas valide", ErrorCodes.CATEGORY_NOT_VALIDE,errors);
        }
        return CategoryDto.fromEntity(
                categoryRepository.save(CategoryDto.toEntity(dto))
        );
    }

    @Override
    public CategoryDto findById(Integer id) {
        if(id == null){
            log.error("L'id est null");
        }
        Optional<Category> category= categoryRepository.findById(id);
        return Optional.of(CategoryDto.fromEntity(category.get())).orElseThrow( ()->
                new EntityNotFoundException("Aucun category avec l'id:"+id+"dans la BDD",ErrorCodes.CATEGORY_NOT_FOUND)
        );
    }

    @Override
    public CategoryDto findByCode(String code) {
        if(code == null){
            log.error("L'id est null");
        }
        Optional<Category> category= categoryRepository.findCategoryByCode(code);
        return Optional.of(CategoryDto.fromEntity(category.get())).orElseThrow( ()->
                new EntityNotFoundException("Aucun category avec le code:"+code+"dans la BDD",ErrorCodes.CATEGORY_NOT_FOUND)
        );
    }

    @Override
    public List<CategoryDto> findAll() {

        return categoryRepository.findAll().stream()
                .map(CategoryDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        categoryRepository.deleteById(id);
    }
}
