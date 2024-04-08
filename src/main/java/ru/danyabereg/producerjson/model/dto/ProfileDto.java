package ru.danyabereg.producerjson.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProfileDto {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("phone")
    private String phone;
    @JsonProperty("city")
    private String city;
    @JsonProperty("sex")
    private String sex;

    @Builder.Default
    @JsonProperty("hobbies")
    @JsonSubTypes.Type(ArrayList.class)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> hobbies = new ArrayList<>();
}
