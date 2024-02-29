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

  public User findUserByEmail(@Nonnull String email) throws UserNotFoundException {
    try {
      return repo.findUserByEmail(email);
    } catch (EmptyResultDataAccessException e) {
      throw new UserNotFoundException();
    }
  }
}
