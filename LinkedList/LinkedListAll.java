package LinkedList;


class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedListAll {
    Node head;

    // 01->Insert the elememet from the front side
    void addFirst(int val) {
        Node newNode = new Node(val);
        if (head == null) {
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    // 02->Insert the elememet from the rare side

    void addLast(int val) {
        Node newNode = new Node(val);
        if (head == null) {
            head = newNode;
            return;
        }
        Node cuNode = head;
        while (cuNode.next != null) {
            cuNode = cuNode.next;
        }
        cuNode.next = newNode;
    }

    // 03->delete the elememet from the front side
    void deleteFirst() {
        if (head == null) {
            return;
        }
        head = head.next;
    }

    // 04-> delete the elememet from the back side

    void deleteLast() {
        if (head == null) {
            return;
        }
        Node cuNode = head;
        Node lastNode = head.next;
        while (lastNode.next != null) {
            cuNode = cuNode.next;
            lastNode = lastNode.next;
        }
        cuNode.next = null;
    }

    // 05-> get the size of List

    static int size(Node head) {
        int count = 0;
        Node curNode = head;
        while (curNode != null) {
            curNode = curNode.next;
            count++;
        }
        return count;
    }

    // 06->print the List

    void printList() {
        Node curNode = head;
        while (curNode != null) {
            System.out.print(curNode.data + " ");
            curNode = curNode.next;
        }
    }

    // 07->get the element from the front by index value

    void getNFromStart(int n) {
        if (head == null || size(head) < n) {
            return;
        }
        Node cuNode = head;
        for (int i = 0; i < n; i++) {
            cuNode = cuNode.next;
        }
        System.out.println(cuNode.data);
    }

    // 08->get the element from the end by index value

    void getNFromEnd(int n) {
        if (head == null || size(head) < n || n == 0) {
            return;
        }
        Node cuNode = head;
        for (int i = 0; i < size(head) - n; i++) {
            cuNode = cuNode.next;
        }
        System.out.println(cuNode.data);
    }

    // 09-> Remove the element from the front by index value
    void removeNFromStart(int n) {
        if (head == null || size(head) <= n) {
            return;
        }
        Node cuNode = head;
        if (n == 0) {
            head = head.next;
        }
        for (int i = 0; i < n - 1; i++) {
            cuNode = cuNode.next;
        }
        cuNode.next = cuNode.next.next;
    }

    // 10->Remove the element from the back by index value

    void removeNFromEnd(int n) {
        if (head == null || size(head) < n) {
            return;
        }
        Node cuNode = head;
        if (n == size(head)) {
            head = head.next;
            return;
        }
        for (int i = 0; i < size(head) - n - 1; i++) {
            cuNode = cuNode.next;
        }
        cuNode.next = cuNode.next.next;
    }

    // 11->Get the index number of a Value

    void getindex(int val) {
        Node cuNode = head;
        int i = 0;
        while (cuNode != null) {
            if (val == cuNode.data) {
                System.out.println(i);
                return;
            }
            i++;
            cuNode = cuNode.next;
        }
    }

    // 12->get the middle element of list

    static Node getMiddle(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // 13->delete the middle element of list

    void deleteMiddle() {
        Node slow = head;
        Node fast = head;

        while (fast.next.next != null && fast.next.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        slow.next = slow.next.next;
    }

    // 14->Reverse a list

    static Node reverseLL(Node head) {
        Node prNode = null;
        Node cuNode = head;
        Node neNode = null;
        while (cuNode != null) {
            neNode = cuNode.next;
            cuNode.next = prNode;
            prNode = cuNode;
            cuNode = neNode;
        }
        return prNode;
    }

    // 15->Merge two sorted list
    static Node merge(Node list1, Node list2) {
        Node dummy = new Node(0);
        Node temp = dummy;
        while (list1 != null && list2 != null) {
            if (list1.data < list2.data) {
                temp.next = list1;
                list1 = list1.next;
            } else {
                temp.next = list2;
                list2 = list2.next;
            }
            temp = temp.next;
        }
        if (list1 == null) {
            temp.next = list2;
        } else {
            temp.next = list1;
        }
        return dummy.next;
    }

    // 16-> Sort the list ans assending order
    static Node mergeSort(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node middle = getMiddle(head);
        Node lastNode = middle.next;
        middle.next = null;

        Node sortedFirst = mergeSort(head);
        Node sortedLast = mergeSort(lastNode);
        return merge(sortedFirst, sortedLast);
    }

    // 17->Add two numbers

    static Node addTwoNumbers(Node list1, Node list2) {
        Node dummy = new Node(0);
        Node temp = dummy;
        int carry = 0;
        while (list1 != null || list2 != null || carry == 1) {
            int sum = 0;
            if (list1 != null) {
                sum += list1.data;
                list1 = list1.next;
            }
            if (list2 != null) {
                sum += list2.data;
                list2 = list2.next;
            }
            sum += carry;
            carry = sum / 10;
            Node curNode = new Node(sum % 10);
            temp.next = curNode;
            temp = temp.next;
        }
        return dummy.next;
    }

    // 18->Intersection of two numbers
    public static int getIntersectionNode(Node listA, Node listB) {
        Node tempA = listA;
        Node tempB = listB;

        int lenghtA = 0;
        int lenghtB = 0;
        while (tempA != null) {
            tempA = tempA.next;
            lenghtA++;
        }
        while (tempB != null) {
            tempB = tempB.next;
            lenghtB++;
        }
        tempA = listA;
        tempB = listB;
        if (lenghtA > lenghtB) {
            int m = lenghtA - lenghtB;
            for (int i = 1; i <= m; i++) {
                tempA = tempA.next;
            }
        } else {
            int n = lenghtB - lenghtA;
            for (int i = 1; i <= n; i++) {
                tempB = tempB.next;
            }
        }
        while (tempA != null && tempB != null && tempA != tempB) {
            tempA = tempA.next;
            tempB = tempB.next;
        }
        if (tempA == null || tempB == null) {
            return -1;
        }
        return tempA.data;
    }

    // 19-> detect cycle in linkedlist
    public static int detectCycle(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }
        Node cuNode = head;
        while (cuNode != slow) {
            if (slow == head)
                return -1;
            slow = slow.next;
            if (cuNode == null)
                return -1;
            cuNode = cuNode.next;
        }
        return slow.data;
    }

    // 20->Rotate linked list by k
    static Node rotateRight(Node head, int k) {
        for (int i = 0; i < k; i++) {
            Node currNode = head;
            while (currNode.next.next != null) {
                currNode = currNode.next;
            }
            Node end = currNode.next;
            currNode.next = null;
            end.next = head;
            head = end;
        }
        return head;
    }

    // 21->flatten linked list
    static Node flattenLL(Node head) {
        head.next = flattenLL(head);
        head = merge(head, head.next);
        return head;
    }

    // 22->Segregate odd and even
    static Node segregateEvenOdd(Node head) {
        Node odd = head;
        Node even = head.next;
        Node ans = head.next;
        while (even != null && even.next != null) {
            odd.next = odd.next.next;
            odd = odd.next;
            even.next = even.next.next;
            even = even.next;
        }
        odd.next = ans;
        return head;
    }

    // 23->reverse k group

    public static Node reverseKGroup(Node head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        int size = size(head);
        if (size < k) {
            return head;
        }
        Node prevNode = null;
        Node curNode = head;
        Node nextNode = null;
        int count = 0;
        while (curNode != null && count < k) {
            nextNode = curNode.next;
            curNode.next = prevNode;
            prevNode = curNode;
            curNode = nextNode;
            count++;
        }
        if (nextNode != null && size - count >= k) {
            head.next = reverseKGroup(nextNode, k);
        } else {
            head.next = nextNode;
        }
        return prevNode;
    }

    // 24->palindrome linked list

    static boolean ispalindrome(Node head) {
        Node middle = getMiddle(head);
        Node lastNode = reverseLL(middle.next);
        Node currNode = head;
        while (lastNode != null) {
            if (currNode.data != lastNode.data) {
                return false;
            }
            currNode = currNode.next;
            lastNode = lastNode.next;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arrayA = { 3, 2, 0, -4 };
        int[] arrayB = { 1, 2, 3, 4, 3, 2, 1 };

        LinkedListAll p = new LinkedListAll();
        for (int val : arrayA) {
            p.addLast(val);
        }

        LinkedListAll q = new LinkedListAll();
        for (int val : arrayB) {
            q.addLast(val);
        }
        System.out.println(ispalindrome(q.head));
    }
}
