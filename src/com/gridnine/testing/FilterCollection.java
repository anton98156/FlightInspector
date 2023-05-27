package com.gridnine.testing;

import java.util.ArrayList;
import java.util.List;

public class FilterCollection implements Filter {

    private final List<Filter> filters = new ArrayList<>();
    
    public FilterCollection addFilter(Filter filter) {
        filters.add(filter);
        return this;
    }

    @Override
    public List<Flight> filter(List<Flight> flights) {
        List<Flight> result = flights;
        for (Filter filter : filters) {
            result = filter.filter(result);
        }
        return result;
    }
}