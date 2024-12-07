package com.example.CoderHackProject.CoderHack.Model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "user")
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {

    @Id
    @NotBlank(message = "User id can not be blank")
    private String id;

    @NotBlank(message = "User name can not be blank")
    private String userName;

    @NotNull
    @Min(value = 0, message = "score should not be less than 0")
    @Max(value = 100 , message = "score should not be greater than 0")
    private int score = 0;

    private Set<String> badges = new HashSet<String>();
}
