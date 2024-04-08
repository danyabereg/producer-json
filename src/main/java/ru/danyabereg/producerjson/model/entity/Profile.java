package ru.danyabereg.producerjson.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "phone")
    private String phone;

    @Column(name = "city")
    private String city;

    @Enumerated(EnumType.STRING)
    private Sex sex;

    @Builder.Default
    @ElementCollection
    @CollectionTable(name = "hobby", joinColumns = @JoinColumn(name = "profile_id"))
    @Column(name = "hobby_name")
    private List<String> hobbies = new ArrayList<>();
}
