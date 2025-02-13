package com.springcourse.files;

public class WordPosition {

	private int line;
	private int column;

	public WordPosition() {
		super();
		// TODO Auto-generated constructor stub
	}

	public WordPosition(int line, int column) {
		super();
		this.line = line;
		this.column = column;
	}

	public int getLine() {
		return line;
	}

	public void setLine(int line) {
		this.line = line;
	}

	public int getColumn() {
		return column;
	}

	public void setColumn(int column) {
		this.column = column;
	}

	@Override
	public String toString() {
		return "WordPosition [line=" + line + ", column=" + column + "]";
	}

}