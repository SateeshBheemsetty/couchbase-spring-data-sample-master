package com.cb.springdata.sample.entities;

import com.couchbase.client.java.repository.annotation.Field;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Building {

    @NotNull
    @Id
    public String id;

    @NotNull
    @Field
    public String name;

    @NotNull
    @Field
    public String companyId;

    @Field
    public List<Area> areas = new ArrayList<>();

    @Field
    public List<String> phoneNumbers = new ArrayList<>();

}
