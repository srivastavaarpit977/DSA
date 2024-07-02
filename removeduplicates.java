public class removeduplicates {

  public ListNode deleteDuplicates(ListNode head) {
    if (head == null) {
      return null;
    }

    ListNode prev = null;
    ListNode current = head;

    while (current != null) {
      if (prev == null || prev.val != current.val) {
        // Keep the first occurrence of each value
        prev = current;
      } else {
        // Duplicate found, skip to next distinct node
        prev.next = current.next;
      }
      current = current.next;
    }

    return head;
  }
}
