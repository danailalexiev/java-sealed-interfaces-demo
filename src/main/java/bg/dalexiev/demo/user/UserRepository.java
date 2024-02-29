package bg.dalexiev.demo.user;

import bg.dalexiev.demo.EmptyResultDataAccessException;
import jakarta.annotation.Nonnull;
import java.util.Objects;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

  public User findUserByEmail(@Nonnull String email) {
    Objects.requireNonNull(email, "email must not be null");

    if ("danail@example.com".equals(email)) {
      return new User("danail@example.com");
    } else {
      throw new EmptyResultDataAccessException();
    }
  }

}
