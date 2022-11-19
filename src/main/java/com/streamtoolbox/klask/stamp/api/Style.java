package com.streamtoolbox.klask.stamp.api;

import java.awt.*;

public enum Style  {

	bold(Font.BOLD), italic(Font.ITALIC), plain(Font.PLAIN), bolditalic(Font.ITALIC | Font.BOLD);
	
	private int value;
	
	private Style(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
}
