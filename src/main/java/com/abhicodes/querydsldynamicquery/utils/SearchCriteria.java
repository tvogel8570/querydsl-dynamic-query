package com.abhicodes.querydsldynamicquery.utils;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Getter
@ToString
@Builder
public class SearchCriteria {
	private String key;
	private String operator;
	private String value;

	public static SearchCriteria validateFilterPattern(String filter) {
		final Pattern pattern = Pattern.compile("([\\w.]+?)(:|<|>|<=|>=|%|-|\\(\\))([\\w\\s\\(\\),.:-]+?)\\|");
		Matcher m = pattern.matcher(filter + "|");
		if (m.find()) {
			return SearchCriteria.builder().key(m.group(1)).operator(m.group(2)).value(m.group(3)).build();
		} else {
			throw new RuntimeException("Invalid Filter format");
		}
	}

}