/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.flooringmastery.validation;

import java.lang.annotation.Documented;
import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import java.lang.annotation.Retention;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ FIELD, METHOD, PARAMETER, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Constraint(validatedBy = StateExistsValidator.class)
@Documented
public @interface StateExists {

    String message() default "State exists!";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };


//    @Target({ FIELD, METHOD, PARAMETER, ANNOTATION_TYPE })
//    @Retention(RUNTIME)
////    @Documented
////    @interface List {
////        StateExists[] value();
////    }
}
