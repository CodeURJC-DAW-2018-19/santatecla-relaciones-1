package es.santatecla.database.services;

import es.santatecla.database.repositories.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import static org.springframework.security.core.userdetails.User.withUsername;

@Service
public class UserService implements UserDetailsService {

    private UserRepository repo;

    public UserService(UserRepository repo) {
        this.repo = repo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.repo.findByUsername(username)
                .map(u -> withUsername(u.getUsername()).password(u.getPassword()).roles(u.getRoles().toArray(new String[0])).build())
                .orElseThrow(() -> new UsernameNotFoundException(username));
    }
}
