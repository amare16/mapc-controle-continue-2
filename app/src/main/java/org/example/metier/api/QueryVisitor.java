package org.example.metier.api;

import org.example.metier.impl.DifferenceQuery;
import org.example.metier.impl.SelectionQuery;
import org.example.metier.impl.SetQuery;
import org.example.metier.impl.UnionQuery;

public interface QueryVisitor {
    int visit(SetQuery query);
    int visit(SelectionQuery query);
    int visit(DifferenceQuery query);
    int visit(UnionQuery query);
}
