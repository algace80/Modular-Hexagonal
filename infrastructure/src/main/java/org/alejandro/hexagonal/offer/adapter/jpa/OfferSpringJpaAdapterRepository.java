package org.alejandro.hexagonal.offer.adapter.jpa;


import org.alejandro.hexagonal.offer.adapter.entity.OfferEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfferSpringJpaAdapterRepository extends JpaRepository<OfferEntity, Long> {

}