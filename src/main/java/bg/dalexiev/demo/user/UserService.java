package bg.dalexiev.demo.user;

import jakarta.annotation.Nonnull;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  private final UserRepository repo;


  public UserService(UserRepository repo) {
    this.repo = repo;
  }

  public UserResult findUserByEmail(@Nonnull String email) {
    return repo.findUserByEmail(email)
        .map(user -> (UserResult) new UserResult.UserFound(user))
        .orElse(new UserResult.UserNotFound(email));
  }
}
