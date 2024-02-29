package bg.dalexiev.demo.user;

import bg.dalexiev.demo.EmptyResultDataAccessException;
import jakarta.annotation.Nonnull;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  private final UserRepository repo;


  public UserService(UserRepository repo) {
    this.repo = repo;
  }

  public UserResult findUserByEmail(@Nonnull String email) {
    try {
      final User user = repo.findUserByEmail(email);
      return new UserResult.UserFound(user);
    } catch (EmptyResultDataAccessException e) {
      return new UserResult.UserNotFound(email);
    }
  }
}
