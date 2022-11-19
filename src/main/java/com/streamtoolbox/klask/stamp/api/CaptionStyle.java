package com.streamtoolbox.klask.stamp.api;

public class CaptionStyle {

	private String font = "SansSerif";
	
	private String color = "white";
	
	private String style = "bold";

	private TextBox box;

	private int size = 24;

	public CaptionStyle() {
	}
	
	public CaptionStyle(String font, String color, String style, int size) {
		super();
		this.font = font;
		this.color = color;
		this.style = style;
		this.size = size;
	}

	public String getFont() {
		return font;
	}

	public void setFont(String font) {
		this.font = font;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public TextBox getBox() {
		return box;
	}

	public void setBox(TextBox box) {
		this.box = box;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + ((font == null) ? 0 : font.hashCode());
		result = prime * result + ((box == null) ? 0 : box.hashCode());
		result = prime * result + size;
		result = prime * result + style.hashCode();
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CaptionStyle other = (CaptionStyle) obj;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (font == null) {
			if (other.font != null)
				return false;
		} else if (!font.equals(other.font))
			return false;
		if (box == null) {
			if (other.box != null)
				return false;
		} else if (!box.equals(other.box))
			return false;
		if (size != other.size)
			return false;
		if (style != other.style)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CaptionStyle [font=" + font + ", color=" + color + ", style=" + style + ", size=" + size + ", box=" + box + "]";
	}
	
}
