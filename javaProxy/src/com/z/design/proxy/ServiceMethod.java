package com.z.design.proxy;

import com.sun.istack.internal.Nullable;


abstract class ServiceMethod<T> {

    abstract @Nullable T invoke(Object[] args);
}
