package com.springcourse.sequencegenerator.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.springcourse.sequencegenerator.PrefixGenerator;

public class CountdownSequenceGenerator {

	private String preffix;
	
	private String suffix;
	
	private int sequence;

	@Autowired
	@Qualifier("timestampPrefixGenerator")
	private PrefixGenerator prefixGenerator;
	
	public CountdownSequenceGenerator() {
	}

	public CountdownSequenceGenerator(int initialValue, String suffix) {
		this.sequence = initialValue;
		this.suffix = suffix;
	}	
	
	public CountdownSequenceGenerator(int initialValue, String preffix, String suffix) {
		this.sequence = initialValue;
		this.preffix = preffix;
		this.suffix = suffix;
	}

	public CountdownSequenceGenerator(String preffix, String suffix, int sequence, PrefixGenerator prefixGenerator) {
		super();
		this.preffix = preffix;
		this.suffix = suffix;
		this.sequence = sequence;
		this.prefixGenerator = prefixGenerator;
	}

	public String getPreffix() {
		return preffix;
	}

	public String getSuffix() {
		return suffix;
	}

	public int getSequence() {
		return sequence;
	}
	
	public PrefixGenerator getPrefixGenerator() {
		return prefixGenerator;
	}

	public void setPrefixGenerator(PrefixGenerator prefixGenerator) {
		this.prefixGenerator = prefixGenerator;
	}

	public synchronized String getNext() {
		if(sequence < 0) {
			return "-Countdown is Over!-";
		}
		return new StringBuilder().append(prefixGenerator.generatePrefix()).append(sequence--).append(suffix)
				.toString();
	}

}
