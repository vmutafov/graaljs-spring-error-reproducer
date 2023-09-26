# Reproducer app for an error when creating a GraalVM Polyglot Engine inside Spring Boot using GraalVM 23.1.0

# Steps to reproduce
1. `./mvnw clean install`
2. `java -jar target/graaljs-engine-create-error-reproducer-0.0.1-SNAPSHOT.jar`

# Error log
```
org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'createEngine' defined in com.vmutafov.ReproducerApplication: Failed to instantiate [org.graalvm.polyglot.Engine]: Factory method 'createEngine' threw exception with message: null
        at org.springframework.beans.factory.support.ConstructorResolver.instantiate(ConstructorResolver.java:654) ~[spring-beans-6.0.12.jar!/:6.0.12]
        at org.springframework.beans.factory.support.ConstructorResolver.instantiateUsingFactoryMethod(ConstructorResolver.java:488) ~[spring-beans-6.0.12.jar!/:6.0.12]
        at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.instantiateUsingFactoryMethod(AbstractAutowireCapableBeanFactory.java:1332) ~[spring-beans-6.0.12.jar!/:6.0.12]
        at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBeanInstance(AbstractAutowireCapableBeanFactory.java:1162) ~[spring-beans-6.0.12.jar!/:6.0.12]
        at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:560) ~[spring-beans-6.0.12.jar!/:6.0.12]
        at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:520) ~[spring-beans-6.0.12.jar!/:6.0.12]
        at org.springframework.beans.factory.support.AbstractBeanFactory.lambda$doGetBean$0(AbstractBeanFactory.java:325) ~[spring-beans-6.0.12.jar!/:6.0.12]
        at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:234) ~[spring-beans-6.0.12.jar!/:6.0.12]
        at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:323) ~[spring-beans-6.0.12.jar!/:6.0.12]
        at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:199) ~[spring-beans-6.0.12.jar!/:6.0.12]
        at org.springframework.beans.factory.support.DefaultListableBeanFactory.preInstantiateSingletons(DefaultListableBeanFactory.java:973) ~[spring-beans-6.0.12.jar!/:6.0.12]
        at org.springframework.context.support.AbstractApplicationContext.finishBeanFactoryInitialization(AbstractApplicationContext.java:942) ~[spring-context-6.0.12.jar!/:6.0.12]
        at org.springframework.context.support.AbstractApplicationContext.refresh(AbstractApplicationContext.java:608) ~[spring-context-6.0.12.jar!/:6.0.12]
        at org.springframework.boot.SpringApplication.refresh(SpringApplication.java:737) ~[spring-boot-3.1.4.jar!/:3.1.4]
        at org.springframework.boot.SpringApplication.refreshContext(SpringApplication.java:439) ~[spring-boot-3.1.4.jar!/:3.1.4]
        at org.springframework.boot.SpringApplication.run(SpringApplication.java:315) ~[spring-boot-3.1.4.jar!/:3.1.4]
        at org.springframework.boot.SpringApplication.run(SpringApplication.java:1309) ~[spring-boot-3.1.4.jar!/:3.1.4]
        at org.springframework.boot.SpringApplication.run(SpringApplication.java:1298) ~[spring-boot-3.1.4.jar!/:3.1.4]
        at com.vmutafov.ReproducerApplication.main(ReproducerApplication.java:12) ~[classes!/:0.0.1-SNAPSHOT]
        at java.base/jdk.internal.reflect.DirectMethodHandleAccessor.invoke(DirectMethodHandleAccessor.java:103) ~[na:na]
        at java.base/java.lang.reflect.Method.invoke(Method.java:580) ~[na:na]
        at org.springframework.boot.loader.MainMethodRunner.run(MainMethodRunner.java:49) ~[graaljs-engine-create-error-reproducer-0.0.1-SNAPSHOT.jar:0.0.1-SNAPSHOT]
        at org.springframework.boot.loader.Launcher.launch(Launcher.java:95) ~[graaljs-engine-create-error-reproducer-0.0.1-SNAPSHOT.jar:0.0.1-SNAPSHOT]
        at org.springframework.boot.loader.Launcher.launch(Launcher.java:58) ~[graaljs-engine-create-error-reproducer-0.0.1-SNAPSHOT.jar:0.0.1-SNAPSHOT]
        at org.springframework.boot.loader.JarLauncher.main(JarLauncher.java:65) ~[graaljs-engine-create-error-reproducer-0.0.1-SNAPSHOT.jar:0.0.1-SNAPSHOT]
Caused by: org.springframework.beans.BeanInstantiationException: Failed to instantiate [org.graalvm.polyglot.Engine]: Factory method 'createEngine' threw exception with message: null
        at org.springframework.beans.factory.support.SimpleInstantiationStrategy.instantiate(SimpleInstantiationStrategy.java:171) ~[spring-beans-6.0.12.jar!/:6.0.12]
        at org.springframework.beans.factory.support.ConstructorResolver.instantiate(ConstructorResolver.java:650) ~[spring-beans-6.0.12.jar!/:6.0.12]
        ... 24 common frames omitted
Caused by: java.lang.ExceptionInInitializerError: null
        at org.graalvm.polyglot.Engine.getImpl(Engine.java:438) ~[polyglot-23.1.0.jar!/:na]
        at org.graalvm.polyglot.Engine$Builder.build(Engine.java:736) ~[polyglot-23.1.0.jar!/:na]
        at org.graalvm.polyglot.Engine.create(Engine.java:346) ~[polyglot-23.1.0.jar!/:na]
        at com.vmutafov.ReproducerApplication.createEngine(ReproducerApplication.java:18) ~[classes!/:0.0.1-SNAPSHOT]
        at com.vmutafov.ReproducerApplication$$SpringCGLIB$$0.CGLIB$createEngine$0(<generated>) ~[classes!/:0.0.1-SNAPSHOT]
        at com.vmutafov.ReproducerApplication$$SpringCGLIB$$2.invoke(<generated>) ~[classes!/:0.0.1-SNAPSHOT]
        at org.springframework.cglib.proxy.MethodProxy.invokeSuper(MethodProxy.java:258) ~[spring-core-6.0.12.jar!/:6.0.12]
        at org.springframework.context.annotation.ConfigurationClassEnhancer$BeanMethodInterceptor.intercept(ConfigurationClassEnhancer.java:331) ~[spring-context-6.0.12.jar!/:6.0.12]
        at com.vmutafov.ReproducerApplication$$SpringCGLIB$$0.createEngine(<generated>) ~[classes!/:0.0.1-SNAPSHOT]
        at java.base/jdk.internal.reflect.DirectMethodHandleAccessor.invoke(DirectMethodHandleAccessor.java:103) ~[na:na]
        at java.base/java.lang.reflect.Method.invoke(Method.java:580) ~[na:na]
        at org.springframework.beans.factory.support.SimpleInstantiationStrategy.instantiate(SimpleInstantiationStrategy.java:139) ~[spring-beans-6.0.12.jar!/:6.0.12]
        ... 25 common frames omitted
Caused by: java.lang.NullPointerException: null
        at java.base/java.util.Objects.requireNonNull(Objects.java:233) ~[na:na]
        at java.base/sun.nio.fs.UnixFileSystem.getPath(UnixFileSystem.java:296) ~[na:na]
        at java.base/java.nio.file.Path.of(Path.java:148) ~[na:na]
        at org.graalvm.polyglot.Engine$ClassPathIsolation.collectClassPathJars(Engine.java:1988) ~[polyglot-23.1.0.jar!/:na]
        at org.graalvm.polyglot.Engine$ClassPathIsolation.createIsolatedTruffleModule(Engine.java:1783) ~[polyglot-23.1.0.jar!/:na]
        at org.graalvm.polyglot.Engine$ClassPathIsolation.createIsolatedTruffle(Engine.java:1723) ~[polyglot-23.1.0.jar!/:na]
        at org.graalvm.polyglot.Engine$1.searchServiceLoader(Engine.java:1682) ~[polyglot-23.1.0.jar!/:na]
        at org.graalvm.polyglot.Engine$1.run(Engine.java:1668) ~[polyglot-23.1.0.jar!/:na]
        at org.graalvm.polyglot.Engine$1.run(Engine.java:1663) ~[polyglot-23.1.0.jar!/:na]
        at java.base/java.security.AccessController.doPrivileged(AccessController.java:319) ~[na:na]
        at org.graalvm.polyglot.Engine.initEngineImpl(Engine.java:1663) ~[polyglot-23.1.0.jar!/:na]
        at org.graalvm.polyglot.Engine$ImplHolder.<clinit>(Engine.java:186) ~[polyglot-23.1.0.jar!/:na]
        ... 37 common frames omitted
```

# Java version
```
java version "21" 2023-09-19
Java(TM) SE Runtime Environment Oracle GraalVM 21+35.1 (build 21+35-jvmci-23.1-b15)
Java HotSpot(TM) 64-Bit Server VM Oracle GraalVM 21+35.1 (build 21+35-jvmci-23.1-b15, mixed mode, sharing)
```
