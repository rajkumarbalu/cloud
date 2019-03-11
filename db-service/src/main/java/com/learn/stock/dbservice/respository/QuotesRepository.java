package com.learn.stock.dbservice.respository;

import java.util.List;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.learn.stock.dbservice.model.Quote;

@EnableJpaRepositories(basePackages="com.learn.stock.dbservice.respository")
@SpringBootApplication
public interface QuotesRepository extends JpaRepository<Quote, Integer> {

	List<Quote> findByUserName(String username);

}
