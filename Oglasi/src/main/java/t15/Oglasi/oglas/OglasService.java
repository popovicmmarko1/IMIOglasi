package t15.Oglasi.oglas;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class OglasService {

    @Autowired
    private final OglasRepository oglasRepository;

    public Oglas postaviOglas(Oglas request) {
        return oglasRepository.save(request);
    }

    public Page<Oglas> findByPagingCriteria(String search, String grad, String oblast, String obrazovanje, String ri, String tip, String pol, String rv, Pageable pageable) {

        Page<Oglas> page = oglasRepository.findAll(new Specification<Oglas>() {
            @Override
            public Predicate toPredicate(Root<Oglas> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                System.out.println("Usao sam u metodu!");
                if (search != null) {
                    if(!search.equals(""))
                        predicates.add(criteriaBuilder.and(criteriaBuilder.like(root.get("name"), "%" + search + "%")));
                }

                if (grad != null) {
                    if(!grad.equals(""))
                        predicates.add(criteriaBuilder.and(criteriaBuilder.like(root.get("mesto"), "%" + grad + "%")));
                }

                if (oblast != null) {
                    if(!oblast.equals(""))
                        predicates.add(criteriaBuilder.and(criteriaBuilder.like(root.get("oblast"), "%" + oblast + "%")));
                }

                if (obrazovanje != null) {
                    predicates.add(criteriaBuilder.and(criteriaBuilder.like(root.get("obrazovanje"), "%" + obrazovanje + "%")));
                }

                if (ri != null) {
                    predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("ri"), ri)));
                }

                if (tip != null) {
                    predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("tip"), tip)));
                }

                if (pol != null) {
                    predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("pol"), pol)));
                }
                if (rv != null) {
                    predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("rv"), rv)));
                }
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        }, pageable);
        page.getTotalElements();        // get total elements
        page.getTotalPages();           // get total pages

        return page;       // get List of Employee
    }

}
