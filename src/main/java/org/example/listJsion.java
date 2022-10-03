package org.example;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class listJsion {
    String id;
    String name;
    String salePriceU;
    String subjectId;
    String feedbacks;
    String rating;

    @Override
    public String toString() {
        return "listJsion{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", salePriceU='" + salePriceU + '\'' +
                ", subjectId='" + subjectId + '\'' +
                ", feedbacks='" + feedbacks + '\'' +
                ", rating='" + rating + '\'' +
                '}';
    }
}
