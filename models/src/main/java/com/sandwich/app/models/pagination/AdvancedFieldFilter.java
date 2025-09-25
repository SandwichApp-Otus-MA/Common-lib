package com.sandwich.app.models.pagination;

import com.sandwich.app.models.model.enums.AdvancedFieldFilterType;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * Расширенный фильтр по полю.
 *
 * @param <T> тип значения
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
public class AdvancedFieldFilter<T> {
    private AdvancedFieldFilterType type;
    private T singleValue;
    private List<T> multipleValue;
}
