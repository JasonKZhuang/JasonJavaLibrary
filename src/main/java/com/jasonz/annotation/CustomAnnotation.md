# Custom Annotations
To define any custom annotation, we first need to declare it using an `@interface` tag.  
Then we define the target and scope using `Meta Annotations`.(Retention, Target, Inherited).  
Custom annotations can be defined on three levels:  
* Class Level
* Field Level
* Method Level

# Reference
[Java Annotations](https://jenkov.com/tutorials/java/annotations.html)
[Java Annotations #1 - The Basics](https://www.youtube.com/watch?v=0VPRkVWkM70&list=PLL8woMHwr36FSdBcnqZQKSAyshyN4nkVy&index=1)
[Java Annotations #2 - Create your own custom Java Annotations](https://www.youtube.com/watch?v=UlhtkjfxUUU&list=PLL8woMHwr36FSdBcnqZQKSAyshyN4nkVy&index=2)


## Define Custom Annotation
### Class Level
```java
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.Type)
public @interface CustomAnnotation{ ... }
```
🧑🏽‍🏫The above CustomAnnotation has a runtime retention policy, and we can apply it to all classes.  
Since it has no methods, it serves as a simple marker to mark the classes we need.  
One thing to note here is that any class-level custom annotation cannot have any parameters and must `not` throw any exception.  
Additionally, the return value types are restricted to primitives, `String`, `Class`, `enums`, `annotations`, `their arrays`, and the default value cannot be null.

### Field Level
```java
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface CustomAnnotation{ ... }
```
🏟 Similar to the class level, we can define field level annotations and limit the scope to them.  

### Method Level
```java
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface CustomAnnotation{ ... }
```
👨🏾‍🔧 We can also declare an annotation with runtime retention to apply to our classes’ methods.

## Using Custom Annotations
🪛 Here is an example to demonstrate the use of custom annotation. It is about 2 classes, Car and Engine. 
Suppose we have a requirement such that BasicEngine needs to apply to all types of cars.
In that case, we can develop custom annotation such as `@BasicEngine` and annotate all kinds of Car implementations (e.g., HatchBackCars, SportsCars, SedanCars, etc.,) with BasicEngine.  
### Custom Annotation Class(interface):
```java
import java.lang.annotation.*;

@Inherited
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface BasicEngine {
    String mileage() default "20";
    String fuelType() default "Gasoline";
}
```

Class using the custom annotation(no need to import):  
```java
@BasicEngine(mileage = "80",fuelType = "Diesel")
public class Car {
    String make;
    String model;

    public Car(String make, String model) {
        this.make = make;
        this.model = model;
    }

    public void getCarDetails() {
        System.out.println("Car Manufacturer: " + make);
        System.out.println("Car Model: " + model);
    }
}
```

Driver class to test out the above:
```java
public class MyMain {
    public static void main(String[] args) {
        MyMain myMain = new MyMain();
        myMain.testClassLevelAnnotation();

    }
    private void testClassLevelAnnotation(){
        Car car = new Car("Toyota", "Camry");
        car.getCarDetails();
        Class carClass = car.getClass();

        Annotation testAnn = carClass.getAnnotation(BasicEngine.class);
        BasicEngine engine = (BasicEngine)testAnn;
        System.out.println("BasicEngine Mileage: " + engine.mileage());
        System.out.println("BasicEngine FuelType: " + engine.fuelType());
    }
}
```
### Custom Annotation on Field:  
```java
@Retention(RetentionPolicy.RUNTIME) 
@Target(ElementType.FIELD) 
public @interface GFGElement { 
	public String key() default ""; 
}

```



### Custom Annotation on Method:  
To serialize an object to a JSON string, we want to execute some method to initialize an object.
For that reason, we are going to create an annotation to mark this method.
First of All, declared a public annotation with runtime visibility that we can apply to our classes methods.
```java
@Retention(RetentionPolicy.RUNTIME) 
@Target(ElementType.METHOD) 
public @interface Init { 
}
```

# Meta Annotations
🏴Meta annotations are annotations applied to other annotations to increase their scope. It is very important as it allows us to describe annotations using other annotations, and compose annotations.
♨️Java incorporates significant meta-annotations directly within the language blueprint:

## @Inherited
👨‍👦 By default, an annotation cannot inherit from its superclass. However, if we need to inherit an annotation from a superclass to a subclass, we use the @Inherited annotation.
```java
@Inherited
public @interface CustomAnnotation { ... }
@CustomAnnotation
public class ParentClass { ... }
public class ChildClass extends ParentClass { ... }
```
Here, the ChildClass class will automatically get the CustomAnnotation since it is inheriting from the ParentClass. ChildClass will be able to call any of CustomAnnotations functionality.  

@Target
🎯 Annotations’ scopes are based on the requirements of the method or file, like constructors or declarations.
We can restrict an annotation to be applied to specific targets using the @Target annotation.
```java
@Target(ElementType.METHOD)
public @interface CustomAnnotation{ ... }
```
In the code above, CustomAnnotation is only restricted to methods, i.e. fields, packages, etc, won’t be annotated with it.

@Retention
🤔 `@Retention` specifies the level up to which an annotation will be available.
There are three levels up to which Java allows us to define retention policies:

* RetentionPolicy.SOURCE— available at the source level and ignored by the compiler
* RetentionPolicy.CLASS— available to the compiler at compile-time and ignored by the JVM
* RetentionPolicy.RUNTIME— available to the JVM
```java
@Retention(RetentionPolicy.RUNTIME)
public @interface CustomAnnotation{ ... }
```