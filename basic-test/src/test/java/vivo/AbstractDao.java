package vivo;

import java.lang.reflect.ParameterizedType;

public abstract class AbstractDao<T> {
    public Class<T> getActualType() {
        ParameterizedType parameterizedType = (ParameterizedType) this.getClass().getGenericSuperclass();
        return (Class<T>) parameterizedType.getActualTypeArguments()[0];
    }
}
