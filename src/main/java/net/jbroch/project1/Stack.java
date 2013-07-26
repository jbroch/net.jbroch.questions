/*
 * Copyright 2013 Josh Broch
 * All rights reserved.
 */
package net.jbroch.project1;

/**
 * Interface class for our stack implementation.
 */
public interface Stack {

    /**
     * Push a value onto the stack.
     *
     * @param value The integer value to push onto the top of the stack.
     */
    void push(Integer value);

    /**
     * Remove a value from the stack.
     *
     * @return The integer value on the top of the stack.
     */
    Integer pop();

    /**
     * Return (without removing) a value from the stack.
     *
     * @return The integer value on the top of the stack.
     */
    Integer peek();
}
