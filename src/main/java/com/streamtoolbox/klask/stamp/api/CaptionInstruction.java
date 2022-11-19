package com.streamtoolbox.klask.stamp.api;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.google.gson.GsonBuilder;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class CaptionInstruction implements Comparable<CaptionInstruction> {

	private String id;

	private String text;

	private String clock;
	
	private int countDown;
	
	private String image;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy.MM.dd HH:mm:ss")
	private Date start;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy.MM.dd HH:mm:ss")
	private Date end;

	private String url;

	private CaptionStyle style = new CaptionStyle();

	private CaptionPosition position = new CaptionPosition(10, 10, "top-left", 0);

	private transient static GsonBuilder builder;

	private static DateFormat df1 = new SimpleDateFormat(
			"yyyy.MM.dd HH:mm:ss.SSS");
	
	private static DateFormat df2 = new SimpleDateFormat(
			"yyyy.MM.dd HH:mm:ss");

	private double duration;

	private int opacity = 100;

	private boolean quickText;

	private transient boolean removeRequest;

	private float relativeStartTime = 0;

	private RelativeTo relativeTo;

	private Transition transitionIn;

	private Transition transitionOut;

	private Shadow shadow;

	private boolean wrapText;

	private float wrapWidth;
	
	public CaptionInstruction() {
		this.id = UUID.randomUUID().toString();
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	public void setClock(String clock) {
		this.clock = clock;
	}
	
	public String getClock() {
		return clock;
	}

	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public Date getEnd() {
		if (start != null) {
			if(end == null) {
				if (duration > 0) {
					end = new Date(start.getTime() + (long) (duration * 1000));
				} else /*if (duration == 0)*/ {
					end = new Date(start.getTime() + 15 * 1000);
				}
			}
		}
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}

	public CaptionStyle getStyle() {
		return style;
	}

	public void setStyle(CaptionStyle style) {
		this.style = style;
	}

	public CaptionPosition getPosition() {
		return position;
	}

	public void setPosition(CaptionPosition position) {
		this.position = position;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public double getDuration() {
		if (duration == 0 && start != null && end != null) {
			duration = (end.getTime() - start.getTime()) / 1000;
		}
		return duration;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getImage() {
		return image;
	}

	public void setOpacity(int opacity) {
		this.opacity = opacity;
	}

	private void setQuickText(boolean quickText) {
		this.quickText = quickText;
	}

	public boolean isQuickText() {
		return quickText;
	}

	@Override
	public int compareTo(CaptionInstruction o) {
		return start.compareTo(o.start);
	}

	public int getOpacity() {
		return opacity;
	}

	public String getUrl() {
		return url;
	}

	public boolean isRemoveRequest() {
		return removeRequest;
	}

	public void setRemoveRequest(boolean removeRequest) {
		this.removeRequest = removeRequest;
	}

	public boolean isRelative() {
		return relativeTo != null;
	}

	public void setRelativeStartTime(float relativeStartTime) {
		this.relativeStartTime = relativeStartTime;
	}

	public float getRelativeStartTime() {
		return relativeStartTime;
	}

	public void setRelativeTo(RelativeTo relativeTo) {
		this.relativeTo = relativeTo;
	}

	public RelativeTo getRelativeTo() {
		return relativeTo;
	}

	public void setTransitionIn(Transition transitionIn) {
		this.transitionIn = transitionIn;
	}

	public Transition getTransitionIn() {
		return transitionIn;
	}

	public void setTransitionOut(Transition transitionOut) {
		this.transitionOut = transitionOut;
	}

	public Transition getTransitionOut() {
		return transitionOut;
	}
	
	public int getCountDown() {
		return countDown;
	}
	
	public void setCountDown(int countDown) {
		this.countDown = countDown;
	}

	@Override
	public String toString() {
		return "CaptionInstruction [id=" + id + ", " +
				text == null ? "" : ("text=" + text + ", ") +
				image == null ? "" : ("image=" + image + ", ") +
				clock == null ? "" : ("clock=" + clock + ", ") +
				countDown == null ? "" : ("countDown=" + countDown + ", ") +
				quickText == null ? "" : ("quickText=" + quickText + ", ") +
				url == null ? "" : ("url=" + url + ", ")
				+ ", start=" + (start == null ? "null" : df1.format(start)) + ", end=" + (end == null ? "null" : df1.format(end)) +
				", style=" + style
				+ ", position=" + position + ", duration=" + duration
				+ ", opacity=" + opacity
				+ ", relativeStartTime=" + relativeStartTime + ", relativeTo="
				+ relativeTo + ", transitionIn=" + transitionIn
				+ ", transitionOut=" + transitionOut;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((clock == null) ? 0 : clock.hashCode());
		result = prime * result + ((url == null) ? 0 : url.hashCode());
		result = prime * result + countDown;
		long temp;
		temp = Double.doubleToLongBits(duration);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((end == null) ? 0 : end.hashCode());
		result = prime * result + ((image == null) ? 0 : image.hashCode());
		result = prime * result + opacity;
		result = prime * result + ((position == null) ? 0 : position.hashCode());
		result = prime * result + (quickText ? 1231 : 1237);
		result = prime * result + Float.floatToIntBits(relativeStartTime);
		result = prime * result + ((relativeTo == null) ? 0 : relativeTo.hashCode());
		result = prime * result + ((start == null) ? 0 : start.hashCode());
		result = prime * result + ((style == null) ? 0 : style.hashCode());
		result = prime * result + ((text == null) ? 0 : text.hashCode());
		result = prime * result + ((transitionIn == null) ? 0 : transitionIn.hashCode());
		result = prime * result + ((transitionOut == null) ? 0 : transitionOut.hashCode());
		result = prime * result + ((shadow == null) ? 0 : shadow.hashCode());
		result = prime * result + (wrapText ? 13 : 7);
		result = prime * result + Float.floatToIntBits(wrapWidth);
		return Math.abs(result);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CaptionInstruction other = (CaptionInstruction) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (clock == null) {
			if (other.clock != null)
				return false;
		} else if (!clock.equals(other.clock))
			return false;
		if (url == null) {
			if (other.url != null)
				return false;
		} else if (!url.equals(other.url))
			return false;
		if (countDown != other.countDown)
			return false;
		if (Double.doubleToLongBits(duration) != Double.doubleToLongBits(other.duration))
			return false;
		if (end == null) {
			if (other.end != null)
				return false;
		} else if (!end.equals(other.end))
			return false;
		if (image == null) {
			if (other.image != null)
				return false;
		} else if (!image.equals(other.image))
			return false;
		if (opacity != other.opacity)
			return false;
		if (position == null) {
			if (other.position != null)
				return false;
		} else if (!position.equals(other.position))
			return false;
		if (quickText != other.quickText)
			return false;
		if (Float.floatToIntBits(relativeStartTime) != Float.floatToIntBits(other.relativeStartTime))
			return false;
		if (relativeTo == null) {
			if (other.relativeTo != null)
				return false;
		} else if (!relativeTo.equals(other.relativeTo))
			return false;
		if (start == null) {
			if (other.start != null)
				return false;
		} else if (!start.equals(other.start))
			return false;
		if (style == null) {
			if (other.style != null)
				return false;
		} else if (!style.equals(other.style))
			return false;
		if (text == null) {
			if (other.text != null)
				return false;
		} else if (!text.equals(other.text))
			return false;
		if (transitionIn == null) {
			if (other.transitionIn != null)
				return false;
		} else if (!transitionIn.equals(other.transitionIn))
			return false;
		if (transitionOut == null) {
			if (other.transitionOut != null)
				return false;
		} else if (!transitionOut.equals(other.transitionOut))
			return false;
		if (shadow == null) {
			if (other.shadow != null)
				return false;
		} else if (!shadow.equals(other.shadow))
			return false;
		if(wrapText != other.wrapText) {
			return false;
		}
		if(wrapWidth != other.wrapWidth) {
			return false;
		}
		return true;
	}
	
	public String getId() {
		return this.id;
	}

	public String getShortDescription() {
		if(countDown > 0) {
			return "count down from " + countDown;
		} else if(clock != null) {
			return "clock with pattern " + clock;
		} else if(image != null) {
			return "image " + image;
		} else if(url != null) {
			return "url " + url;
		} else {
			return text;
		}
	}
	
	public static GsonBuilder builder() {
		return builder;
	}
	
	public boolean isImageUrl() {
		return image != null && image.matches("https?\\:\\/\\/.+");
	}

	public Shadow getShadow() {
		return shadow;
	}
	
	public void setShadow(Shadow shadow) {
		this.shadow = shadow;
	}

	public boolean isWrapText() {
		return wrapText;
	}

	public float getWrapWidth() {
		return wrapWidth;
	}

}
