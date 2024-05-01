package com.capstone.csdrms.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstone.csdrms.Entity.FeedbackEntity;
import com.capstone.csdrms.Repository.FeedbackRepository;

@Service
public class FeedbackService {

	@Autowired
	FeedbackRepository frepo;
	
	public FeedbackEntity insertFeedback(FeedbackEntity feedback) {
		return frepo.save(feedback);
	}
}
