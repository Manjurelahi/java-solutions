# Java Solutions

A collection of small Java examples for learning language features, object-oriented design, concurrency, streams, XML, and interview-style problems. Each top-level topic is a separate set of examples, not part of one application.

## Topics

| Folder | What to explore |
| --- | --- |
| `OOPs` | Object-oriented and core-language behavior |
| `MethodOverriding` | Overriding, inheritance, and exception rules |
| `InitBlock` | Instance initialization blocks |
| `DesignPatterns` | Pattern examples, including singleton variants |
| `Multithreading` | Thread coordination and deadlock examples |
| `JDK8Plus` | Streams, collectors, and newer Java APIs |
| `InterviewQuiz` | Algorithms, coding exercises, and the string calculator project |
| `WhatOutput` | Small examples intended for predicting program output |
| `SillyButTricky` | Less-obvious Java behavior and edge cases |
| `XML` | XML writing and DOM, SAX, and StAX parsing |

Most examples are standalone source files in the default package. Several folders contain classes with the same names, so compile and run one example at a time from its own directory rather than compiling every Java file together.

## Java version

Use JDK 21 or newer to run all examples. The `JDK8Plus` folder includes examples using APIs introduced after Java 8, including `Stream.toList()` and `List.getFirst()`. The separate `InterviewQuiz/str-calc` Maven project targets Java 8 bytecode, but can also be built with a newer JDK.

## Running an example

From the folder containing the example, compile its source file and run the class with the same name. For example, from `InterviewQuiz`:

```text
javac MinWindowSubstr.java
java MinWindowSubstr
```

Run the minimum-window regression checks from that same folder:

```text
javac MinWindowSubstr.java MinWindowSubstrTest.java
java MinWindowSubstrTest
```

The string calculator is the repository's Maven project. Run its tests from the repository root:

```text
mvn -f InterviewQuiz/str-calc/pom.xml test
```

Start with a topic folder, run a small example, then change its input and observe how the output changes. Comments and sample output are provided in some files, but coverage and test conventions vary between examples.
