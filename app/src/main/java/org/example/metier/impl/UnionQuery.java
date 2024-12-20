package org.example.metier.impl;

import org.example.metier.api.Query;
import org.example.metier.api.QueryVisitor;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UnionQuery implements Query {
    private List<Query> subQueries;

    public UnionQuery(List<Query> subQueries) {
        this.subQueries = subQueries;
    }

    @Override
    public Set<Person> execute() {
        Set<Person> result = new HashSet<>();
        for (Query subQuery : subQueries) {
            result.addAll(subQuery.execute());
        }
        return result;
    }

    @Override
    public int getDepth() {
        int maxDepth = 0;
        for (Query subQuery : subQueries) {
            maxDepth = Math.max(maxDepth, subQuery.getDepth());
        }
        return maxDepth + 1;
    }

    @Override
    public List<Query> getSubQueries() {
        return subQueries;
    }

    @Override
    public int accept(QueryVisitor visitor) {
        return visitor.visit(this);
    }
}
