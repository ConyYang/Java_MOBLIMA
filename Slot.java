package moblima;

public enum Slot {
	m("1030:1330"),
	a("1430:1730"),
	n("1930:2230");
	private final String pitch;

    Slot(String pitch) {
        this.pitch = pitch;
    }

    public String getValue() {
        return pitch;
    }
}