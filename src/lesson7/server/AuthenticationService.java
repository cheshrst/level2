package lesson7.server;

import java.util.Optional;
import java.util.Set;
import java.util.function.Predicate;


public class AuthenticationService {

    private static final Set<User> users = Set.of(
            new User("user1", "l1", "p1"),
            new User("user2", "l2", "p2"),
            new User("user3", "l3", "p3")
    );

    public Optional<String> findNickByLoginAndPassword(String login, String password) {
//        for (User u: users){
//            if (u.getLogin().equals(login) && u.getPassword().equals(password)){
//                return Optional.of(u.getUsername());
//            }
//        }
//        return Optional.empty();

        return users.stream()
                 //try catch?
                .filter(u -> u.getLogin().equals(login) && u.getPassword().equals(password))
                .findFirst()
                .map(User::getUsername);
    }

//    public Optional<String> sendPrivateMessage(String from, String to, String msg){
//        users.stream()
//
//    }


    private static class User{
        private String username;
        private String login;
        private String password;

        public User(String username, String login, String password) {
            this.username = username;
            this.login = login;
            this.password = password;
        }



        public String getPassword() {
            return password;
        }

        public String getLogin() {
            return login;
        }

        public String getUsername() {
            return username;
        }
    }





}