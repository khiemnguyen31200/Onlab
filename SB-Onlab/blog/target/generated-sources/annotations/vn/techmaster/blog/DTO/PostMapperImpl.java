package vn.techmaster.blog.DTO;

import java.util.HashSet;
import java.util.Set;
import javax.annotation.processing.Generated;
import vn.techmaster.blog.controller.request.PostRequest;
import vn.techmaster.blog.model.Post;
import vn.techmaster.blog.model.Tag;
import vn.techmaster.blog.model.User;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-05-19T12:24:35+0700",
    comments = "version: 1.4.1.Final, compiler: Eclipse JDT (IDE) 1.4.100.v20220318-0906, environment: Java 17.0.2 (Eclipse Adoptium)"
)
public class PostMapperImpl implements PostMapper {

    @Override
    public Post postRequestToPost(PostRequest postRequest) {
        if ( postRequest == null ) {
            return null;
        }

        Post post = new Post();

        post.setContent( postRequest.getContent() );
        post.setId( postRequest.getId() );
        Set<Tag> set = postRequest.getTags();
        if ( set != null ) {
            post.setTags( new HashSet<Tag>( set ) );
        }
        post.setTitle( postRequest.getTitle() );

        return post;
    }

    @Override
    public PostRequest postToPostRequest(Post post) {
        if ( post == null ) {
            return null;
        }

        PostRequest postRequest = new PostRequest();

        postRequest.setUser_id( postUserId( post ) );
        postRequest.setContent( post.getContent() );
        postRequest.setId( post.getId() );
        Set<Tag> set = post.getTags();
        if ( set != null ) {
            postRequest.setTags( new HashSet<Tag>( set ) );
        }
        postRequest.setTitle( post.getTitle() );

        return postRequest;
    }

    @Override
    public PostPOJO postToPostPOJO(Post post) {
        if ( post == null ) {
            return null;
        }

        PostPOJO postPOJO = new PostPOJO();

        postPOJO.setUser_id( postUserId( post ) );
        postPOJO.setUserFullName( postUserFullname( post ) );
        postPOJO.setContent( post.getContent() );
        postPOJO.setId( post.getId() );
        postPOJO.setLastUpdate( post.getLastUpdate() );
        postPOJO.setTitle( post.getTitle() );

        return postPOJO;
    }

    private Long postUserId(Post post) {
        if ( post == null ) {
            return null;
        }
        User user = post.getUser();
        if ( user == null ) {
            return null;
        }
        long id = user.getId();
        return id;
    }

    private String postUserFullname(Post post) {
        if ( post == null ) {
            return null;
        }
        User user = post.getUser();
        if ( user == null ) {
            return null;
        }
        String fullname = user.getFullname();
        if ( fullname == null ) {
            return null;
        }
        return fullname;
    }
}
