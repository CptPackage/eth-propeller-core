package org.adridadou.ethereum.propeller.converters.input;

/**
 * Created by davidroon on 27.04.16.
 * This code is released under Apache 2 license
 */
public interface InputTypeConverter {
    boolean isOfType(Class<?> cls);

    Object convert(Object obj);
}
