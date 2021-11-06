package LinkedList;

public class SearchTree implements NodeList {

    private ListItem root = null;

    public SearchTree(ListItem root) {
        this.root = root;
    }

    @Override
    public ListItem getRoot() {
        return this.root;
    }

    @Override
    public boolean addItem(ListItem newItem) {
        if (this.root == null) {
            //the tree was empty, so our item becomes the head of the tree
            this.root = newItem;
            return true;
        }
        //otherwise, start comparing from the head of the tree
        ListItem currentItem = this.root;
        while (true) {
            int comparison = currentItem.compareTo(newItem);
            if (comparison < 0) {
                //newItem is greater, move right if possible
                if (currentItem.next() != null) {
                    currentItem = currentItem.next();
                } else {
                    //there's no node to the right, so add at this point
                    currentItem.setNext(newItem);
                    return true;
                }
            } else if (comparison > 0) {
                //newItem is less, move left if possible
                if (currentItem.previous() != null) {
                    currentItem = currentItem.previous();
                } else {
                    //there's no node to the left, so add at this point
                    currentItem.setPrevious(newItem);
                    return true;
                }
            } else {
                //equal, so don't add
                System.out.println(newItem.getValue() + " is already present");
                return false;
            }
        }
    }

    @Override
    public boolean removeItem(ListItem item) {
        if (item != null) {
            System.out.println("Deleting item " + item.getValue());
        }
        ListItem currentItem = this.root;
        ListItem parentItem = currentItem;

        while (currentItem != null) {
            int comparison = currentItem.compareTo(item);
            if (comparison < 0) {
                parentItem = currentItem;
                currentItem = currentItem.next();
            } else if (comparison > 0) {
                parentItem = currentItem;
                currentItem = currentItem.previous();
            } else {
                //equal: found the item, so remove it
                performRemoval(currentItem, parentItem);
                return true;
            }
        }
        return false;

    }

    @Override
    public void traverse(ListItem root) {
        //recursive method
        if (root != null) {
            traverse(root.previous());
            System.out.println(root.getValue());
            traverse(root.next());
        }

    }

    private void performRemoval(ListItem itemToBeRemoved, ListItem parentItem) {
        System.out.println("parent: " + parentItem + " itemToBeRemoved: " + itemToBeRemoved);
        ListItem nextOfItemToBeRemoved = itemToBeRemoved.next();
        ListItem previousOfItemToBeRemoved = itemToBeRemoved.previous();
        System.out.println("nextOfItemToBeRemoved: " + nextOfItemToBeRemoved + " previousOfItemToBeRemoved: " + previousOfItemToBeRemoved);
//        itemToBeRemove null, or parent is not really parent
        if(itemToBeRemoved == null || parentItem == null || (parentItem.next() != itemToBeRemoved &&
                parentItem.previous() != itemToBeRemoved && itemToBeRemoved != parentItem)) {
            return;
        }
        //        itemToBeRemoved is root
        else if (itemToBeRemoved == root) {
            System.out.println("ItemToBe Removed Is root");
            ListItem currentItem = nextOfItemToBeRemoved;
            if(currentItem == null) {
                root = root.previous();
                return;
            }
            ListItem itemBeforeCurrentItem = currentItem;
            while(currentItem != null && currentItem.previous() != null) {
                itemBeforeCurrentItem = currentItem;
                currentItem = currentItem.previous();
            }
            if(currentItem.next() != null) {
                itemBeforeCurrentItem.setPrevious(currentItem.next());
            } else if(itemBeforeCurrentItem != null){
                itemBeforeCurrentItem.setPrevious(null);
            }
            if(currentItem != itemToBeRemoved.previous()) {
                currentItem.setPrevious(previousOfItemToBeRemoved);
            }
            if(currentItem != itemToBeRemoved.next()) {
                currentItem.setNext(nextOfItemToBeRemoved);
            }
            root = currentItem;
        }
//        itemToBeremoved has no children
        else if (nextOfItemToBeRemoved == null && previousOfItemToBeRemoved == null) {
            if (parentItem.previous() == itemToBeRemoved) {
                parentItem.setPrevious(null);
            } else if (parentItem.next() == itemToBeRemoved) {
                parentItem.setNext(null);
            }
        } //ItemToBeremoved has one child
        else if (nextOfItemToBeRemoved == null && previousOfItemToBeRemoved != null) {
            if (parentItem.previous() == itemToBeRemoved) {
                parentItem.setPrevious(previousOfItemToBeRemoved);
            } else if (parentItem.next() == itemToBeRemoved) {
                parentItem.setNext(previousOfItemToBeRemoved);
            }
        } else if (nextOfItemToBeRemoved != null && previousOfItemToBeRemoved == null) {
            if (parentItem.previous() == itemToBeRemoved) {
                parentItem.setPrevious(nextOfItemToBeRemoved);
            } else if (parentItem.next() == itemToBeRemoved) {
                parentItem.setNext(nextOfItemToBeRemoved);
            }
        } // itemToBeRemoved has two children
        else if (nextOfItemToBeRemoved != null && previousOfItemToBeRemoved != null){
            if (parentItem.previous() == itemToBeRemoved) {
                System.out.println("itemToBeRemoved is left from parent");
                ListItem currentItem = nextOfItemToBeRemoved;
                ListItem itemBeforeCurrentItem = currentItem;
                while(currentItem != null) {
                    itemBeforeCurrentItem = currentItem;
                    currentItem = currentItem.previous();
                }
                parentItem.setPrevious(itemBeforeCurrentItem);
                itemBeforeCurrentItem.setPrevious(previousOfItemToBeRemoved);
            } else if (parentItem.next() == itemToBeRemoved) {
                System.out.println("itemToBeRemoved is right from parent");
                ListItem currentItem = previousOfItemToBeRemoved;
                ListItem itemBeforeCurrentItem = currentItem;
                while(currentItem != null) {
                    itemBeforeCurrentItem = currentItem;
                    currentItem = currentItem.next();
                }
                parentItem.setNext(itemBeforeCurrentItem);
                itemBeforeCurrentItem.setPrevious(previousOfItemToBeRemoved);
            }
        }

    }
}
