package Lab5;

public class SLLSet {
    private int size;
    private SLLNode head;

    public SLLSet() {
        this.size = 0;
        this.head = null;
    }

    public SLLSet(int[] sortedArray) {
        if (sortedArray != null && sortedArray.length != 0) {
            this.size = sortedArray.length;
            this.head = new SLLNode(sortedArray[0], null);

            SLLNode curr = this.head;

            for (int i = 1; i < this.size; i++) {
                curr.next = new SLLNode(sortedArray[i], null);
                curr = curr.next;
            }
        } else {
            this.size = 0;
            this.head = null;
        }
    }

    public int getSize() {
        return size;
    }

    public SLLSet copy() {
        if (this.head == null) return new SLLSet();

        SLLNode out = new SLLNode(this.head.value, null);
        SLLSet ss = new SLLSet();
        ss.size = this.size;
        ss.head = out;

        for (SLLNode s = this.head.next; s != null; s = s.next) {
            out.next = new SLLNode(s.value, null);
            out = out.next;
        }

        return ss;
    }

    public boolean isIn(int v) {
        SLLNode sn = this.head;

        while (sn != null) {
            if (sn.value == v)
                return true;
            else if (sn.value > v) // SLLSets are sorted, so if the current element value is > than v, v is not in the list
                return false;

            sn = sn.next;
        }

        return false;
    }

    public void add(int v) {
        SLLNode curr = this.head, prev = null;

        // Handle adding to anywhere except the end of the non-empty list
        while (curr != null) {
            if (curr.value == v)
                return;
            if (curr.value > v) {
                SLLNode sn = new SLLNode(v, curr);

                if (prev != null)
                    prev.next = sn;
                else
                    this.head = sn;

                this.size++;
                return;
            }

            prev = curr;
            curr = curr.next;
        }

        // Handle adding if list is empty or to the end of the non-empty list
        SLLNode sn = new SLLNode(v, null);

        if (prev == null)
            this.head = sn;
        else
            prev.next = sn;

        this.size++;
    }

    public void remove(int v) {
        if (this.head == null) return;

        SLLNode curr = this.head;

        if (curr.value == v) {
            this.head = curr.next;
            this.size--;
            return;
        }

        if (curr.value > v) // Element isn't in rest of list
            return;

        while (curr.next != null && curr.next.value != v) {
            if (curr.next.value > v) // Element isn't in rest of list
                return;

            curr = curr.next;
        }

        if (curr.next == null) // Element isn't in list and entire list is smaller than input value
            return;

        // At this point the current's next element has the input value, so we remove it
        curr.next = curr.next.next;
        this.size--;
    }

    public SLLSet union(SLLSet s) {
        if (this.head == null) return s;
        if (s.head == null) return this;

        SLLSet ss = new SLLSet();
        SLLNode list1 = this.head, list2 = s.head, out;

        // Find smallest starting point
        if (list1.value < list2.value) {
            out = new SLLNode(list1.value, null);
            list1 = list1.next;
        } else if (list1.value > list2.value) {
            out = new SLLNode(list2.value, null);
            list2 = list2.next;
        } else {
            out = new SLLNode(list1.value, null);
            list1 = list1.next;
            list2 = list2.next;
        }

        ss.head = out;
        ss.size++;

        // Iterates through all the elements in both lists until there are no common ones
        // This is guaranteed to exhaust at least one list, O(n) or O(m) worst-case
        while (list1 != null && list2 != null) {
            if (list1.value < list2.value) {
                out.next = new SLLNode(list1.value, null);
                list1 = list1.next;
            } else if (list1.value > list2.value) {
                out.next = new SLLNode(list2.value, null);
                list2 = list2.next;
            } else {
                out.next = new SLLNode(list1.value, null);
                list1 = list1.next;
                list2 = list2.next;
            }

            out = out.next;
            ss.size++;
        }

        // Add remaining elements in the non-null list, whichever one that is, O(m) or O(n) worst-case
        while (list1 != null) {
            out.next = new SLLNode(list1.value, null);
            list1 = list1.next;
            out = out.next;
            ss.size++;
        }

        while (list2 != null) {
            out.next = new SLLNode(list2.value, null);
            list2 = list2.next;
            out = out.next;
            ss.size++;
        }

        return ss;
    }

    public SLLSet intersection(SLLSet s) {
        if (this.head == null || s.head == null) return new SLLSet();

        SLLSet ss = new SLLSet();
        SLLNode list1 = this.head, list2 = s.head, out = null;

        // Only add a node to the resultant set if the element value is equal in both sets. If it's not, then go to the next node in
        // whichever list has the smaller value.
        while (list1 != null && list2 != null) {
            if (list1.value < list2.value) {
                list1 = list1.next;
            } else if (list1.value > list2.value) {
                list2 = list2.next;
            } else {
                if (out == null) { // Runs once, handles initialization
                    out = new SLLNode(list1.value, null);
                    ss.head = out;
                } else {
                    out.next = new SLLNode(list1.value, null);
                    out = out.next;
                }

                list1 = list1.next;
                list2 = list2.next;
                ss.size++;
            }
        }

        return ss;
    }

    public SLLSet difference(SLLSet s) {
        if (this.head == null || s.head == null) return this;

        SLLSet ss = copy();

        // Remove all values that are in both lists, from this list
        for (SLLNode e = s.head; e != null; e = e.next)
            ss.remove(e.value);

        return ss;
    }

    public static SLLSet union(SLLSet[] sArray) {
        SLLSet ss = new SLLSet();

        for (SLLSet sllSet : sArray)
            ss = ss.union(sllSet);

        return ss;
    }

    @Override
    public String toString() {
        if (this.head == null) return "";

        SLLNode sn = this.head;
        StringBuilder s = new StringBuilder();

        for (int i = 0; i < this.size - 1; i++) {
            s.append(sn.value).append(", ");
            sn = sn.next;
        }

        return s.append(sn.value).toString();
    }
}
