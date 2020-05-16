package com.taherajna.practice.datastructures;

import java.util.ArrayDeque;
import java.util.Queue;
import org.junit.Assert;
import org.junit.Test;

public class QueueTest {
  @Test
  public void testQueue() {
    Queue queue = new ArrayDeque<Integer>();
    queue.add(2);
    Assert.assertEquals(2, queue.peek());
    Assert.assertEquals(2, queue.poll());
    Assert.assertNull(queue.poll());
  }
}
