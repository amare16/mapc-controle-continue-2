package org.example.metier.impl.visitors;

import org.example.metier.api.Query;
import org.example.metier.api.QueryVisitor;
import org.example.metier.impl.DifferenceQuery;
import org.example.metier.impl.SelectionQuery;
import org.example.metier.impl.SetQuery;
import org.example.metier.impl.UnionQuery;

public class CostCalculator implements QueryVisitor {
    @Override
    public int visit(SetQuery query) {
        return 1;
    }

    @Override
    public int visit(SelectionQuery query) {
        return 1 + query.getSubQueries().get(0).accept(this);
    }

    @Override
    public int visit(DifferenceQuery query) {
        return 2 + query.getSubQueries().get(0).accept(this) + query.getSubQueries().get(1).accept(this);
    }

    @Override
    public int visit(UnionQuery query) {
        int cost = query.getSubQueries().size();
        for (Query subQuery : query.getSubQueries()) {
            cost += subQuery.accept(this);
        }
        return cost;
    }
}
