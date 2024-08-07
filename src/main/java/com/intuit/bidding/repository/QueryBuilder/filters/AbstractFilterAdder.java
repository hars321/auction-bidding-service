package com.intuit.bidding.repository.QueryBuilder.filters;

import com.intuit.bidding.core.entity.Bidding;
import com.intuit.bidding.core.enums.FilterTypeEnum;
import com.intuit.bidding.core.request.BiddingSearchRequest;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

import java.util.List;

public abstract class AbstractFilterAdder {

    public void addFilter(BiddingSearchRequest biddingSearchRequest, CriteriaBuilder builder, Root<Bidding> root, List<Predicate> predicates){
        if(isValid(biddingSearchRequest)) {
            if(FilterTypeEnum.EQUAL.equals(getFilterTypeEnum())) {
                predicates.add(builder.equal(root.get(getFieldName()), getFieldValue(biddingSearchRequest)));
            }
            else if(FilterTypeEnum.GREATER_THAN_OR_EQUAL.equals(getFilterTypeEnum())){
                predicates.add(builder.greaterThanOrEqualTo(root.get(getFieldName()),Integer.valueOf(getFieldValue(biddingSearchRequest))));
            }
            else if(FilterTypeEnum.LESS_THAN_OR_EQUAL.equals(getFilterTypeEnum())){
                predicates.add(builder.lessThanOrEqualTo(root.get(getFieldName()),Integer.valueOf(getFieldValue(biddingSearchRequest))));
            }
        }
    }
    abstract String getFieldName();
    abstract FilterTypeEnum getFilterTypeEnum();
    abstract String getFieldValue(BiddingSearchRequest biddingSearchRequest);
    abstract boolean isValid(BiddingSearchRequest biddingSearchRequest);
}
