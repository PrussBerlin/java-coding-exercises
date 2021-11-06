public abstract class ListItem {

    protected Object value;
    protected ListItem rightLink = null;
    protected ListItem leftLink = null;

    public ListItem(Object value) {
        this.value = value;
    }
    abstract ListItem next();
    abstract ListItem setNext(ListItem item);
    abstract ListItem previous();
    abstract ListItem setPrevious(ListItem item);

    abstract int compareTo(ListItem item);

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "ListItem{" +
                "value=" + value +
                ", rightLink=" + rightLink +
                ", leftLink=" + leftLink +
                '}';
    }

    //    public Object nextItem() {
//        Object tmp = value;
//        value = next;
//        previous = tmp;
//        next = next.next;
//    }
//    public Object previousItem() {
//        Object tmp = value;
//        value = previous;
//        next = tmp;
//        previous = previous.previous;
//    }
//
//    public void setPrevious(ListItem previous) {
//        this.previous = previous;
//    }
//
//    public void setNext(ListItem next) {b
//        this.next = next;
//    }
//
//    @Override
//    public int compareTo(ListItem value) {
//        if(this.value > value) {
//            return 1;
//        } else if(this.value < value) {
//            return -1;
//        } else {
//            return 0;
//        }
//    }
}
