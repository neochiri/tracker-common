import com.tlc.tracker.exception.TrackerException;
import com.tlc.tracker.security.TrackerSecurity;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@TrackerException
public @interface TrackerCommon {
}
