package bg.dalexiev.demo.user;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

  private final UserService service;

  public UserController(UserService service) {
    this.service = service;
  }

  @GetMapping("/users")
  public ResponseEntity<User> getUser(@RequestParam("email") String email) {
    try {
      final User user = service.findUserByEmail(email);
      return ResponseEntity.ok(user);
    } catch (UserNotFoundException e) {
      return ResponseEntity.notFound().build();
    }
  }

}
