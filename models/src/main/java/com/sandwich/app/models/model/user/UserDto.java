package com.sandwich.app.models.model.user;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.sandwich.app.models.model.enums.UserStatus;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Data
@Accessors(chain = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDto {
    private UUID id;
    @NotEmpty
    private String lastName;
    @NotEmpty
    private String firstName;
    private String middleName;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private LocalDate birthDate;
    @Email
    private String email;
    private String phoneNumber;
    @NotNull
    @Size(min = 12, max = 50)
    private char[] password;
    private UserStatus status;
    @NotNull
    private BigDecimal balance = BigDecimal.ZERO;
}