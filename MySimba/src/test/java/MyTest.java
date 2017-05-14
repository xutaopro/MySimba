import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.AntPathMatcher;

import com.dao.IUserDao;
import com.dataSoure.MultiDataSource;
import com.mapper.IUserMapper;
import com.model.User;
import com.service.IMenuService;
import com.service.IUserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:SpringContext.xml"})
public class MyTest {

	@Autowired
	private IUserService userService;
	@Autowired
	private IMenuService menuService;
	
	@Test
	public void TestSix(){
		boolean b = userService.checkUser("1", "1");
		System.out.println(b);
	}
	@Test
	public void TestFive(){
		System.out.println("xxxxxxxxxxxxxxxx");
		//测试多数据源
		System.out.println("::::"+MultiDataSource.get());
		//MultiDataSource.set("dataSource2");
		boolean  flag= userService.checkUser("1", "1");
		System.out.println(flag);
	}
	
	@Test
	public void TestThree(){
		///测试spring的工具类  AntPathMatch
		AntPathMatcher match = new AntPathMatcher();
		String pattern= "";
		String path = "/org/list.do";
		match.match(pattern, path);
	}
	
	@Test
	public void TestFour() throws InterruptedException{
		Logger log = Logger.getLogger(this.getClass());
		//测试外部缓存
		log.info("开始测试咯FOur");
		User user = new User();
		user.setAccount("4");
		user.setName("a");
		user.setPwd("4");
		boolean boo= userService.checkUser(user.getName(),user.getPwd());
		
		User user2 =  new User();
		user2.setAccount("4");
		user2.setName("t");
		int x = userService.updateUser2(user2);
		System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
		//2000
		Thread.sleep(4000L);
		
		boolean boo1= userService.checkUser(user.getName(),user.getPwd());
		System.out.println(boo+"........"+boo1);
	}
	
	@Test
	public void TestTwo(){
		Logger log = Logger.getLogger(this.getClass());
		/*userService.checkUser("", "");*/
		/*menuService.listChildren(-1);*/
		/*System.out.println("XXXS");
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:SpringMVC.xml");
		System.out.println(context);
		IUserDao userDao =  (IUserDao) context.getBean("userDao");
		System.out.println(userDao);
		IUserMapper mapper =  (IUserMapper) context.getBean("userMapper");
		System.out.println(mapper);*/
		try{
			
			//测试二级缓存
			log.info("开始测试咯TestTwo");
			User user = new User();
			user.setAccount("4");
			user.setName("a");
			user.setPwd("4");
			boolean boo= userService.checkUser(user.getName(),user.getPwd());
			System.out.println("第一个boo"+boo);
			
			User user2 =  new User();
			user2.setAccount("4");
			user2.setName("t");
			int x = userService.updateUser2(user2);
			System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxx");
			
			Thread.sleep(4000L);
			
			boolean boo1= userService.checkUser(user.getName(),user.getPwd());
			System.out.println(boo+"......."+boo1);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	   public void TestOne(){
		   //测试字符串加密
			
			try {
				System.out.println(Integer.toHexString(170));
				String str = "xutaoTest";
				MessageDigest digest = MessageDigest.getInstance("md5");
				digest.update(str.getBytes());
				byte[] b = digest.digest();
				String temp;
				StringBuffer sb = new StringBuffer();
				System.out.println(b.length);
				for(int i=0;i<b.length;i++){
					System.out.println(b[i]);
					temp = Integer.toHexString(b[i] & 0xFF);
					System.out.println("x:::"+temp);
					if(temp.length()==0){
						sb.append("0");
					}
					sb.append(temp);
				}
				
				System.out.println(sb.toString());
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	   }
		
}
