package com.streamtoolbox.klask.stamp.api;

public class Transition  {

	private String type = "fade";
	
	private double duration = 2;
	
	private double speed = 0;
	
	private double delay = 0;
	
	public Transition() {
	}
	
	public Transition(Transition clone) {
		this.type = clone.type;
		this.duration = clone.duration;
		this.delay = clone.delay;
		this.speed = clone.speed;
	}
	
	public void setDelay(double delay) {
		this.delay = delay;
	}
	
	public double getDelay() {
		return delay;
	}
	
	public void setDuration(double duration) {
		this.duration = duration;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public double getDuration() {
		return duration;
	}
	
	public String getType() {
		return type;
	}
	
	public double getSpeed() {
		return speed;
	}
	
	public void setSpeed(double speed) {
		this.speed = speed;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(delay);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(duration);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(speed);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		Transition other = (Transition) obj;
		if (Double.doubleToLongBits(delay) != Double.doubleToLongBits(other.delay))
			return false;
		if (Double.doubleToLongBits(duration) != Double.doubleToLongBits(other.duration))
			return false;
		if (Double.doubleToLongBits(speed) != Double.doubleToLongBits(other.speed))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Transition [type=" + type + ", duration=" + duration + ", speed=" + speed + ", delay=" + delay + "]";
	}
	
}
