package org.example.metier.impl;

import org.example.metier.api.Query;
import org.example.metier.api.QueryVisitor;

import java.util.Collections;
import java.util.List;
import java.util.Set;

public class SetQuery implements Query {
    private final Set<Person> persons;

    public SetQuery(Set<Person> persons) {
        this.persons = persons;
    }

    @Override
    public Set<Person> execute() {
        return persons;
    }

    @Override
    public int getDepth() {
        return 1;
    }

    @Override
    public List<Query> getSubQueries() {
        return Collections.emptyList();
    }

    @Override
    public int accept(QueryVisitor visitor) {
        return visitor.visit(this);
    }
}
