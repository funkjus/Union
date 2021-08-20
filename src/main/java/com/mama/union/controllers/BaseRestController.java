package com.mama.union.controllers;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseRestController {

    public Sort.Direction getSortDerection(String dir) {
        switch (dir) {
            case "asc":
                return Sort.Direction.ASC;
            case "desc":
                return Sort.Direction.DESC;
        }
        return null;
    }

    public List<Order> getOrders(String[] sort) {
        List<Order> orders = new ArrayList<>();
        if (sort[0].contains(",")) {
            for (String sortOrder : sort) {
                String[] _sort = sortOrder.split(",");
                orders.add(new Order(getSortDerection(_sort[1]), _sort[0]));
            }
        } else {
            orders.add(new Order(getSortDerection(sort[1]), sort[0]));
        }
        return orders;
    }

    public Pageable getPageableAndSorting(int page, int size, String[] sort){
        return PageRequest.of(page, size, Sort.by(getOrders(sort)));
    }

}
