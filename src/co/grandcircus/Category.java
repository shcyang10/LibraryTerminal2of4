package co.grandcircus;

public enum Category {
FICTION, NONFICTION, SCIENCE_FICTION, FANTASY, PHILOSOPHY, DRAMA, SCIENCE;
	
	@Override
	public String toString() {
		return this.name().toLowerCase().replace("_", " ");
	}
}
