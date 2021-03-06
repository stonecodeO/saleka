package com.saleka.application.configuration;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ConfigurationSiteRepository extends JpaRepository<ConfigurationSite, Long> {

}
