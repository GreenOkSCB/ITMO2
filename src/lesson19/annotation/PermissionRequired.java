package lesson19.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// описание к чему может быть отнесенна аннотация
//@Target()  указывает на сферу ответственности: аннотации  METHOD, CONSTRUCTOR, FIELD
//@Retention()  как долго сохраняется аннотация: при компиляции, RUNTIME
//@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface PermissionRequired {

    User.Permission value();  // может вернуть String, примитивы, enum, аннотации

}
