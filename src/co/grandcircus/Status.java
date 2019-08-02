package co.grandcircus;

public enum Status {
	ON_SHELF, CHECKED_OUT;

	@Override
	public String toString() {
		return this.name().toLowerCase().replace("_", " ");
	}
}
