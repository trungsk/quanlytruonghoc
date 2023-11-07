package com.seabank.quanlytruonghoc.repository;

import com.seabank.quanlytruonghoc.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
    @Query(value = "select * from accounts", nativeQuery = true)
    List<Account> getAll();
}
