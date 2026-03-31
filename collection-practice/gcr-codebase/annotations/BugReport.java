package annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Repeatable(RepeatableAnnotation.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface BugReport {
	String description();
}
