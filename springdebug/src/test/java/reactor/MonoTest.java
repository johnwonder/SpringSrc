package reactor;

import org.junit.Test;
import reactor.core.publisher.Mono;

import java.util.Optional;

/**
 * @Description: spring5.0-2018
 * @Author: johnwonder
 * @Date: 2023/2/10
 */
public class MonoTest {

	//https://blog.csdn.net/xxxcyzyy/article/details/103841548
	@Test
	public void testMonoJust(){
		Mono.justOrEmpty(Optional.empty()).subscribe(System.out::println);
		Mono.justOrEmpty("justOrEmpty1").subscribe(System.out::println);
		Mono.justOrEmpty(Optional.of("justOrEmpty2")).subscribe(System.out::println);

		Mono.create(sink -> sink.success("create MonoSink")).subscribe(System.out::println);
	}
}
