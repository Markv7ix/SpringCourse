package com.springcourse.sequencegenerator.impl;

import java.time.Instant;

import com.springcourse.sequencegenerator.PrefixGenerator;

public class TimestampPrefixGenerator implements PrefixGenerator {

	@Override
	public String generatePrefix() {
		// TODO Auto-generated method stub
		return String.valueOf(Instant.now().toEpochMilli());
	}

}
