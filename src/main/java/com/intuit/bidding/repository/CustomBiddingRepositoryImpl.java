package com.intuit.bidding.repository;

import com.intuit.bidding.core.BiddingSearchRequest;
import com.intuit.bidding.core.entity.Bidding;
import com.intuit.bidding.repository.QueryBuilder.FilterQueryCreator;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;

@Repository
public class CustomBiddingRepositoryImpl implements CustomBiddingRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Bidding> filterBids(BiddingSearchRequest biddingSearchRequest) {
        return setResultCount(biddingSearchRequest.getCount(), FilterQueryCreator.createFilterQuery(entityManager, biddingSearchRequest)).getResultList();
    }

    private TypedQuery<Bidding> setResultCount(Integer count, TypedQuery<Bidding> biddingTypedQuery) {
        if (Objects.nonNull(count) && Objects.nonNull(biddingTypedQuery)) {
            biddingTypedQuery.setMaxResults(count);
        }
        return biddingTypedQuery;
    }
}
