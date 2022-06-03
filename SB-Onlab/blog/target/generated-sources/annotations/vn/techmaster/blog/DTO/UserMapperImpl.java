package vn.techmaster.blog.DTO;

import javax.annotation.processing.Generated;
import vn.techmaster.blog.model.User;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-05-19T12:24:35+0700",
    comments = "version: 1.4.1.Final, compiler: Eclipse JDT (IDE) 1.4.100.v20220318-0906, environment: Java 17.0.2 (Eclipse Adoptium)"
)
public class UserMapperImpl implements UserMapper {

    @Override
    public UserInfo userToUserInfo(User user) {
        if ( user == null ) {
            return null;
        }

        UserInfo userInfo = new UserInfo();

        userInfo.setEmail( user.getEmail() );
        userInfo.setFullname( user.getFullname() );
        userInfo.setId( user.getId() );

        return userInfo;
    }

    @Override
    public User userInfoToUser(UserInfo userInfo) {
        if ( userInfo == null ) {
            return null;
        }

        User user = new User();

        user.setEmail( userInfo.getEmail() );
        user.setFullname( userInfo.getFullname() );
        user.setId( userInfo.getId() );

        return user;
    }
}
