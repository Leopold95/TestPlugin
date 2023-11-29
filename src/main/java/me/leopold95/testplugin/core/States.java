package me.leopold95.testplugin.core;

public enum States {
	SIGHT("sight-state"),
	ARROW("arrow-state"),
	SNOWBALL("snowball-state"),
	DEFAULT("default-state");

	private final String state;

	States(String url) {
		this.state = url;
	}

	public String getState() {
		return state;
	}
}
