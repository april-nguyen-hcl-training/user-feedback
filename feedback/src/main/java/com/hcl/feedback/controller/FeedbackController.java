package com.hcl.feedback.controller;

import com.hcl.feedback.exception.FeedbackInvalidDataException;
import com.hcl.feedback.exception.FeedbackNotFoundException;
import com.hcl.feedback.model.Feedback;
import com.hcl.feedback.repository.FeedbackRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/feedback")
public class FeedbackController {
  @Autowired
  private FeedbackRepository repo;

  private static final Logger log = LogManager.getLogger(FeedbackController.class);

  @GetMapping("/all")
  public Iterable<Feedback> getAll() {
    log.debug("Trying to get all feedbacks...");

    return repo.findAll();
  }

  @GetMapping("/{id}")
  public Feedback getFeedbackById(@PathVariable Integer id) {
    log.debug("Trying to get feedback with Id: " + id);

    return repo.findById(id)
      .orElseThrow(FeedbackNotFoundException::new);
  }

  @PostMapping("/submit")
  public Feedback addFeedback(@RequestBody Feedback feedback) {
    log.debug("Trying to add feedback: " + feedback);

    if(feedback.getRating() < 1 || feedback.getRating() > 10 ) {
      log.debug("Invalid Data in feedback: rating is " + feedback.getRating()
        + ", but rating must be 1-10");
      throw new FeedbackInvalidDataException("Rating must be a number 1 - 10");
    }
    if(feedback.getUsername().isEmpty() || feedback.getUsername().equals(null) ) {
      log.debug("Invalid Data in feedback: username is " + feedback.getUsername()
        + ", but username can NOT be empty or null");
      throw new FeedbackInvalidDataException("Username is required!");
    }

    return repo.save(feedback);
  }

  @GetMapping("/username/{username}")
  public List<Feedback> getFeedbackById(@PathVariable String username) {
    log.debug("Trying to get feedback for user: " + username);

    return repo.findByUsername(username);
  }
}
