package com.github.haysiksel;

import org.jetbrains.annotations.NotNull;

interface DatabaseHandler<T> {

    @NotNull T get();
    boolean isConnected();
    @NotNull String getName();
    void shutdown();

}
