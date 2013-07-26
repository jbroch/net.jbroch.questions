/*
 * Copyright 2013 Josh Broch
 * All rights reserved.
 */
package net.jbroch.project1;

import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

public class StackImplTest {

    @Test
    public void popEmptyStack() {
        final Stack s = new StackImpl();
        assertThat(s.pop(), nullValue());
    }
}
