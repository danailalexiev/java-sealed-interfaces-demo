package bg.dalexiev.demo.user;

import jakarta.annotation.Nonnull;
import java.util.Objects;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

  /**
   * Use the now common Optional return type instead of having Spring Data throw an exception on an empty result.
   *
   * @param email
   * @return
   */
  public Optional<User> findUserByEmail(@Nonnull String email) {
    Objects.requireNonNull(email, "email must not be null");

    if ("danail@example.com".equals(email)) {
      return Optional.of(new User("danail@example.com"));
    } else {
      return Optional.empty();
    }
  }

}
