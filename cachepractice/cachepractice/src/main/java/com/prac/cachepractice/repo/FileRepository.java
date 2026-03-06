package com.prac.cachepractice.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prac.cachepractice.entity.FileData;

public interface FileRepository extends JpaRepository<FileData, Long>{

}
