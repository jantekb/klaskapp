package com.streamtoolbox.klask.stamp.api;


public class CaptionPosition  {

	private double x, y;

	private int z;

	private double width, height;
	
	private String anchor;
	
	public CaptionPosition() {
		x = 10;
		y = 10;
		z = 0;
		anchor = "top-left";
	}
	
	public CaptionPosition(double x, double y, String anchor, int z) {
		super();
		this.x = x;
		this.y = y;
		this.anchor = anchor;
		this.z = z;
	}
	
	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}
	
	public String getAnchor() {
		return anchor;
	}
	
	public void setAnchor(String anchor) {
		this.anchor = anchor;
	}
	
	public int getZ() {
		return z;
	}
	
	public void setZ(int z) {
		this.z = z;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((anchor == null) ? 0 : anchor.hashCode());
		long temp;
		temp = Double.doubleToLongBits(x);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(y);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + (int) (z ^ (z >>> 32));
		temp = Double.doubleToLongBits(width);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(height);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		CaptionPosition other = (CaptionPosition) obj;
		if (anchor == null) {
			if (other.anchor != null)
				return false;
		} else if (!anchor.equals(other.anchor))
			return false;
		if (Double.doubleToLongBits(x) != Double.doubleToLongBits(other.x))
			return false;
		if (Double.doubleToLongBits(y) != Double.doubleToLongBits(other.y))
			return false;
		if (Double.doubleToLongBits(width) != Double.doubleToLongBits(other.width))
			return false;
		if (Double.doubleToLongBits(height) != Double.doubleToLongBits(other.height))
			return false;
		if(z != other.z) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "CaptionPosition [x=" + x + ", y=" + y + ", anchor=" + anchor + ", z=" + z + ", w=" + width + ", h=" + height + "]";
	}

}
