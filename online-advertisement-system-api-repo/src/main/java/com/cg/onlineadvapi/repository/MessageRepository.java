package com.cg.onlineadvapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cg.onlineadvapi.domain.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message, Integer>{

}
