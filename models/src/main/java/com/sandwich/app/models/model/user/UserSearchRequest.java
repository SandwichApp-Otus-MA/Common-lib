package com.sandwich.app.models.model.user;

import com.sandwich.app.models.pagination.Pagination;
import com.sandwich.app.models.pagination.Sorting;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Data
@Accessors(chain = true)
public class UserSearchRequest {
    private UserFilter filter;

    private Pagination pagination;

    private List<Sorting> sorting;

    public Pagination getPagination() {
        return Optional.ofNullable(pagination).orElseGet(Pagination::byDefault);
    }

    public List<Sorting> getSorting() {
        return Optional.ofNullable(sorting).orElseGet(ArrayList::new);
    }
}