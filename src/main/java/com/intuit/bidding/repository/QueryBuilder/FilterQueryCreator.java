package com.intuit.bidding.repository.QueryBuilder;

import com.intuit.bidding.core.BiddingSearchRequest;
import com.intuit.bidding.core.entity.Bidding;
import com.intuit.bidding.core.enums.BiddingSortEnum;
import com.intuit.bidding.repository.QueryBuilder.filters.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.*;
import org.springframework.util.CollectionUtils;

import java.util.*;

public class FilterQueryCreator {
    public static TypedQuery<Bidding> createFilterQuery(EntityManager entityManager, BiddingSearchRequest biddingSearchRequest) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Bidding> query = builder.createQuery(Bidding.class);
        Root<Bidding> root = query.from(Bidding.class);
        List<Predicate> predicates = new ArrayList<>();
        for (AbstractFilterAdder filterAdder : getFilterList()) {
            filterAdder.addFilter(biddingSearchRequest, builder, root, predicates);
        }
        query = addSort(biddingSearchRequest.getSort(), root, builder, query);
        query.where(builder.and(predicates.toArray(new Predicate[0])));
        return entityManager.createQuery(query);
    }

    private static CriteriaQuery<Bidding> addSort(Set<BiddingSortEnum> sortEnumSet, Root<Bidding> root, CriteriaBuilder builder, CriteriaQuery<Bidding> query) {
        List<Order> orderList = new ArrayList<>();
        if(sortEnumSet.isEmpty()){
            return query;
        }
        if(sortEnumSet.contains(BiddingSortEnum.PRICE_ASC) || sortEnumSet.contains(BiddingSortEnum.PRICE_DESC)){
            getPriceSort(orderList,sortEnumSet,root,builder,query);
        }
        if (sortEnumSet.contains(BiddingSortEnum.TIMESTAMP_DESC) || sortEnumSet.contains(BiddingSortEnum.TIMESTAMP_ASC)) {
            getTimeStampSort(orderList,sortEnumSet,root,builder,query);
        }
        return query;
    }

    private static void getPriceSort(List<Order> orderList,Set<BiddingSortEnum> sortEnumSet, Root<Bidding> root, CriteriaBuilder builder, CriteriaQuery<Bidding> query) {
        if (sortEnumSet.contains(BiddingSortEnum.PRICE_ASC)) {
            orderList.add(builder.asc(root.get("bidPrice")));
        }
        else if (sortEnumSet.contains(BiddingSortEnum.PRICE_DESC)) {
            orderList.add(builder.desc(root.get("bidPrice")));
        }
    }

    private static void getTimeStampSort(List<Order> orderList,Set<BiddingSortEnum> sortEnumSet, Root<Bidding> root, CriteriaBuilder builder, CriteriaQuery<Bidding> query) {
        if (sortEnumSet.contains(BiddingSortEnum.TIMESTAMP_ASC)) {
            orderList.add(builder.asc(root.get("timeStamp")));
        }
        else if (sortEnumSet.contains(BiddingSortEnum.TIMESTAMP_DESC)) {
            orderList.add(builder.desc(root.get("timeStamp")));
        }
    }

    public static List<AbstractFilterAdder> getFilterList() {
        List<AbstractFilterAdder> filterAdders = new ArrayList<>();
        filterAdders.add(new AuctionIdFilterAdder());
        filterAdders.add(new BidStatusFilterAdder());
        filterAdders.add(new EndTimeStampFilterAdder());
        filterAdders.add(new StartTimeStampFilterAdder());
        filterAdders.add(new UserIdFilterAdder());
        return filterAdders;
    }


}
