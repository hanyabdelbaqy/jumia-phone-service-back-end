package com.jumia.repository;

import com.jumia.entity.Customer;
import com.jumia.util.GeneralUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.time.LocalDateTime;
import java.util.List;

public class CustomerCastRepositoryImpl implements CustomerCastRepository{
    @PersistenceContext
    private EntityManager entityManager;

    Logger logger = LoggerFactory.getLogger(CustomerCastRepositoryImpl.class);
    @Override
    public List<Customer> findByUserFilter(String countryCode, String regex) {
        String methodName = "findByUserFilter";
        logger.info(methodName);

        String queryStr = "SELECT C FROM Customer C";
        queryStr+=" where 1=1";
        if (!GeneralUtil.isEmptyString(countryCode)) {
            queryStr+= " and C.phone like :countryCode";
        }
        if(!GeneralUtil.isEmptyString(regex)){
            queryStr +=" and I.phone REGEXP = :regex";
        }
        logger.info(methodName + " SQL = " + queryStr);
        Query query = entityManager.createQuery(queryStr, Customer.class);
        logger.info(methodName +countryCode);
        if (!GeneralUtil.isEmptyString(countryCode)) {
            query.setParameter("countryCode", countryCode+"%");
        }
        if (!GeneralUtil.isEmptyString(regex)) {
            query.setParameter("regex", regex);
        }
        return query.getResultList();
    }
}
