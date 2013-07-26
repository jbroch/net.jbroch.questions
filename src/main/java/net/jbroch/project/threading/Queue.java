/*
 * Copyright 2013 Josh Broch
 * All rights reserved.
 */

package net.jbroch.project.threading;

import java.util.ArrayList;

/**
 * A basic queue implementation for use in the threading project.
 * 
 * @param <T> The type of object stored in the queue.
 */
class Queue<T> {

    private final int maxSize;
    private final ArrayList<T> queue;

    public Queue(final int maxSize) {
        if (maxSize < 1) {
            throw new IllegalArgumentException("Max queue size must be at least 1.");
        }
        this.maxSize = maxSize;
        this.queue = new ArrayList<T>();
    }

    /**
     * Add an object to the tail of the queue.
     * 
     * @param obj The object to add to the queue.
     * @return true if the add was successful, false otherwise.
     */
    public boolean addTail(final T obj) {
        if (this.queue.size() >= this.maxSize) {
            return false;
        }
        this.queue.add(obj);
        return true;
    }

    /**
     * Removes an object from the head queue (if available).
     * 
     * @return The object at the front of the queue.
     */
    public T removeHead() {
        if (this.queue.isEmpty()) {
            return null;
        }
        return this.queue.remove(0);
    }

    /**
     * Evaluates whether or not the queue is empty.
     * 
     * @return True if the queue is empty.
     */
    public boolean isEmpty() {
        return this.queue.isEmpty();
    }

    /**
     * Evaluates whether or not the queue is full.
     * 
     * @return True if the queue is full.
     */
    public boolean isFull() {
        return this.queue.size() >= this.maxSize;
    }

    /**
     * Get the number of elements in the queue.
     * 
     * @return The number of elements in the queue.
     */
    public int size() {
        return this.queue.size();
    }
}
