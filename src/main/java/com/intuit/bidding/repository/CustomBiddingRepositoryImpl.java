package com.intuit.bidding.repository;

import com.intuit.bidding.core.BiddingSearchRequest;
import com.intuit.bidding.core.entity.Bidding;
import com.intuit.bidding.core.enums.BiddingSortEnum;
import com.intuit.bidding.repository.QueryBuilder.FilterQueryCreator;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.*;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class CustomBiddingRepositoryImpl implements CustomBiddingRepository {

    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<Bidding> filterBids(BiddingSearchRequest biddingSearchRequest) {
        return FilterQueryCreator.createFilterQuery(entityManager,biddingSearchRequest).getResultList();
    }
}
