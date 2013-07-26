/*
 * Copyright 2013 Josh Broch
 * All rights reserved.
 */
package net.jbroch.project.stack;

import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

public class StackImplTest {

    /**
     * This is just an example test. If you want different behavior for popping an empty stack, then just update the
     * unit test accordingly.
     */
    @Test
    public void popEmptyStack() {
        final Stack s = new StackImpl();
        assertThat(s.pop(), nullValue());
    }

    // ======================================================================
    // Other test cases can be added here.
    // ======================================================================
}
