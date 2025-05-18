# Dependency Injection Demo Project

This project demonstrates different approaches to Dependency Injection (DI) in Java applications, including a sample banking application pattern.

## Project Overview

This application demonstrates how to implement the Dependency Injection pattern using different techniques:

1. **Static Dependency Injection** - Hard-coded dependencies
2. **Dynamic Dependency Injection** - Runtime dependency resolution
3. **Spring XML Configuration-based Dependency Injection**
4. **Spring Annotation-based Dependency Injection**

## Core Components

### Interfaces

- **IDao** - Data Access Object interface with `getData()` method
- **IMetier** - Business layer interface with `calcul()` method

### Implementations

- **DaoImpl** - Database implementation of IDao (returns 23)
- **DaoImplV2** - Web Service implementation of IDao (returns 11)
- **MetierImpl** - Business logic implementation, consumes IDao

## Dependency Injection Methods

### 1. Static Dependency Injection

The class `PresentationV1` demonstrates static injection by directly instantiating dependencies.

```java
DaoImplV2 dao = new DaoImplV2();
MetierImpl metier = new MetierImpl(dao); // Constructor injection
```

Advantages:

- Simple to implement
- Easy to understand

Disadvantages:

- Hard-coded dependencies
- Difficult to test and maintain
- Changes require recompilation

### 2. Dynamic Dependency Injection

The class `PresentationV2` demonstrates dynamic injection using reflection.

```java
// Read class names from config.txt
String daoClassName = scanner.nextLine();
Class cDao = Class.forName(daoClassName);
IDao dao = (IDao) cDao.getConstructor().newInstance();
```

Advantages:

- Flexible, no recompilation needed
- Configuration is external to code

Disadvantages:

- Complex to implement
- Potential runtime errors

### 3. Spring XML-based Dependency Injection

The class `PresAvecSpringXML` demonstrates DI using Spring XML configuration.

```java
ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
IMetier metier = (IMetier) context.getBean("metier");
```

Advantages:

- External configuration
- No code changes required for dependency changes
- Well-established pattern

Disadvantages:

- XML can be verbose
- No compile-time safety

### 4. Spring Annotation-based Dependency Injection

The class `PresAvecSpringAnnotations` demonstrates DI using Spring annotations.

```java
ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
IMetier metier = context.getBean(IMetier.class);
```

Advantages:

- Less configuration needed
- Type safety
- Cleaner code

Disadvantages:

- Requires annotation processing
- Annotations couple code to Spring framework

## How to Run the Application

To run the application, use one of the following approaches:

1. **Static Injection**:

   ```
   java presentation.PresentationV1
   ```

2. **Dynamic Injection**:

   ```
   java presentation.PresentationV2
   ```

   (Ensure config.txt is in the classpath)

3. **Spring XML Injection**:

   ```
   java presentation.PresAvecSpringXML
   ```

   (Ensure config.xml is in the classpath)

4. **Spring Annotation Injection**:
   ```
   java presentation.PresAvecSpringAnnotations
   ```

## Expected Results

Each mode of dependency injection should produce a calculation result:

- Using `DaoImpl`: Result should be 23 \* 23 = 529
- Using `DaoImplV2`: Result should be 11 \* 23 = 253

The specific implementation used depends on the injection configuration.
