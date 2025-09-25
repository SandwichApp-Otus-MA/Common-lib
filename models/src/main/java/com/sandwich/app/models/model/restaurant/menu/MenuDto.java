package com.sandwich.app.models.model.restaurant.menu;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.sandwich.app.models.model.DomainObjectDto;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MenuDto extends DomainObjectDto {

    @NotNull
    private String name;

    @NotNull
    private List<PositionDto> positions = Collections.emptyList();

    @NotNull
    private UUID restaurantId;
}
