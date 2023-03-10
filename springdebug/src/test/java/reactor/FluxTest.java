package reactor;

import org.junit.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @Description: spring5.0-2018
 * @Author: johnwonder
 * @Date: 2023/2/10
 */
public class FluxTest {

	@Test
	public void testFluxIterable(){

		List<String> ss =new ArrayList<>();
		ss.add("11");
		ss.add("22");
		ss.add("12");
		Flux.fromIterable(ss).filterWhen(s -> Mono.just(s.startsWith("1")))
				.next().subscribe(System.out::println);

		//每个都输出
		Flux.fromIterable(ss).filterWhen(s -> Mono.just(s.startsWith("1")))
				.doOnNext(System.out::println)
				.subscribe(System.out::println);
	}

	@Test
	public void shouldAnswerWithTrue()
	{
//        Flux.fromIterable(Arrays.asList(1,2,3,4))
//                .subscribe(System.out::println);
//
//        Flux.fromIterable(Arrays.asList(1, 2, 3, 4))
//                .concatMap(this::retrieveSession)
//                .take(2).subscribe(System.out::println);

//        Flux.fromIterable(Arrays.asList(1, 2, 3, 4))
//                .concatMap(this::retrieveSession)
//                .skip(2).take(1)
//                .subscribe(System.out::println);



		//全输出
//        Flux.fromIterable(Arrays.asList(1, 2, 3, 4))
//                .concatMap(this::retrieveSession)
//                .doOnNext(System.out::println)
//                .doOnNext(System.out::println)
//                .subscribe();

		//https://link.sov5.cn/l/DazLdEpDzC
		//https://blog.csdn.net/weixin_47951400/article/details/124292452
		//https://blog.csdn.net/crazymakercircle/article/details/124120506
		Flux<String> cache = Flux.fromIterable(Arrays.asList(1, 2, 3, 4))
				.concatMap(this::retrieveSession)
				.cache();

		cache.next().subscribe(System.out::println);
		cache.skip(1).take(1).subscribe(s -> { System.out.println("2"+ s); });
		//next.doOnNext(System.out::println);

		// next.subscribe(System.out::println);


		Mono.when((s) -> { System.out.println("ccc"); }).subscribe();
//        assertTrue( true );
	}

	private Mono<String> retrieveSession(int i) {

		System.out.println(new Date());
		return Mono.just("aada");
	}
}
