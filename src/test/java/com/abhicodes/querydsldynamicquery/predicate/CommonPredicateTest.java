package com.abhicodes.querydsldynamicquery.predicate;

import com.abhicodes.querydsldynamicquery.entity.QUsers;
import com.abhicodes.querydsldynamicquery.entity.Users;
import com.abhicodes.querydsldynamicquery.utils.SearchCriteria;
import com.querydsl.core.types.dsl.BooleanExpression;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CommonPredicateTest {

	@Test
	void givenSimpleExpression_whenBuild_thenPredicate() {
		String filter = "fullName-vogel";
		SearchCriteria simpleCriteria = SearchCriteria.validateFilterPattern(filter);
		assertThat(simpleCriteria).isNotNull();
		assertThat(simpleCriteria.getKey()).isNotNull();
		assertThat(simpleCriteria.getOperator()).isNotNull();
		assertThat(simpleCriteria.getValue()).isNotNull();
		List<SearchCriteria> criteria = new ArrayList<>();
		criteria.add(simpleCriteria);
		BooleanExpression exp = new CommonPredicateBuilder<>(Users.class).build();
		QUsers qUsersPath = QUsers.users;
		exp = exp.and(new CommonPredicateBuilder<>(Users.class).and(simpleCriteria).build());
		assertThat(exp).isNotNull();
		System.out.println(exp);
	}

	@Test
	void givenMultipleFilterExpressions_whenBuild_thenPredicate() {
		List<String> filters = Arrays.asList("fullName-vogel", "userName-tvogel");

		BooleanExpression exp = new CommonPredicateBuilder<>(Users.class).build();
		QUsers qUsersPath = QUsers.users;
		for (String filter : filters) {
			SearchCriteria criteria = SearchCriteria.validateFilterPattern(filter);
			exp = exp.and(new CommonPredicateBuilder<>(Users.class).and(criteria).build());
		}

		assertThat(exp).isNotNull();
		System.out.println(exp);
	}

	@Test
	void givenSeparateFilterExpressions_whenManualBuild_thenSimplePredicate() {
		List<BooleanExpression> predicates = new ArrayList<>();
		predicates.add(new CommonPredicateBuilder<>(Users.class).and(
				SearchCriteria.builder().key("fullName").operator("-").value("vogel").build()).build());
		predicates.add(new CommonPredicateBuilder<>(Users.class).and(
				SearchCriteria.builder().key("userName").operator("-").value("tvogel").build()).build());

		BooleanExpression exp = new CommonPredicateBuilder<>(Users.class).build();
		QUsers qUsersPath = QUsers.users;
		for (BooleanExpression predicate : predicates) {
			//			exp = exp.and(predicate).
		}
	}
}