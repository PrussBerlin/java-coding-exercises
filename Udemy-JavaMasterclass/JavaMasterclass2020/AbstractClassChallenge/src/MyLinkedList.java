public class MyLinkedList implements NodeList {
    private ListItem root;

    public MyLinkedList(ListItem root) {
        this.root = root;
    }

    @Override
    public ListItem getRoot() {
        return this.root;
    }

    @Override
    public boolean addItem(ListItem newItem) {
        if(this.root == null) {
            this.root = newItem;
            return true;
        }
        ListItem currentItem = this.root;
        while(currentItem != null) {
            int comparison = currentItem.compareTo(newItem);
            if(comparison < 0) {
                // newItem is greater, move right if possible
                if(currentItem.next() != null) {
                    currentItem = currentItem.next();
                } else {
                    // there is no next, insert at end of list
                    /*hier gibt setNext(newItem) das übergebene newItem wieder zurück
                    so kann direkt die nächste Methode angehängt werden, die dann
                    mit dem newItem arbeitet, weiter unten folgen weiter abkürzungen*/
                    currentItem.setNext(newItem).setPrevious(currentItem);
                    return true;
                }
            } else if(comparison > 0) {
                // newItem is less, insert before
                if(currentItem.previous() != null) {
                    /*setNext(newItem) gibt wieder das newItem zurück und nach dem Punkt kann
                    * so mit newItem gearbeitet werden*/
                    currentItem.previous().setNext(newItem).setPrevious(currentItem.previous());
                    newItem.setNext(currentItem).setPrevious(newItem);
                } else {
                    // the node without a previous is the root
                    newItem.setNext(this.root).setPrevious(newItem);
                    this.root = newItem;
                }
                return true;
            } else {
                //equal
                System.out.println(newItem.getValue() + " is already present, not added");
                return false;
            }
        }
        return false;
    }

    @Override
    public boolean removeItem(ListItem item) {
        if (item != null) {
            System.out.println("Deleting item " + item.getValue());
        }
        ListItem currentItem = this.root;
        while (currentItem != null) {
            int comparison = currentItem.compareTo(item);
            if (comparison == 0) {
                //found the item to delete
                if (currentItem == this.root) {
                    this.root = currentItem.next();
                } else {
                    currentItem.previous().setNext(currentItem.next());
                    if (currentItem.next() != null) {
                        currentItem.next().setPrevious(currentItem.previous());
                    }
                }
                return true;
            } else if (comparison < 0) {
                currentItem = currentItem.next();
            } else {
                /* comparison > 0
                we are at an item greater than the one to be deleted
                die Liste ist sortiert und wir fangen beim Root an, wenn ein Item kommt, das kleiner als
                das 1. in der Liste ist, wurde ein Item übergeben, das nicht in der Liste ist. Wenn
                ein Item größer ist, wird so lange weitergegangen, bis das letzte Element erreicht ist
                wenn auch dieses kleiner ist als das zu suchende Item wird abgebrochen, NIL
                wenn ein Item in der List größer als das zu suchende ist, wurde ein Item übergeben, das nicht in der Liste ist
                sonst hätte der Vergleich mit dem Root ergeben, dass es gleich ist.
                item is not in the list*/
                return false;
            }
        }
        //end of List without finding the item to delete
        return false;
    }

    @Override
    public void traverse(ListItem root) {
        if(root == null) {
            System.out.println("the list is empty");
        } else {
            while(root != null) {
                System.out.println(root.getValue());
                root = root.next();
            }
        }

    }
}
