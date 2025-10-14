package com.sandwich.app.models.model.delivery.courier;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.sandwich.app.models.model.enums.CourierStatus;
import com.sandwich.app.models.model.enums.Gender;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.UUID;

@Data
@Accessors(chain = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CourierDto {
    private UUID id;
    private String name;
    private CourierStatus status;
    private Gender gender;
    private String phoneNumber;
}
