package reactor;

import com.sun.tools.javac.util.List;
import org.junit.Test;
import reactor.core.publisher.Mono;

import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description: spring5.0-2018
 * @Author: johnwonder
 * @Date: 2023/2/9
 */
public class ReactorTest {

	@Test
	public  void testCache(){


		Mono<String> sessionMono = Mono.defer(this::retrieveSession).cache();

		Mono<String> sessionMono1 = Mono.fromSupplier(() -> {

			System.out.println(new Date());
			return "null";
		});

//        Mono<String> sessionMono2 = Mono.defer(this::retrieveSession);

		sessionMono.subscribe(System.out::println);

		sessionMono1.subscribe(System.out::println);



		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		sessionMono.subscribe(System.out::println);
		sessionMono1.subscribe(System.out::println);
	}

	private Mono<String> retrieveSession() {

		System.out.println(new Date());
		return Mono.just("aada");
	}
	@Test
	public void testMonoDefer(){

		//声明阶段创建DeferClass对象

		Mono<Date> m1 = Mono.just(new Date());
		Mono<Date> m2 = Mono.defer(()->Mono.just(new Date()));
		m1.subscribe(System.out::println);
		m2.subscribe(System.out::println);
		//延迟5秒钟
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		m1.subscribe(System.out::println);
		m2.subscribe(System.out::println);

//        版权声明：本文为CSDN博主「PolarisHuster」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
//        原文链接：https://blog.csdn.net/john1337/article/details/104205774





	}

	@Test
	public void testMonoDefer1(){

		//https://www.5axxw.com/questions/content/cx6fs4
		//defer 返回的是Mono类型
		final AtomicInteger counter = new AtomicInteger();
		Mono.just(List.of(1))
				.doOnNext(i -> System.out.println("doOnNext " + counter.incrementAndGet()))
				.map(i -> {
					System.out.println("map " + counter.get());
					return i;
				})
				.then(Mono.fromCallable(() -> thenFunctionSupplier(counter)))
				//.then(Mono.fromSupplier(() -> thenFunctionSupplier(counter)))
//                .then(Mono.defer(() -> thenFunction(counter)))
				.subscribe(System.out::println);
	}
	private static Mono<Integer> thenFunction(final AtomicInteger counter) {
		System.out.println("then " + counter.get());
		return Mono.just(2);
	}

	private static  Integer thenFunctionSupplier(final AtomicInteger counter) {
		System.out.println("then " + counter.get());
		return  2;
	}
//
//    private static  Integer thenFunctionCallable(final AtomicInteger counter) {
////        return Mono.fromCallable(() -> {
////            System.out.println("then " + counter.get());
////            return 2;
////        });
//    }

	public Mono<String> retrieveSession(int id) {

		return Mono.just("id:"+id);
	}
}
