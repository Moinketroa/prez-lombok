package com.excilys.prezlombok.cdb.cheatsheet.mapper;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public interface Mapper<T, U> extends Function<T, U> {

    U map(T input);

    @Override
    default U apply(T in) {
        return map(in);
    }

    default List<U> mapSeveral(List<T> inputList) {
        return inputList.stream()
                .map(this::map)
                .collect(Collectors.toList());
    }
}
