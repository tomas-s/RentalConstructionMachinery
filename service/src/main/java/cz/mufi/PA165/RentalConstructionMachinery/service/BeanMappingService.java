package cz.mufi.PA165.RentalConstructionMachinery.service;

import java.util.Collection;
import java.util.List;

/**
 * Created by Matej Jakimov on 27.11.15.
 */
public interface BeanMappingService {

    <T> List<T> map(Collection<?> source, Class<T> destination);

    <T> T map(Object source, Class<T> destination);
}
