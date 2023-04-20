package org.alexdev.interfaces;

import java.util.List;

public interface Convertible<T> {
    List<T> getItem(String[] itemsFiles);
}
