package org.example.metier.impl;

import org.example.metier.api.Query;
import org.example.metier.api.QueryVisitor;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;

public class SelectionQuery implements Query {
    private Query subQuery;
    private Predicate<Person> predicate;

    public SelectionQuery(Query subQuery, Predicate<Person> predicate) {
        this.subQuery = subQuery;
        this.predicate = predicate;
    }

    @Override
    public Set<Person> execute() {
        Set<Person> result = new HashSet<>();
        for (Person p : subQuery.execute()) {
            if (predicate.test(p)) {
                result.add(p);
            }
        }
        return result;
    }

    @Override
    public int getDepth() {
        return subQuery.getDepth() + 1;
    }

    @Override
    public List<Query> getSubQueries() {
        return List.of(subQuery);
    }

    @Override
    public int accept(QueryVisitor visitor) {
        return visitor.visit(this);
    }
}
