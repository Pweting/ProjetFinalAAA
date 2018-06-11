package com.springboot.pkg.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.pkg.model.Module;

public interface ModuleRepository extends JpaRepository<Module, Long> {

}
