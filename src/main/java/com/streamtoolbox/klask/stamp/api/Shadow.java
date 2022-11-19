package com.streamtoolbox.klask.stamp.api;

public class Shadow  {
	
	private int offsetX = 2;
	
	private int offsetY = 2;
	
	private float opacity = 0.8f;
	
	private int radius = 3;

	public Shadow() {
	}
	
	public Shadow(int offsetX, int offsetY, float opacity, int radius) {
		this.offsetX = offsetX;
		this.offsetY = offsetY;
		this.opacity = opacity;
		this.radius = radius;
	}
	
	public Shadow(Shadow other) {
		this.offsetX = other.offsetX;
		this.offsetY = other.offsetY;
		this.opacity = other.opacity;
		this.radius = other.radius;
	}

	public int getOffsetX() {
		return offsetX;
	}

	public void setOffsetX(int offsetX) {
		this.offsetX = offsetX;
	}

	public int getOffsetY() {
		return offsetY;
	}

	public void setOffsetY(int offsetY) {
		this.offsetY = offsetY;
	}

	public float getOpacity() {
		return opacity;
	}

	public void setOpacity(float opacity) {
		this.opacity = opacity;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + offsetX;
		result = prime * result + offsetY;
		result = prime * result + Float.floatToIntBits(opacity);
		result = prime * result + radius;
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
		Shadow other = (Shadow) obj;
		if (offsetX != other.offsetX)
			return false;
		if (offsetY != other.offsetY)
			return false;
		if (Float.floatToIntBits(opacity) != Float.floatToIntBits(other.opacity))
			return false;
		if (radius != other.radius)
			return false;
		return true;
	}
	
}
