package com.springbatch.catalogue.processors;

import java.util.function.Function;

public class LambdaProcessor implements Function<Integer, String> {
    @Override
    public String apply(Integer item) {
        return "Valeur : " + item;
    }
}