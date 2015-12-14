package cz.mufi.PA165.RentalConstructionMachinery.service;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Matej Jakimov on 27.11.15.
 */
@Service
public class BeanMappingServiceDozerImpl implements BeanMappingService {

    @Autowired
    private DozerBeanMapper dozerBeanMapper;

    public <T> List<T> map(Collection<?> source, Class<T> destination)
    {
        List<T> mapped = new ArrayList<T>();
        for (Object o : source) {
            mapped.add(map(o, destination));
        }
        return mapped;
    }

    public <T> T map(Object source, Class<T> destination) {
        return dozerBeanMapper.map(source, destination);
    }
}
