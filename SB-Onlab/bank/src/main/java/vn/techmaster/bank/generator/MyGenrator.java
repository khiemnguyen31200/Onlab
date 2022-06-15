package vn.techmaster.bank.generator;
import java.io.Serializable;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.apache.commons.lang3.RandomStringUtils;


    public class MyGenrator implements IdentifierGenerator {
        @Override
        public Serializable generate(SharedSessionContractImplementor sharedSessionContractImplementor, Object o) throws HibernateException {
            return RandomStringUtils.randomAlphanumeric(10);
        }
    }

