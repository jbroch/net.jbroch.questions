/*
 * Copyright 2013 Josh Broch
 * All rights reserved.
 */

package net.jbroch.project.threading;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Producer class to fill the shared queue.
 */
class Consumer extends Thread {

    private static final Logger LOG = LoggerFactory.getLogger(Consumer.class);

    private final Queue<Integer> queue;
    private int elementCount;

    public Consumer(final Queue<Integer> queue, final int elementCount) {
        this.queue = queue;
        this.elementCount = elementCount;
    }

    /**
     * {@inheritDoc}
     * 
     * @see java.lang.Thread#run()
     */
    @Override
    public void run() {
        while (this.elementCount > 0) {
            LOG.debug("Consumer is working... (queue size: {})", this.queue.size());
            /*
             * The logic here needs to be replaced.
             */
            final Integer value = this.queue.removeHead();
            if (value != null) {
                this.elementCount -= 1;
            }
        }
    }
}
