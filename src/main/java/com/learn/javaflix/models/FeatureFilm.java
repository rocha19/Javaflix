package com.learn.javaflix.models;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class FeatureFilm extends Movie {
    public FeatureFilm(int UserId, int externalId, String posterPath, String title, String overview, String releaseDate, String comments, boolean like, boolean dislike
) {
        super(UserId, externalId, posterPath, title, overview, releaseDate, comments, like, dislike); 
    }
}
