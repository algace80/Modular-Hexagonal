package org.alejandro.hexagonal.offer.adapter.jpa.repository;

import org.alejandro.hexagonal.offer.model.exception.OfferNotFoundException;
import org.alejandro.hexagonal.offer.model.exception.util.ErrorCatalog;
import org.alejandro.hexagonal.offer.adapter.entity.OfferEntity;
import org.alejandro.hexagonal.offer.adapter.mapper.OfferDboMapper;
import org.alejandro.hexagonal.offer.model.entity.Offer;
import org.alejandro.hexagonal.offer.adapter.jpa.OfferSpringJpaAdapterRepository;
import org.alejandro.hexagonal.offer.port.out.repository.OfferRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public class OfferH2Repository implements OfferRepository {

    private final OfferSpringJpaAdapterRepository offerSpringJpaAdapterRepository;
    private final OfferDboMapper offerDboMapper;

    public OfferH2Repository(OfferSpringJpaAdapterRepository offerSpringJpaAdapterRepository, OfferDboMapper offerDboMapper) {
        this.offerSpringJpaAdapterRepository = offerSpringJpaAdapterRepository;
        this.offerDboMapper = offerDboMapper;
    }

    @Override
    public Offer create(Offer offer) {
        OfferEntity offerToSave = offerDboMapper.toDboCreate(offer);
        OfferEntity offerSaved = offerSpringJpaAdapterRepository.save(offerToSave);
        return offerDboMapper.toDomain(offerSaved);
    }

    @Override
    public Offer update(Offer offer) {
        OfferEntity offerToUpdate = offerDboMapper.toDboUpdate(offer);
        offerSpringJpaAdapterRepository.findById(offerToUpdate.getId())
                .orElseThrow(() -> new OfferNotFoundException(
                        ErrorCatalog.OFFER_NOT_FOUND.getCode(),
                        String.format(ErrorCatalog.OFFER_NOT_FOUND.getMessage(), offerToUpdate.getId())));
        OfferEntity offerUpdated = offerSpringJpaAdapterRepository.save(offerToUpdate);
        return offerDboMapper.toDomain(offerUpdated);
    }

    @Override
    public void deleteById(Long id) {
        offerSpringJpaAdapterRepository.findById(id).orElseThrow(() -> new OfferNotFoundException(
                ErrorCatalog.OFFER_NOT_FOUND.getCode(),
                String.format(ErrorCatalog.OFFER_NOT_FOUND.getMessage(), id)));
        offerSpringJpaAdapterRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        offerSpringJpaAdapterRepository.deleteAll();
    }

}
