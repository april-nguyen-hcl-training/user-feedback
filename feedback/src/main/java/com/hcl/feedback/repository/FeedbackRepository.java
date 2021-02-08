package com.hcl.feedback.repository;

import com.hcl.feedback.model.Feedback;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FeedbackRepository extends CrudRepository<Feedback, Integer> {
  List<Feedback> findByUsername(String username);
}
