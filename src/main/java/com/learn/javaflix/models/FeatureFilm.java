package com.learn.javaflix.models;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class FeatureFilm extends Movie {
    public FeatureFilm(int UserId, int externalId, String accessToken) {
        super(UserId, externalId, accessToken);
    }
}
