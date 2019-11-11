package Lab5;

public class SLLSet {
	private int size;
	private SLLNode start;

	public SLLSet() {
		this.size = 0;
	}

	public SLLSet(int[] sortedArray) {
		this.size = sortedArray.length;
		// this.start = new SLLNode(sortedArray[0], new SLLNode());
	}
}
