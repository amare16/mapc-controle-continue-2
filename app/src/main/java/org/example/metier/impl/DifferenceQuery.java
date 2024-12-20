package org.example.metier.impl;

import org.example.metier.api.Query;
import org.example.metier.api.QueryVisitor;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DifferenceQuery implements Query {
    private Query left;
    private Query right;

    public DifferenceQuery(Query left, Query right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public Set<Person> execute() {
        Set<Person> result = new HashSet<>(left.execute());
        result.removeAll(right.execute());
        return result;
    }

    @Override
    public int getDepth() {
        return Math.max(left.getDepth(), right.getDepth()) + 1;
    }

    @Override
    public List<Query> getSubQueries() {
        return List.of(left, right);
    }

    @Override
    public int accept(QueryVisitor visitor) {
        return visitor.visit(this);
    }
}
