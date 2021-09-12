package com.jasonz.java8Features;

/**
 * what is Functional Interface? An interface with exactly one abstract method
 * is called Functional Interface. '@FunctionalInterface' annotation is added so
 * that we can mark an interface as functional interface.
 * 
 * It is not mandatory to use it, but it’s best practice to use it with
 * functional interfaces to avoid addition of extra methods accidentally. If the
 * interface is annotated with @FunctionalInterface annotation , and we try to
 * have more than one abstract method, it throws compiler error.
 * 
 * Why do we use functional interfaces? The major benefit of java 8 functional
 * interfaces is that we can use lambda expressions to instantiate them and
 * avoid using bulky anonymous class implementation.
 * 
 * Example: java.lang.Runnable is a great example of functional interface with
 * single abstract method run().
 * 
 * @author Jason Zhuang 23 Jun. 2021
 *
 */
@FunctionalInterface
public interface UsingFunctionalInterface
{
	int myMethod(int arg);
}

// Not functional because equals is already an implicit member (Object class)
interface FooA
{
	boolean equals(Object obj);
}

// Functional because Comparator has only one abstract non-Object method
interface Comparator<T>
{
	boolean equals(Object obj);

	int compare(T o1, T o2);
}

// Not functional because method Object.clone is not public
interface FooB
{
	int m();

	Object clone();
}

// Functional: two methods, but they have the same signature
interface Xa
{
	int m(Iterable<String> arg);
}

interface Ya
{
	int m(Iterable<String> arg);
}

interface Za extends Xa, Ya
{
}

// Functional: Y.m is a subsignature & return-type-substitutable
interface Xb
{
	Iterable m(Iterable<String> arg);
}

interface Yb
{
	Iterable<String> m(Iterable arg);
}

interface Zb extends Xb, Yb
{
}

// Not functional: No method has a same sub signature of all abstract methods
interface Xc
{
	int m(Iterable<String> arg);
}

interface Yc
{
	int m(Iterable<Integer> arg);
}

//interface Zc extends Xc, Yc
//{
//}

//Not functional: No method has a same sub signature of all abstract methods
interface Xd { int m(Iterable<String> arg, Class c); }
interface Yd { int m(Iterable arg, Class<?> c); }
//interface Zd extends Xd, Yd {}

//Compiler error: no method is return type substitutable
interface Xe { long m(); }
interface Ye { int  m(); }
//interface Ze extends Xe, Ye {}

//Compiler error: different signatures, same erasure
interface FooF<T> { void m(T arg); }
interface BarF<T> { void m(T arg); }
//interface FooBarF<X, Y> extends FooF<X>, BarF<Y> {}

