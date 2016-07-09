package dev.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import dev.beans.MyService;
import dev.beans.impl.MembershipDao;
import dev.beans.impl.MembershipServiceImpl;
import dev.beans.impl.MyOtherService;
import dev.beans.impl.MyServiceImpl;
import dev.test.DummyDataSource;

@Configuration
@ComponentScan(basePackages="dev.beans.impl.scan")
@EnableTransactionManagement
public class AppConfig {

	@Bean(initMethod="init")
    public MyService myServiceA() {
        return new MyServiceImpl("A");
    }
	
	@Bean(initMethod="init")
    public MyService myServiceB() {
        return new MyServiceImpl("B");
    }
	
	@Bean
	public MyService myServiceC(){
		return new MyOtherService("C");
	}
	
	@Bean
	public MembershipDao membershipDao(){
		return new MembershipDao();
	}
	
	@Bean
	public MembershipServiceImpl membershipServiceImpl(MembershipDao dao){
		return new MembershipServiceImpl(dao);
	}
	
	@Bean
	public PlatformTransactionManager txManager(DataSource dataSource){
		DataSourceTransactionManager ptm = new DataSourceTransactionManager();
		ptm.setDataSource(dataSource);
		return ptm;
	}
	
	
	@Bean
	public DataSource dataSource(){
		return new DummyDataSource();
	}
	/*
	@Bean
	public PlatformTransactionManager txManager(){
		return new PlatformTransactionManager() {
			
			@Override
			public void rollback(TransactionStatus arg0) throws TransactionException {
				System.out.println("--------------------------- PlatformTransactionManager.rollback --------------------------- ");
			}
			
			@Override
			public TransactionStatus getTransaction(TransactionDefinition arg0)
					throws TransactionException {
				System.out.println("--------------------------- PlatformTransactionManager.getTransaction--------------------------- ");
				return new SimpleTransactionStatus();
			}
			
			@Override
			public void commit(TransactionStatus ts) throws TransactionException {
				System.out.println("--------------------------- PlatformTransactionManager.commit--------------------------- ");
			}
		};
	}
	*/
	
	/*
	<bean id="assessdataSource" class="org.apache.commons.dbcp.BasicDataSource" destroy-method="close">
	<property name="driverClassName" value="com.mysql.jdbc.Driver" />
	<property name="url" value="jdbc:mysql://localhost:3306/assess_new1" />
	<property name="username" value="root" />
	<property name="password" value="root" />	
	<!-- <property name="initialSize" value="${com.assess.database/initialSize:10}" />
	<property name="maxActive" value="${com.assess.database/maxActive:50}" />
	<property name="maxWait" value="${com.assess.database/maxWait:1000}" /> -->
  </bean>

  <bean id="txManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
    <property name="dataSource" ref="assessdataSource"/>
  </bean>
  
  */
}
