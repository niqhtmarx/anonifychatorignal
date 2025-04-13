package io.github.niqhtmarx.anonifychat.repository;
import io.github.niqhtmarx.anonifychat.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
public interface UserRepository extends JpaRepository<User, Long> {}