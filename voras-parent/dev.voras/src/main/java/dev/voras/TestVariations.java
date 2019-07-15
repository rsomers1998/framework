package dev.voras;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * Indicates the test has multiple Test Variations
 * 
 * @author Michael Baylis
 *
 */
@Retention(RUNTIME)
@Target(ElementType.TYPE)
public @interface TestVariations {

	TestVariation[] value();
}
