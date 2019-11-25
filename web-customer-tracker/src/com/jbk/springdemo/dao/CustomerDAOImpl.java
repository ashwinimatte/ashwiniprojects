package com.jbk.springdemo.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jbk.springdemo.entity.Customer;
 
@Repository
public class CustomerDAOImpl implements CustomerDAO {

	//need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Customer> getCustomers() {
		
		//get the current hibernate session
		
		 Session currentSession= sessionFactory.getCurrentSession();
	
		//create a query...sort by last name
		 Query<Customer> thequery=currentSession.createQuery("from Customer order by lastName", 
				 
				                                               Customer.class);
		
		//execute query and get result list
		 List<Customer> customers = thequery.getResultList();
		
		//return the result

		return customers;
	}
     @Override
     @Transactional
	public void saveCustomer(Customer theCustomer) {
		// TODO Auto-generated method stub
		
		//get the hibernate session
		
		Session currentSession=sessionFactory.getCurrentSession();
		
		//save the customer.
		currentSession.saveOrUpdate(theCustomer);
		
	}
	@Override
	public Customer getCustomers(int theId) {
		
		// get the current hibernate session 
		Session currentSession=sessionFactory.getCurrentSession();
		
		//now retrieve/read from database using the primary key
		Customer thecustomer=currentSession.get(Customer.class, theId);
		
		return thecustomer;
	}
	@Override
	public void deleteCustomer(int theId) {
		
		Session currentSession=sessionFactory.getCurrentSession();
		
		
		 Query<Customer> thequery=currentSession.createQuery(" delete from Customer where id=:customerId"); 
				 
         thequery.setParameter("customerId", theId);
         
         thequery.executeUpdate();
     	}

}
