package LectureExamples;

class DLLNode {
    int value;
    DLLNode next, prev;

    DLLNode(int i, DLLNode n, DLLNode p) {
        this.value = i;
        this.next = n;
        this.prev = p;
    }
}
