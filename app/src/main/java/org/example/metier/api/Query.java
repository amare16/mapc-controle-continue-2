package org.example.metier.api;

import org.example.metier.impl.Person;

import java.util.List;
import java.util.Set;

public interface Query {
    Set<Person> execute();
    int getDepth();
    List<Query> getSubQueries();

    // Accept method for the visitor
    int accept(QueryVisitor visitor);
}
