package com.springcourse.sequencegenerator.impl;

import com.springcourse.sequencegenerator.PrefixGenerator;

public class SequenceGenerator {

	private String preffix;
	
	private String suffix;
	
	private int sequence;

	private PrefixGenerator prefixGenerator;
	
	public SequenceGenerator() {
	}

	public SequenceGenerator(int initialValue, String suffix) {
		this.sequence = initialValue;
		this.suffix = suffix;
	}	
	
	public SequenceGenerator(int initialValue, String preffix, String suffix) {
		this.sequence = initialValue;
		this.preffix = preffix;
		this.suffix = suffix;
	}

	public SequenceGenerator(String preffix, String suffix, int sequence, PrefixGenerator prefixGenerator) {
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
		
		return new StringBuilder().append(prefixGenerator.generatePrefix()).append(sequence++).append(suffix)
				.toString();
	}

}
