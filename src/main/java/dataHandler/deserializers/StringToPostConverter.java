package dataHandler.deserializers;

import com.fasterxml.jackson.databind.util.StdConverter;
import model.Post;
import repository.Repository;

import java.util.stream.Collectors;

public class StringToPostConverter extends StdConverter<String, Post> {
    @Override
    public Post convert(String postId) {
        return Repository.posts.stream()
                .filter((post) -> post.getPostId().toString().equals(postId))
                .collect(Collectors.toList()).get(0);
    }
}
