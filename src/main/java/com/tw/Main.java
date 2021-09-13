package com.tw;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Library library = new Library(new Input(),new Output(),new ArrayList<>());
        library.func();
    }
}
