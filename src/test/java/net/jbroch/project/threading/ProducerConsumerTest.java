/*
 * Copyright 2013 Josh Broch
 * All rights reserved.
 */

package net.jbroch.project.threading;

import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

/**
 * Test cases for Producer/Consumer.
 */
public class ProducerConsumerTest {

    @Test
    public void testProducerConsumer() throws InterruptedException {
        final int maxQueueSize = 50;
        final Queue<Integer> q = new Queue<Integer>(maxQueueSize);
        {
            final Producer producer = new Producer(q, 25);
            producer.start();
            producer.join();
            assertThat(q.size(), is(25));
        }
        {
            final Consumer consumer = new Consumer(q, 25);
            consumer.start();
            consumer.join();
            assertThat(q.isEmpty(), is(true));
        }
    }

}
