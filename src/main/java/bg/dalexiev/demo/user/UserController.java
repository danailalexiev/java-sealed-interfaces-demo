package bg.dalexiev.demo.user;

import org.springframework.http.HttpStatus;
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
  public ResponseEntity<Object> getUser(@RequestParam("email") String email) {
    final UserResult result = service.findUserByEmail(email);
    return switch (result) {
      case UserResult.UserFound userFound -> ResponseEntity.ok(userFound.user());
      case UserResult.UserNotFound userNotFound ->
          ResponseEntity.status(HttpStatus.NOT_FOUND).body("No user found with email" + userNotFound.missingEmail());
    };
  }

}
