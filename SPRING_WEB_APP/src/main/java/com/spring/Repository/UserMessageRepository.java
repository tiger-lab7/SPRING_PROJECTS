package com.spring.Repository;

import com.spring.Entities.UserInput;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserMessageRepository extends JpaRepository<UserInput, Long> {
}
