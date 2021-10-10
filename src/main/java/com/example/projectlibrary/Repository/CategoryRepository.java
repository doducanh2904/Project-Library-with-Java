package com.example.projectlibrary.Repository;

import com.example.projectlibrary.Model.Category;
import com.example.projectlibrary.Model.Libraryan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category,Long> {
}
