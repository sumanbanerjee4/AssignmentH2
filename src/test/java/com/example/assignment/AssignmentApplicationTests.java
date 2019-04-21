//package com.example.assignment;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//
//import org.junit.Test;
//
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.orm.ObjectOptimisticLockingFailureException;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import com.example.assignment.model.Contacts;
//import com.example.assignment.repo.ContactRepo;
//
//import javax.persistence.EntityManagerFactory;
//import java.util.Optional;
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//import java.util.concurrent.TimeUnit;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class AssignmentApplicationTests {
//
//	@Autowired
//	private ContactRepo repo;
//
//
//	
//
//	//@Test(expected = ObjectOptimisticLockingFailureException.class)
//	ExecutorService es = Executors.newFixedThreadPool(2);
//	@Test
//	public void t() {
//		Contacts contacts = Contacts.create("Diana",3000,"Admin@com");
//
//		String name = contacts.getName();
//		System.out.println("-- contacts persisted --");
//		System.out.println(findName(name));
//
//
//
//		//user 1
//		es.execute(() ->  {
//			System.out.println(" -- user1 updating PhoneNumber to 2000 --");
//			Contacts user2 = findName(name);
//			System.out.println("user1 loaded entity: " + user2);
//			user2.setPhoneNumber(2000);
//			//little delay
//			try {
//				Thread.sleep(1000);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//			try {
//				repo.save(user2);
//			} catch (Exception e) {
//				System.err.println("user1 " + e);
//				System.out.println("user1 after error: " + findName(name));
//				return;
//			}
//			System.out.println("user1 finished: " + findName(name));
//		});
//
//		//user 2
//		es.execute(() -> {
//			System.out.println(" -- user2 updating PhoneNumber to 4000 --");
//			Contacts user3 = findName(name);
//			System.out.println("user2 loaded entity: " + user3);
//			user3.setPhoneNumber(4000);
//			try {
//				repo.save(user3);
//			} catch (Exception e) {
//				System.err.println("user2: " + e);
//				System.out.println("user2 after error: " + findName(name));
//				return;
//			}
//			System.out.println("user2 finished: " + findName(name));
//		});
//
//		es.shutdown();
//		try {
//			es.awaitTermination(10, TimeUnit.MINUTES);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//
//	}
//
//	private Contacts findName(String name) {
//		Optional<Contacts> opt = repo.findByName(name);
//		return opt.isPresent() ? opt.get() : null;
//	}
//
//}