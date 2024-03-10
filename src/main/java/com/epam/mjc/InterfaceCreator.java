package com.epam.mjc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class InterfaceCreator {

    public Predicate<List<String>> isValuesStartWithUpperCase() {
        return x->{
            for(String s : x){
                if(!Character.isUpperCase(s.charAt(0))){
                    return false;
                }
            }
            return true;
        };
    }

    public Consumer<List<Integer>> addEvenValuesAtTheEnd() {
        return list->{
            List<Integer> tempList = new ArrayList<>();
            for(int i : list)
                if(i % 2 == 0)
                    tempList.add(i);
            list.addAll(tempList);
        };
    }

    public Supplier<List<String>> filterCollection(List<String> values) {
        return ()->{
            List<String> list = new ArrayList<>();
            for(String str: values){
                if(Character.isUpperCase(str.charAt(0)) && str.charAt(str.length() - 1) == '.' && str.split(" ").length > 3){
                    list.add(str);
                }
            }
            return list;
        };
    }

    public Function<List<String>, Map<String, Integer>> stringSize() {
        return x->{
            Map<String, Integer> map = new HashMap<>();
            for(String str : x){
                map.put(str, str.length());
            }
            return map;
        };
    }

    public BiFunction<List<Integer>, List<Integer>, List<Integer>> concatList() {
        return (list1, list2)->{
            List<Integer> concatList = new ArrayList<>();
            concatList.addAll(list1);
            concatList.addAll(list2);
            return concatList;
        };
    }
}
