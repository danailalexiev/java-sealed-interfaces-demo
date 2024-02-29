package bg.dalexiev.demo.user;

/**
 * Represents all possible outcomes of trying to find a user.
 */
public sealed interface UserResult {

  record UserFound(User user) implements UserResult {

  }

  /**
   * The missing email here can easily be supplied from the request param.
   * The idea here is to showcase that you can pass custom data into this option and use it when handling the result.
   *
   * @param missingEmail
   */
  record UserNotFound(String missingEmail) implements UserResult {

  }

}
