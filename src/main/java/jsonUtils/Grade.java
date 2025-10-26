package jsonUtils;

public class Grade {
	public int math;
	public int physics;
	public int chemistry;

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public int getPhysics() {
		return physics;
	}

	public void setPhysics(int physics) {
		this.physics = physics;
	}

	public int getChemistry() {
		return chemistry;
	}

	public void setChemistry(int chemistry) {
		this.chemistry = chemistry;
	}

	public String toString() {
		return getMath() + " " + getPhysics() + "  " + getChemistry();
	}
}
