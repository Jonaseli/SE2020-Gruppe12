package dataHandler.serializers;

import com.fasterxml.jackson.databind.util.StdConverter;
import model.Post;

public class PostToStringConverter extends StdConverter<Post, String> {
    @Override
    public String convert(Post post) {
        return post.getPostId().toString();
    }
}
