package org.alejandro.hexagonal.offer.adapter.jpa.dao;

import org.alejandro.hexagonal.offer.model.exception.OfferNotFoundException;
import org.alejandro.hexagonal.offer.model.exception.util.ErrorCatalog;
import org.alejandro.hexagonal.offer.adapter.entity.OfferEntity;
import org.alejandro.hexagonal.offer.adapter.jpa.OfferSpringJpaAdapterRepository;
import org.alejandro.hexagonal.offer.adapter.mapper.OfferDboMapper;
import org.alejandro.hexagonal.offer.model.entity.Offer;
import org.alejandro.hexagonal.offer.port.out.dao.OfferDao;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;


@Repository
public class OfferH2Dao implements OfferDao {

    private final OfferSpringJpaAdapterRepository offerSpringJpaAdapterRepository;
    private final OfferDboMapper offerDboMapper;

    public OfferH2Dao(OfferSpringJpaAdapterRepository offerSpringJpaAdapterRepository, OfferDboMapper offerDboMapper) {
        this.offerSpringJpaAdapterRepository = offerSpringJpaAdapterRepository;
        this.offerDboMapper = offerDboMapper;
    }

    @Override
    public Offer getById(Long id) {

        OfferEntity offerEntity = offerSpringJpaAdapterRepository.findById(id)
                .orElseThrow(() -> new OfferNotFoundException(
                        ErrorCatalog.OFFER_NOT_FOUND.getCode(),
                        String.format(ErrorCatalog.OFFER_NOT_FOUND.getMessage(), id)));

        return offerDboMapper.toDomain(offerEntity);
    }

    @Override
    public List<Offer> getAll() {
        return offerSpringJpaAdapterRepository.findAll()
                .stream()
                .map(offerDboMapper::toDomain)
                .collect(Collectors.toList());
    }
}
