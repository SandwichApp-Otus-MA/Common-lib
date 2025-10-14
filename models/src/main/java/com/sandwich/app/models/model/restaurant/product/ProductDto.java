package com.sandwich.app.models.model.restaurant.product;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.sandwich.app.models.model.DomainObjectDto;
import com.sandwich.app.models.model.enums.MeasureUnit;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductDto extends DomainObjectDto {

    private String name;

    private MeasureUnit measureUnit;

    private ProductInfoDto productInfo;

    private String description;
}
