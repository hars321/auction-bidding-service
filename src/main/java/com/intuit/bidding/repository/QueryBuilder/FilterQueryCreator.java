package com.intuit.bidding.repository.QueryBuilder;

import com.intuit.bidding.core.entity.Bidding;
import com.intuit.bidding.core.enums.BiddingSortEnum;
import com.intuit.bidding.core.request.BiddingSearchRequest;
import com.intuit.bidding.repository.QueryBuilder.filters.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FilterQueryCreator {
    public static TypedQuery<Bidding> createFilterQuery(EntityManager entityManager, BiddingSearchRequest biddingSearchRequest){
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Bidding> query = builder.createQuery(Bidding.class);
        Root<Bidding> root = query.from(Bidding.class);
        List<Predicate> predicates = new ArrayList<>();
        for(AbstractFilterAdder filterAdder : getFilterList()){
            filterAdder.addFilter(biddingSearchRequest,builder,root,predicates);
        }
        query = addSort(biddingSearchRequest.getSort(),root,builder,query);
        query.where(builder.and(predicates.toArray(new Predicate[0])));
        return entityManager.createQuery(query);
    }

    private static CriteriaQuery<Bidding> addSort(BiddingSortEnum sortEnum, Root<Bidding> root, CriteriaBuilder builder, CriteriaQuery<Bidding> query) {
        Order order = null;
        if(Objects.nonNull(sortEnum) && BiddingSortEnum.ASC.equals(sortEnum)){
            order = builder.asc(root.get("bidPrice"));
        }
        if(Objects.nonNull(sortEnum) && BiddingSortEnum.DESC.equals(sortEnum)){
            order = builder.desc(root.get("bidPrice"));
        }
        if(Objects.nonNull(order)){
            query.orderBy(order);
        }
        return query;
    }

    public static List<AbstractFilterAdder> getFilterList(){
        List<AbstractFilterAdder> filterAdders = new ArrayList<>();
        filterAdders.add(new AuctionIdFilterAdder());
        filterAdders.add(new BidStatusFilterAdder());
        filterAdders.add(new EndTimeStampFilterAdder());
        filterAdders.add(new StartTimeStampFilterAdder());
        filterAdders.add(new UserIdFilterAdder());
        return filterAdders;
    }


}
