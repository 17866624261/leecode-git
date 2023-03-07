import lombok.experimental.Accessors;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Accessors(chain = true)
@EnableScheduling
@EnableAutoConfiguration
public @interface TestDocument {

}
