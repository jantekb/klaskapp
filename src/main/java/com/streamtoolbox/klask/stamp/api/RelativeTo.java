package com.streamtoolbox.klask.stamp.api;

public class RelativeTo  {

	private String scheduleStream;
	
	private String schedulePlaylistItem;

	private String eventId;
	
	public RelativeTo() {
	}
	
	public RelativeTo(RelativeTo clone) {
		this.scheduleStream = clone.scheduleStream;
		this.schedulePlaylistItem = clone.schedulePlaylistItem;
		this.eventId = clone.eventId;
	}
	
	public String getScheduleStream() {
		return scheduleStream;
	}

	public void setScheduleStream(String scheduleStream) {
		this.scheduleStream = scheduleStream;
	}


	public String getSchedulePlaylistItem() {
		return schedulePlaylistItem;
	}

	public void setSchedulePlaylistItem(String schedulePlaylistItem) {
		this.schedulePlaylistItem = schedulePlaylistItem;
	}
	
	public void setEventId(String eventId) {
		this.eventId = eventId;
	}
	
	public String getEventId() {
		return eventId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((eventId == null) ? 0 : eventId.hashCode());
		result = prime * result + ((schedulePlaylistItem == null) ? 0 : schedulePlaylistItem.hashCode());
		result = prime * result + ((scheduleStream == null) ? 0 : scheduleStream.hashCode());
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
		RelativeTo other = (RelativeTo) obj;
		if (eventId == null) {
			if (other.eventId != null)
				return false;
		} else if (!eventId.equals(other.eventId))
			return false;
		if (schedulePlaylistItem == null) {
			if (other.schedulePlaylistItem != null)
				return false;
		} else if (!schedulePlaylistItem.equals(other.schedulePlaylistItem))
			return false;
		if (scheduleStream == null) {
			if (other.scheduleStream != null)
				return false;
		} else if (!scheduleStream.equals(other.scheduleStream))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "RelativeTo [scheduleStream=" + scheduleStream + ", schedulePlaylistItem=" + schedulePlaylistItem + ", eventId=" + eventId
				+ "]";
	}
	
	

	
}
