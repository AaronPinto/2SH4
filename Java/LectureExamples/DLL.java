package LectureExamples;

public class DLL {
    private DLLNode head, tail;

    public DLL() {
        this.head = null;
        this.tail = null;
    }

    public boolean deleteNode(int v) {
        if (this.head == null) return false;

        DLLNode curr = this.head;

        if (curr.value == v) {
            this.head = curr.next;

            if (curr.next != null)
                curr.next.prev = null;

            return true;
        }

        while (curr.next != null && curr.next.value != v)
            curr = curr.next;

        if (curr.next == null) // Element isn't in list
            return false;

        curr.next = curr.next.next;

        if (curr.next != null)
            curr.next.prev = curr;

        return true;
    }
}
