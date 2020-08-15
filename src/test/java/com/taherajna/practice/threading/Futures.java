package com.taherajna.practice.threading;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import org.junit.Assert;
import org.junit.Test;

public class Futures {

    @Test
    public void name() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Future<Integer> future = executorService.submit(new MyTask());
        Assert.assertEquals(12, (int) future.get());
    }

    class MyTask implements Callable<Integer> {

        @Override
        public Integer call() throws Exception {
            Thread.sleep(100);
            return 12;
        }
    }
}
