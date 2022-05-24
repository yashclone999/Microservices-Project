package com.functionalInterfaces;

import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Predicate;

@SuppressWarnings("rawtypes")
public class FunctionalInterfacesImpl {
	static public Predicate<List> checkNullList = List::isEmpty;
	static public Predicate<Set> checkNullSet = Set::isEmpty;
	static public Consumer<String> print = System.out::println;
}
