package com.bootcamp.ms.profile.repository.specification;

import com.bootcamp.ms.profile.model.User;
import com.bootcamp.ms.profile.util.BootcampUtil;
import com.bootcamp.ms.profile.queryparam.UserQueryParam;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class UserSpecification extends BaseEntitySpecification<User, UserQueryParam> {

    public UserSpecification(UserQueryParam params) {
        super(params);
    }

    @Override
    public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
        Predicate superPredicate = super.toPredicate(root, query, builder);

        List<Predicate> predicates = new ArrayList<>();
        if (superPredicate != null) {
            predicates.add(superPredicate);
        }

        if (queryParam.getName() != null) {
            predicates.add(builder.equal(root.get("name"), queryParam.getName()));
        }

        if (queryParam.getGender() != null) {
            predicates.add(builder.equal(root.get("gender"), queryParam.getGender()));
        }
        return builder.and(predicates.toArray(new Predicate[]{}));
    }

}