package com.fundamentosplatzi.springboot.fundamentos;

import com.fundamentosplatzi.springboot.fundamentos.bean.MyBean;
import com.fundamentosplatzi.springboot.fundamentos.bean.MyBeanWithDependency;
import com.fundamentosplatzi.springboot.fundamentos.bean.MyBeanWithDependencyImplement;
import com.fundamentosplatzi.springboot.fundamentos.bean.MyBeanWithProperties;
import com.fundamentosplatzi.springboot.fundamentos.component.ComponentDependency;
import com.fundamentosplatzi.springboot.fundamentos.entity.User;
import com.fundamentosplatzi.springboot.fundamentos.pojo.UserPojo;
import com.fundamentosplatzi.springboot.fundamentos.repository.UserRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class FundamentosApplication  implements CommandLineRunner {

	Log LOGGER = LogFactory.getLog(FundamentosApplication.class);
	private ComponentDependency componentDependency;
    private MyBean myBean;
	private MyBeanWithDependency myBeanWithDependency;
	private MyBeanWithProperties myBeanWithProperties;
    private UserPojo userPojo;
	private UserRepository userRepository;


	public FundamentosApplication(@Qualifier("componentTwoImplement") ComponentDependency componentDependency,
                                  MyBean myBean, MyBeanWithDependency myBeanWithDependency,
                                  MyBeanWithProperties myBeanWithProperties, UserPojo userPojo, UserRepository userRepository){
		this.componentDependency = componentDependency;
        this.myBean = myBean;
		this.myBeanWithDependency = myBeanWithDependency;
		this.myBeanWithProperties = myBeanWithProperties;
        this.userPojo = userPojo;
		this.userRepository= userRepository;

	}

	public static void main(String[] args) {
		SpringApplication.run(FundamentosApplication.class, args);
	}

	@Override
	public void run(String... args){
		/*ejemplosAnteriores();*/
		saveUsersInDataBase();
		getInformationJpqlFromUser();
	}

	private void getInformationJpqlFromUser(){
		/*LOGGER.info("Usuario encontrado"+
				userRepository.findByUserEmail("user3@correo.com")
				.orElseThrow(()-> new RuntimeException(" No se encontro nada perri")));


		userRepository.findAndSort("user", Sort.by("id").descending())
				.stream().
				forEach( user -> LOGGER.info("Usruario encontrado "+user));

		userRepository.findByName("Jhon").stream().forEach(user -> LOGGER.info("User con Query method "+user));

		LOGGER.info("usuario encontrado por correo y nombre: "+userRepository.findByEmailAndName("paul@correo.com","Paul").
				orElseThrow( ()-> new RuntimeException("Usuario no encontrado")));

		userRepository.findByNameLike("%J%").stream().forEach(user -> LOGGER.info("usuario encontrado con fimdLike: "+user));

		userRepository.findByNameOrEmail("Julia",null).stream().
				forEach(user -> LOGGER.info("usuario encontrado con or: "+user));*/

		/*userRepository.findByBirthDateBetween(LocalDate.of(1993,5,1),
						LocalDate.of(1994,10,31))
				.stream().
				forEach(user -> LOGGER.info("usuario encontrado por rango de fechas: "+user));

		userRepository.findByNameLikeOrderByIdDesc("%user%")
				.stream().
				forEach(user -> LOGGER.info("usuario encontrado y ordenado: "+user));

		userRepository.findByNameContainingOrderByIdDesc("user")
				.stream().
				forEach(user -> LOGGER.info("usuario encontrado containning y ordenado: "+user));*/

      LOGGER.info("el usuario a partir del named parameter es:  "+ userRepository.getAllByBirthDateAndEmail(LocalDate.of(1994,9,07),"julia@correo.com" ).
              orElseThrow(()-> new RuntimeException("No se encontro el usuario a partir del named parameter")));

	}

	private void saveUsersInDataBase(){
		User user1 = new User("Jhon","jhon@correo.com", LocalDate.of(1993,10,07));
		User user2 = new User("Paul","paul@correo.com", LocalDate.of(1993,9,07));
		User user3 = new User("user3","user3@correo.com", LocalDate.of(1993,8,07));
		User user4 = new User("user4","user4@correo.com", LocalDate.of(1993,7,07));
		User user5 = new User("user5","user5@correo.com", LocalDate.of(1993,6,07));
		User user6 = new User("user6","user6@correo.com", LocalDate.of(1993,5,07));
		User user7 = new User("user7","user7@correo.com", LocalDate.of(1993,4,07));
		User user8 = new User("user8","user8@correo.com", LocalDate.of(1993,3,07));
		User user9 = new User("user9","user9@correo.com", LocalDate.of(1993,2,07));
		User user10 = new User("user10","user10@correo.com", LocalDate.of(1993,1,07));
		User user11 = new User("user11","user11@correo.com", LocalDate.of(1993,10,07));
		User user12= new User("Julia","julia@correo.com", LocalDate.of(1994,9,07));

		List<User> list = Arrays.asList(user1, user2, user3, user4,user5, user6, user7, user8,user9,user10,user11,user12);
		list.stream().forEach(userRepository::save);
	}

	public void ejemplosAnteriores(){
		componentDependency.saludar();
		myBean.print();
		myBeanWithDependency.printWithDependency();
		System.out.println(myBeanWithProperties.function());
		System.out.println(userPojo.getEmail() + " "+userPojo.getPassword());

		try{
			int value = 10/0;
			LOGGER.debug("Mi valor"+value);
		}catch (Exception e){
			LOGGER.error("esto es un error papi quien divide entre 0 digame "+ e.getMessage());
		}
	}

}
