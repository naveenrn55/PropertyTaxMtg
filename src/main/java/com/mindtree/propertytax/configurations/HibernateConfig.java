package com.mindtree.propertytax.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mindtree.propertytax.entity.CollectedTax;
import com.mindtree.propertytax.entity.CollectedTaxId;
import com.mindtree.propertytax.entity.PropertyType;
import com.mindtree.propertytax.entity.ResidentialStatus;
import com.mindtree.propertytax.entity.TaxCost;
import com.mindtree.propertytax.entity.TaxCostComparator;
import com.mindtree.propertytax.entity.TaxId;
import com.mindtree.propertytax.entity.Zone;

@Configuration
@EnableTransactionManagement
@ComponentScans(value = { @ComponentScan("com.mindtree.propertytax.entity")})
public class HibernateConfig {

	@Autowired
	private ApplicationContext context;

	@Bean
	public LocalSessionFactoryBean getSessionFactory() {
		LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
		factoryBean.setConfigLocation(context.getResource("classpath:hibernate.cfg.xml"));
		factoryBean.setAnnotatedClasses(CollectedTax.class , CollectedTaxId.class , PropertyType.class , ResidentialStatus.class
		    , TaxCost.class , TaxCostComparator.class , TaxId.class , Zone.class);
		return factoryBean;
	}

	@Bean
	public HibernateTransactionManager getTransactionManager() {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(getSessionFactory().getObject());
		return transactionManager;
	}

}
