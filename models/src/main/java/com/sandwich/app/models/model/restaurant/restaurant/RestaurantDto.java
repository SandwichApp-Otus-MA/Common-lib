package com.sandwich.app.models.model.restaurant.restaurant;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.sandwich.app.models.model.DomainObjectDto;
import com.sandwich.app.models.model.restaurant.menu.MenuDto;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.time.LocalTime;
import java.util.Collections;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RestaurantDto extends DomainObjectDto {

    @NotNull
    private String name;

    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private LocalTime openingTime;

    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private LocalTime closingTime;

    private List<MenuDto> menus = Collections.emptyList();

    @NotNull
    private Integer rating;

    @NotNull
    private String address;

    private String description;

}