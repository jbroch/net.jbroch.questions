/*
 * Copyright 2013 Josh Broch
 * All rights reserved.
 */

package net.jbroch.project.threading;

import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

/**
 * Test cases for {@link Queue}.
 */
public class QueueTest {

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void queueSize0() {
        new Queue<Integer>(0);
    }

    @Test
    public void removeEmptyQueue() {
        final Queue<Integer> q = new Queue<Integer>(1);
        // initial state
        assertThat(q.isEmpty(), is(true));
        assertThat(q.isFull(), is(false));
        assertThat(q.size(), is(0));

        // try to one element
        assertThat(q.removeHead(), nullValue());
    }

    @Test
    public void addFullQueue() {
        final Queue<Integer> q = new Queue<Integer>(1);
        // initial state
        assertThat(q.isEmpty(), is(true));
        assertThat(q.isFull(), is(false));
        assertThat(q.size(), is(0));

        // add one element
        assertThat(q.addTail(1), is(true));
        assertThat(q.isEmpty(), is(false));
        assertThat(q.isFull(), is(true));
        assertThat(q.size(), is(1));

        // try to add another
        assertThat(q.addTail(2), is(false));
    }

    @Test
    public void fillQueueEmptyQueue() {
        final Queue<Integer> q = new Queue<Integer>(5);
        // initial state
        assertThat(q.isEmpty(), is(true));
        assertThat(q.isFull(), is(false));

        assertThat(q.addTail(1), is(true));
        assertThat(q.addTail(2), is(true));
        assertThat(q.addTail(3), is(true));
        assertThat(q.addTail(4), is(true));
        assertThat(q.addTail(5), is(true));

        // queue is full
        assertThat(q.isFull(), is(true));
        assertThat(q.size(), is(5));

        assertThat(q.removeHead(), equalTo(1));
        assertThat(q.removeHead(), equalTo(2));
        assertThat(q.removeHead(), equalTo(3));
        assertThat(q.removeHead(), equalTo(4));
        assertThat(q.removeHead(), equalTo(5));

        // queue is empty
        assertThat(q.isEmpty(), is(true));
        assertThat(q.size(), is(0));
    }

    @Test
    public void addRemove() {
        final Queue<Integer> q = new Queue<Integer>(5);
        // initial state
        assertThat(q.isEmpty(), is(true));
        assertThat(q.isFull(), is(false));

        for (int i = 1; i < 6; i++) {
            // add, remove
            assertThat(q.addTail(i), is(true));
            assertThat(q.size(), is(1));
            assertThat(q.removeHead(), equalTo(i));
            assertThat(q.isEmpty(), is(true));
        }

        // queue is empty
        assertThat(q.isEmpty(), is(true));
    }
}
