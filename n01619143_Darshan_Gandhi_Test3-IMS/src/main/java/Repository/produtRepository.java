package Repository;

import Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface produtRepository extends JpaRepository<Product,Long> {
}
