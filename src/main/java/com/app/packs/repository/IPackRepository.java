package com.app.packs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
@NoRepositoryBean
public interface IPackRepository<T> extends JpaRepository<T, Long>{

}
